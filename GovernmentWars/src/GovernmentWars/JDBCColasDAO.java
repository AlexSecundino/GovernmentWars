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
import Classes.ColaConstruccion;
import Classes.Edificio;
import Classes.LogAtaques;
import Classes.Recursos;
import Classes.Usuario;
import Classes.Utils;
import Repository.ColasDAO;

public class JDBCColasDAO implements ColasDAO{

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<ColaConstruccion> getColas(Usuario usuario, Ciudad ciudad){
		
		List<ColaConstruccion> colas = new ArrayList<ColaConstruccion>();
		
		String sql = "SELECT nombreEdificio as Nombre, horaInicio as Tiempo, tiempoConstruccion as TiempoConstruccion from ColaConstruccionEdificios where usuario = ? and nombreCiudad = ?"
						+ " UNION "
				+ "SELECT tecnologia as Nombre,  horaInicio as Tiempo, tiempoConstruccion as TiempoConstruccion from ColaConstruccionTecnologias where usuario = ? and nombreCiudad = ?"
						+ " UNION "
				+ "SELECT unidad as Nombre, horaInicio as Tiempo, tiempoConstruccion as TiempoConstruccion from ColaConstruccionUnidades where usuario = ? and nombreCiudad = ?";
		
		Connection conn = null;
		ResultSet rs = null;
			
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, ciudad.getNombre());
			ps.setString(3, usuario.getUsuario());
			ps.setString(4, ciudad.getNombre());
			ps.setString(5, usuario.getUsuario());
			ps.setString(6, ciudad.getNombre());
				
			rs = ps.executeQuery();
			
			while(rs.next()){
				String nombre = rs.getString("Nombre");
				Date horaInicio = new Date(rs.getTimestamp("Tiempo").getTime());
				Date tiempoConstruccion = new Date(-3600 * 1000 + (rs.getInt("TiempoConstruccion") * 1000));
				
				Date horaActual = new Date();
				
				Date tiempoTranscurrido = new Date(-3600 * 1000 + horaActual.getTime() - horaInicio.getTime());
				
				Date tiempoRestante = new Date(-3600 * 1000 + tiempoConstruccion.getTime() - tiempoTranscurrido.getTime());
				
				
				System.out.println(nombre + "Tiempo construccion " + Utils.formatearTiempo(tiempoConstruccion));
				System.out.println("Tiempo transcurrido " + Utils.formatearTiempo(tiempoTranscurrido));
				System.out.println("Tiempo restante " + Utils.formatearTiempo(tiempoRestante));
				
				if(tiempoConstruccion.getTime() - tiempoTranscurrido.getTime() >= 0){ 
					
					ColaConstruccion cola = new ColaConstruccion(nombre, tiempoRestante); 
					colas.add(cola);
					System.out.println(cola);
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
		
		return colas;
	}
	
	public boolean implementarColas(Usuario usuario, Ciudad ciudad){
		
		boolean correcto = true;
		
		String sql = "call actualizarJuego(?, ?);";
		Connection conn = null;
		ResultSet rs = null;
			
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ciudad.getNombre());
			ps.setString(2, usuario.getUsuario());
				
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
	public boolean crearColaAtaque(Usuario usuario, Ciudad ciudad, Usuario usuarioDefensor, Ciudad ciudadDefensor) {
		
		boolean correcto = true;
		
		if(usuario.getUsuario().equals(usuarioDefensor.getUsuario())){
			return false;
		}
		
		String sql = "call crearColaAtaque(?, ?, ?, ?, ?, ?);";
		Connection conn = null;
		ResultSet rs = null;
			
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ciudad.getNombre());
			ps.setString(2, ciudadDefensor.getNombre());
			ps.setString(3, usuario.getUsuario());
			ps.setString(4, usuarioDefensor.getUsuario());
			
			String coords = ciudad.getCoordenadas();
			String coordsXY[] = coords.split(":");
			
			ps.setInt(5, Integer.valueOf(coordsXY[0]));
			ps.setInt(6, Integer.valueOf(coordsXY[1]));
				
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
	public boolean comprobarNuevoLogAtaque(Usuario usuario) {
		
		boolean nuevoLogAtaque = false;
		
		String sql = "Select count(*) from LogAtaque where (usuarioAtacante = ? or usuarioDefensor = ?) AND leido = ?";
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getUsuario());
			ps.setBoolean(3, false);
			rs = ps.executeQuery();
			
			if(rs.next()){
				if(rs.getInt(1) >= 1){
					nuevoLogAtaque = true;
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
		return nuevoLogAtaque;
	}

	public List<LogAtaques> getLogsAtaques(Usuario usuario){
		
		List<LogAtaques> logsAtaques = new ArrayList<LogAtaques>();
		
		String sql = "Select nombreCiudadAtacante, usuarioAtacante, nombreCiudadDefensor, usuarioDefensor, nTropasVivasAtacante, nPerdidasAtacante, nTropasVivasDefensor, nTropasPerdidasDefensor, botin, leido, fechaAtaque from LogAtaque where (usuarioAtacante = ? or usuarioDefensor = ?)";
		
		Connection conn = null;
		ResultSet rs = null;
			
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getUsuario());
				
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				HashMap<Recursos, Integer> botin = new HashMap<Recursos, Integer>();
				String b = rs.getString("botin");
				String[] rec = b.split(":");
				botin.put(Recursos.Sobres, Integer.valueOf(rec[0]));
				botin.put(Recursos.Antena, Integer.valueOf(rec[1]));
				botin.put(Recursos.Jueces, Integer.valueOf(rec[2]));
				LogAtaques log = new LogAtaques(new Usuario(rs.getString(1)), rs.getString(2), new Usuario(rs.getString(3)), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), botin, rs.getDate(11), rs.getBoolean(10));
				logsAtaques.add(log);
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
		
		return logsAtaques;
	}
}
