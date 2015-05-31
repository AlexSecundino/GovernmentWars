package GovernmentWars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import Classes.Coordenadas;
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
	public boolean isAdmin(Usuario usuario) {
		String sql = "Select count(*) from usuario where usuario = ? and admin = ?";
		Connection conn = null;
		ResultSet rs = null;
		boolean isAdmin = false;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			ps.setBoolean(2, true);
			rs = ps.executeQuery();
			
			if(rs.next()){
				if(rs.getInt(1) >= 1){
					isAdmin = true;
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
		return isAdmin;
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
	
	@Override
	public List<Usuario> getUsuarios()
	{
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		/*Saca los datos de todos los usuarios del sistema*/
		String sql = "Select u.usuario, u.raza, b.usuario as bloqueado from usuario u left join bloqueado b on u.usuario = b.usuario";
        Connection conn = null;
        ResultSet rs = null;
            
        try {
        	conn = dataSource.getConnection();
        	PreparedStatement ps = conn.prepareStatement(sql);
        	
        	rs = ps.executeQuery();
        	
        	while(rs.next()){
        		String nombre = rs.getString("usuario");
                String raza = rs.getString("raza");
                String bloqueado = rs.getString("bloqueado");
                
                Usuario usuario = new Usuario(nombre);
                usuario.setFaccion(raza);
                
                if(bloqueado != null){ 	
                    usuario.setBloqueado(true);
                }
                else{
                	usuario.setBloqueado(false);
                }
               
                listaUsuarios.add(usuario);
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
        return listaUsuarios;
     }
	
	@Override
	public boolean bloquearUsuario(Usuario usuario){
		
		boolean correcto = true;
		
		String sql = "insert into bloqueado values (?, ?)";
        Connection conn = null;
        ResultSet rs = null;
            
        try {
        	conn = dataSource.getConnection();
        	PreparedStatement ps = conn.prepareStatement(sql);
        	
        	Date fecha = new Date();
        	
        	long sec = 15 * 24 * 3600 * 1000 + new Date().getTime();
        	Date fechaBloqueo = new Date(sec);
        	ps.setString(1, usuario.getUsuario());
        	ps.setDate(2, new java.sql.Date(fechaBloqueo.getTime()));
        	
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
	public boolean desbloquearUsuario(Usuario usuario){
		
		boolean correcto = false;
		
		String sql = "delete from bloqueado where usuario = ?";
        Connection conn = null;
        ResultSet rs = null;
            
        try {
        	conn = dataSource.getConnection();
        	PreparedStatement ps = conn.prepareStatement(sql);
        	
        	ps.setString(1, usuario.getUsuario());
        	
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
	
	public List<Usuario> getCiudadesAtacar(){
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		/*Saca los datos de todos los usuarios del sistema*/
		String sql = "Select c.nombreCiudad, u.usuario, u.raza, c.coordenadas from usuario u inner join ciudad c on u.usuario = c.usuario";
        Connection conn = null;
        ResultSet rs = null;
            
        try {
        	conn = dataSource.getConnection();
        	PreparedStatement ps = conn.prepareStatement(sql);
        	
        	rs = ps.executeQuery();
        	
        	while(rs.next()){
        		String nombre = rs.getString("usuario");
                String raza = rs.getString("raza");
                String nCiudad = rs.getString("nombreCiudad");
                String[] cords = rs.getString("coordenadas").split(":");
                Coordenadas coord = new Coordenadas(Integer.valueOf(cords[0]), Integer.valueOf(cords[1]));
                
                Usuario usuario = new Usuario(nombre, coord, nCiudad);
                usuario.setFaccion(raza);
               
                listaUsuarios.add(usuario);
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
        return listaUsuarios;
	}
}
