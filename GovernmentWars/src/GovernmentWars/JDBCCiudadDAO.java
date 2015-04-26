package GovernmentWars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import Classes.Bonus;
import Classes.Ciudad;
import Classes.Gender;
import Classes.Recursos;
import Classes.Usuario;
import Repository.CiudadDAO;

public class JDBCCiudadDAO implements CiudadDAO{

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Ciudad getCiudad(Usuario usuario) {
		Ciudad ciudad = new Ciudad();

		String sql = "Select nombreCiudad, coordenadas, antena, sobres, militantes, jueces, corrupcion, ultimaActualizacion from ciudad where usuario = ?";
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			rs = ps.executeQuery();
			
			if(rs.next()){
				ciudad.setNombre(rs.getString("nombreCiudad"));
				ciudad.setCoordenadas(rs.getString("coordenadas"));
				
				HashMap<Recursos,Integer> listaRecursos = new HashMap<Recursos,Integer>();
				listaRecursos.put(Recursos.Antena, rs.getInt("antena"));
				listaRecursos.put(Recursos.Sobres, rs.getInt("sobres"));
				listaRecursos.put(Recursos.Militantes, rs.getInt("militantes"));
				listaRecursos.put(Recursos.Jueces, rs.getInt("jueces"));
				ciudad.setRecursos(listaRecursos);

				ciudad.setNivelCorrupcion(rs.getInt("corrupcion"));
				ciudad.setUltimaFechaActualizacion(rs.getDate("ultimaActualizacion"));
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

		System.out.println(ciudad);
		
		return ciudad;
	}
	
	@Override
	public boolean cambiarNombre(String antiguoNombre, String nombre) {

		boolean correcto = false;

		String sql = "update ciudad set nombreCiudad = ? where nombreCiudad = ? AND usuario ='alex'";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, antiguoNombre);
			
			if(ps.executeUpdate() == 1){
				correcto = true;
			}
			
			
			ps.close();
 
		} catch (SQLException e) {
			correcto = false;
			 
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
	public List<Recursos> cargarRecursos() {
		List<Recursos> listaRecursos = new ArrayList<>();
		
		return listaRecursos;
	}

	@Override
	public boolean actualizarCiudad() {
		boolean correcto = true;
		
		return correcto;
	}

	@Override
	public boolean implementarBonus(List<Bonus> listaBonus) {
		boolean correcto = true;
		
		return correcto;
	}
}
