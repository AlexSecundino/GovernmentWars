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
import Classes.Tecnologia;
import Classes.Usuario;
import Repository.TecnologiaDAO;

public class JDBCTecnologiaDAO implements TecnologiaDAO{

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public boolean crearCola() {
		return false;
	}

	@Override
	public boolean eliminarCola() {
		return false;
	}

	@Override
	public boolean comprobarRequisitos() {
		return false;
	}

	@Override
	public List<Tecnologia> getTecnologias(Usuario usuario, Ciudad ciudad, int raza) {
		
		List<Tecnologia> listaTecnologias = new ArrayList<Tecnologia>();
		
		/*Saca los datos de las tecnologias nombre, tiempo y recursos que costaria investigarlas y te indica las que tienes creadas*/
		String sql = "Select ctec.nombre, ctec.nombreCiudad, tec.nombre as nombreTec, bonus, antena, sobres, jueces, tiempo from Ciudad_Tecnologias ctec right join Tecnologias tec on tec.nombre = ctec.nombre where (ctec.nombreCiudad = ? or ctec.nombreCiudad is null) AND (ctec.usuario = ? or ctec.usuario is null) and (raza = ? or raza is null)";
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ciudad.getNombre());
			ps.setString(2, usuario.getUsuario());
			
			switch(raza){
				case 1:
					ps.setString(3, Raza.Anarquista.toString());
					break;
				case 2:
					ps.setString(3, Raza.Socialdemocrata.toString());
					break;
				case 3:
					ps.setString(3, Raza.Liberal.toString());
					break;
			}
			
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
				
				if(rs.getString("nombre") != null && rs.getString("nombreCiudad") != null){
					isInvestigada = true;
				}
				
				Tecnologia tecnologia = new Tecnologia(rs.getString("nombreTec"), listaRecursos, rs.getInt("bonus"), tiempoConstruccion, isInvestigada);
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
