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
import Classes.Mensaje;
import Classes.Recursos;
import Classes.Usuario;
import Repository.EdificioDAO;

public class JDBCEdificioDAO implements EdificioDAO{

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public boolean crearCola() {
		boolean correcto = true;
		
		return correcto;
	}

	@Override
	public boolean aumentarNivelEdificio() {
		boolean correcto = true;
		
		return correcto;
	}

	@Override
	public boolean eliminarCola() {
		boolean correcto = true;
		
		return correcto;
	}

	@Override
	public boolean comprobarRequisitos() {
		boolean correcto = true;
		
		return correcto;
	}

	@Override
	public List<Edificio> getEdificios(Usuario usuario, Ciudad ciudad) {
		
		System.out.println(usuario);
		System.out.println(ciudad);
		
		List<Edificio> listaEdificios = new ArrayList<Edificio>();
		
		/*Saca los datos del edificio (nombr y nivel actual) y el tiempo y recursos que costaria aumentarlo al siguiente nivel*/
		String sql = "Select ce.nombre, ce.nivel, bonus, tiempoConstruccion, antena, sobres, jueces from Ciudad_Edificios ce left join Edificios e on ce.nombre = e.nombre and e.nivel = ce.nivel + 1 where nombreCiudad = ? AND usuario = ?";
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ciudad.getNombre());
			ps.setString(2, usuario.getUsuario());
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				HashMap<Recursos,Integer> listaRecursos = new HashMap<Recursos,Integer>();
				listaRecursos.put(Recursos.Antena, rs.getInt("antena"));
				listaRecursos.put(Recursos.Sobres, rs.getInt("sobres"));
				listaRecursos.put(Recursos.Jueces, rs.getInt("jueces"));
				
				/*Las fechas necesitan milisegundos*/
				int tiempo = rs.getInt("tiempoConstruccion") * 1000;
				/*Empieza el 1 de Enero a la 1:00, se necesita disminuir ese tiempo*/
				Date tiempoConstruccion = new Date(-3600 * 1000 + tiempo);
				
				Edificio edificio = new Edificio(rs.getString("nombre"), rs.getInt("nivel"), listaRecursos, tiempoConstruccion);
				listaEdificios.add(edificio);
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
		
		return listaEdificios;
	}

}
