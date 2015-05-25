package GovernmentWars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import Classes.Gender;
import Classes.Raza;
import Classes.Usuario;
import Repository.UsuarioDAO;

public class JDBCUsuarioDAO implements UsuarioDAO{

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public boolean isRegistrado(Usuario usuario) {
		String sql = "Select count(*) from usuario where usuario = ? and pass = ?";
		Connection conn = null;
		ResultSet rs = null;
		boolean isRegistrado = false;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getPass());
			rs = ps.executeQuery();
			
			if(rs.next()){
				if(rs.getInt(1) >= 1){
					isRegistrado = true;
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
		return isRegistrado;
	}
	
	@Override
	public String getRaza(Usuario usuario) {
		
		String raza = "";
		String sql = "Select raza from usuario where usuario = ?";
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			rs = ps.executeQuery();
			
			if(rs.next()){
				raza = rs.getString("raza");
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

		return raza;
	}
	
	@Override
	public Usuario getUsuario(Usuario usuario) {
		
		Usuario datosUsuario = new Usuario();
		
		String sql = "Select p.usuario, genero, pais, descripcion, raza from perfil p inner join usuario u on u.usuario = p.usuario where p.usuario = ?";
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			rs = ps.executeQuery();
			
			if(rs.next()){
				datosUsuario.setUsuario(rs.getString("usuario"));
				if(rs.getString("genero") != null){
					if(rs.getString("genero").equals("H")){
						datosUsuario.setGenero(Gender.Hombre);
					}else if(rs.getString("genero").equals("M")){
						datosUsuario.setGenero(Gender.Mujer);
					}
				}
				datosUsuario.setPais(rs.getString("pais"));
				datosUsuario.setDescripcion(rs.getString("descripcion"));
				datosUsuario.setFaccion(rs.getString("raza"));
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

		System.out.println(datosUsuario);
		return datosUsuario;
	}

	@Override
	public boolean registrarUsuario(Usuario usuario) {
		
		/*Los usuarios que se registran nunca son administradores*/
		String sql = "Insert into Usuario (usuario, pass, raza, admin) values (?, ?, ?, ?)";
		Connection conn = null;
		boolean correcto = true;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getPass());
			ps.setString(3,usuario.getFaccion());			
			ps.setBoolean(4, false);
			
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
}
