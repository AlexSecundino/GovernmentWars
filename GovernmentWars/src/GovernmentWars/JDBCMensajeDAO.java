package GovernmentWars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
	public boolean enviarMensaje(Usuario remitente, Usuario destinatario, Mensaje mensaje) {
		
		boolean correcto = true;
		
		String sql = "Insert into Mensajes (fecha, remitente, destinatario, asunto, mensaje) values (?, ?, ?, ?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(new Date().getTime()));
			ps.setString(2, remitente.getUsuario());
			ps.setString(3, destinatario.getUsuario());
			ps.setString(4, mensaje.getAsunto());			
			ps.setString(5, mensaje.getMensaje());
			
			ps.executeUpdate();
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
	public boolean eliminarMensaje(Mensaje mensaje) {
		boolean correcto = false;
		
		String sql = "delete from mensajes where idMensaje = ?";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mensaje.getId());
			
			if(ps.executeUpdate() >= 1){
					correcto  = true;
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
		
		String sql = "Select idMensaje, remitente, destinatario, asunto, mensaje, fecha, leido from mensajes where destinatario = ?";
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, destinatario.getUsuario());
			rs = ps.executeQuery();
			
			while(rs.next()){
				Mensaje mensaje = new Mensaje(rs.getInt("idMensaje"), rs.getString("remitente"), rs.getString("destinatario"), rs.getString("asunto"), rs.getString("mensaje"), rs.getDate("fecha"), rs.getBoolean("leido"));
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

}
