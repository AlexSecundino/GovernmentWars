package GovernmentWars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Classes.Mensaje;
import Classes.Usuario;
import Repository.MensajeDAO;

public class JDBCMensajeDAO implements MensajeDAO{

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public boolean enviarMensaje(Usuario destinatario) {
		return false;
	}

	@Override
	public boolean eliminarMensaje(Mensaje mensaje) {
		return false;
	}
	
	@Override
	public boolean comprobarNuevoMensaje(Usuario destinatario) {
		
		boolean nuevoMensaje = false;
		
		String sql = "Select count(*) from mensajes where destinatario = ? AND leido = ?";
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, destinatario.getUsuario());
			ps.setBoolean(2, false);
			rs = ps.executeQuery();
			
			if(rs.next()){
				if(rs.getInt(1) >= 1){
					nuevoMensaje = true;
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
		return nuevoMensaje;
	}

	@Override
	public List<Mensaje> cargarMensajes(Usuario destinatario) {
		
		List<Mensaje> listaMensajes = new ArrayList<>();
		
		String sql = "Select remitente, destinatario, asunto, mensaje, fecha, leido from mensajes where destinatario = ?";
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, destinatario.getUsuario());
			rs = ps.executeQuery();
			
			while(rs.next()){
				Mensaje mensaje = new Mensaje(rs.getString("remitente"), rs.getString("destinatario"), rs.getString("asunto"), rs.getString("mensaje"), rs.getDate("fecha"), rs.getBoolean("leido"));
				System.out.println(mensaje);
				listaMensajes.add(mensaje);
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
		return listaMensajes;
	}

	@Override
	public List<Mensaje> cargarTodosLosMensajes() {
		return null;
	}

}
