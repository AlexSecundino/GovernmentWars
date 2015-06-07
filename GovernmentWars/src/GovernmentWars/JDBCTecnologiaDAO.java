package GovernmentWars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import Classes.Ciudad;
import Classes.Edificio;
import Classes.Raza;
import Classes.Recursos;
import Classes.Requisitos;
import Classes.Tecnologia;
import Classes.Unidad;
import Classes.Usuario;
import Repository.TecnologiaDAO;

public class JDBCTecnologiaDAO implements TecnologiaDAO{

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public boolean crearCola(Usuario usuario, Ciudad ciudad, Tecnologia tecnologia, HashMap<Recursos, Long> recursos) {

		boolean correcto = true;
		
		String sql = "call crearColaTecnologia(?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		ResultSet rs = null;
			
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ciudad.getNombre());
			ps.setString(2, usuario.getUsuario());
			ps.setString(3, tecnologia.getNombre());
			ps.setLong(4, recursos.get(Recursos.Sobres));
			ps.setLong(5, recursos.get(Recursos.Antena));
			ps.setLong(6, recursos.get(Recursos.Jueces));
				
			rs = ps.executeQuery();
			
			if(rs.next()){
				if(rs.getInt("correcto") >= 1){
					correcto = true;
				}
				else{
					correcto = false;
				}
			}
			else{
				correcto = false;
			}
			
			ps.close();
	 
		} catch (SQLException e) {
			throw new RuntimeException(e);
	 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return correcto;
	}
	
	@Override
	public boolean cumpleRequisitos(Usuario usuario, Ciudad ciudad, String tecnologia) {
		
		boolean cumple = false;
		
		String sql = "Select count(*) from RequisitosTecnologias rt inner join ciudad_edificios ce on (rt.nombreEdificio = ce.nombre and rt.nivelEdificio <= ce.nivel) inner join ciudad_tecnologias ct on (rt.nombreTecnologia = ct.nombre or rt.nombreTecnologia is null)"
				+ " where ((ce.nombreCiudad = ? and ce.usuario = ?) or (ct.nombreCiudad = ? and ct.usuario = ?)) and rt.tecnologia = ?";
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ciudad.getNombre());
			ps.setString(2, usuario.getUsuario());
			ps.setString(3, ciudad.getNombre());
			ps.setString(4, usuario.getUsuario());
			ps.setString(5, tecnologia);
			
			rs = ps.executeQuery();

			if(rs.next()){
				if(rs.getInt(1) >= 1){
					cumple = true;
				}
			}
			
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
		return cumple;
	}

	@Override
	public Requisitos getRequisitos(String nombreTecnologia) {
		String sql = "Select nombreEdificio, nivelEdificio, nombreTecnologia from RequisitosTecnologias where tecnologia = ?";
		Connection conn = null;
		ResultSet rs = null;
		
		Requisitos requisitos = new Requisitos();
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nombreTecnologia);
			
			rs = ps.executeQuery();

			HashMap<String, Integer> edificios = new HashMap<String, Integer>();
			List<String> tecnologias = new ArrayList<String>(); 
					
			while(rs.next()){
				
				if(rs.getString("nombreEdificio") != null){
					edificios.put(rs.getString("nombreEdificio"), Integer.valueOf(rs.getString("nivelEdificio")));
				}
				
				if(rs.getString("nombreTecnologia") != null){
					tecnologias.add(rs.getString("nombreTecnologia"));
				}
			}
			
			requisitos = new Requisitos(edificios, tecnologias);
			
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
		return requisitos;
	}
	
	@Override
	public List<Tecnologia> getTecnologias(Usuario usuario, Ciudad ciudad, String raza) {
		
		List<Tecnologia> listaTecnologias = new ArrayList<Tecnologia>();
		
		/*Saca los datos de las tecnologias nombre, tiempo y recursos que costaria investigarlas y te indica las que tienes creadas*/
		String sql = "Select ctec.nombre, ctec.nombreCiudad, tec.nombre as nombreTec, bonus, antena, sobres, jueces, tiempo from Ciudad_Tecnologias ctec right join (select * from tecnologias where raza is null or raza = ?) as tec "
				+ "on tec.nombre = ctec.nombre where ((nombreCiudad = ? or nombreCiudad is null or nombreCiudad != ?) and (usuario = ? or usuario is null or usuario != ?)) group by tec.nombre";
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, raza);
			ps.setString(2, ciudad.getNombre());
			ps.setString(3, ciudad.getNombre());
			ps.setString(4, usuario.getUsuario());
			ps.setString(5, usuario.getUsuario());
			
			rs = ps.executeQuery();

			while(rs.next()){
				
				HashMap<Recursos,Integer> listaRecursos = new HashMap<Recursos,Integer>();
				listaRecursos.put(Recursos.Antena, rs.getInt("antena"));
				listaRecursos.put(Recursos.Sobres, rs.getInt("sobres"));
				listaRecursos.put(Recursos.Jueces, rs.getInt("jueces"));
				
				/*Las fechas necesitan milisegundos*/
				int tiempo = rs.getInt("tiempo") * 1000;
				/*Empieza el 1 de Enero a la 1:00, se necesita disminuir ese tiempo*/
				Date tiempoConstruccion = new Date(-3600 * 1000 + tiempo);
				
				boolean isInvestigada = false;
				boolean cumpleRequisitos = true;
				Requisitos requisitos = new Requisitos();
				
				if(rs.getString("nombre") != null && rs.getString("nombreCiudad") != null && (rs.getString("nombreCiudad").equals(ciudad.getNombre()))){
					isInvestigada = true;
				}
				else{
					if(!cumpleRequisitos(usuario, ciudad, rs.getString("nombreTec"))){
						cumpleRequisitos = false;
						requisitos = getRequisitos(rs.getString("nombreTec"));
						System.out.println("requisitos: " + requisitos);
					}
				}
				
				Tecnologia tecnologia = new Tecnologia(rs.getString("nombreTec"), listaRecursos, rs.getInt("bonus"), tiempoConstruccion, isInvestigada, cumpleRequisitos, requisitos);
				System.out.println(tecnologia);
				listaTecnologias.add(tecnologia);
			}
			
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
		return listaTecnologias;
	}
}
