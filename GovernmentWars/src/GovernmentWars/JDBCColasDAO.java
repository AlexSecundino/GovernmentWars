package GovernmentWars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import Classes.Ciudad;
import Classes.ColaConstruccion;
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
}
