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
import Classes.Recursos;
import Classes.Requisitos;
import Classes.Tecnologia;
import Classes.Unidad;
import Classes.Usuario;
import Repository.UnidadDAO;

public class JDBCUnidadDAO implements UnidadDAO{

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Unidad> getUnidades(Usuario usuario, Ciudad ciudad) {
		
		System.out.println(usuario);
		System.out.println(ciudad);
		
		List<Unidad> listaUnidades = new ArrayList<Unidad>();
		
		/*Saca el nombre y cantidad de las unidades que tienes en tu ciudad*/
		String sql = "Select u.unidad, cu.cantidad from unidades u inner join ciudad_unidades cu on u.unidad = cu.unidad where nombreCiudad = ? and usuario = ?";
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ciudad.getNombre());
			ps.setString(2, usuario.getUsuario());
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				Unidad unidad = new Unidad(rs.getString("unidad"), rs.getInt("cantidad"));
				listaUnidades.add(unidad);
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
		
		return listaUnidades;
	}

	@Override
	 public boolean cumpleRequisitos(Usuario usuario, Ciudad ciudad, String unidad) {
	  
	  boolean cumple = false;
	  String sql = "Select count(*), ru.nombreTecnologia, ct.nombreCiudad from RequisitosUnidades ru inner join ciudad_edificios ce on (ru.nombreEdificio = ce.nombre and ru.nivelEdificio <= ce.nivel) left join ciudad_tecnologias ct on ((ru.nombreTecnologia = ct.nombre or ru.nombreTecnologia is null) and (ct.nombreCiudad = ? and ct.usuario = ?)) where ((ce.nombreCiudad = ? and ce.usuario = ?) or (ct.nombreCiudad = ? and ct.usuario = ?)) and ru.unidad = ?";
	  Connection conn = null;
	  ResultSet rs = null;
	  
	  try {
	   conn = dataSource.getConnection();
	   PreparedStatement ps = conn.prepareStatement(sql);
	   ps.setString(1, ciudad.getNombre());
	   ps.setString(2, usuario.getUsuario());
	   ps.setString(3, ciudad.getNombre());
	   ps.setString(4, usuario.getUsuario());
	   ps.setString(5, ciudad.getNombre());
	   ps.setString(6, usuario.getUsuario());
	   ps.setString(7, unidad);
	   
	   rs = ps.executeQuery();

	   if(rs.next()){
	    if(rs.getInt(1) >= 1){
	     if(rs.getString("nombreTecnologia") != null){
	      if(rs.getString("nombreCiudad") != null){
	       cumple = true;
	      }
	      else{
	       cumple = false;
	      }
	     }
	     else{
	      cumple = true;
	     }
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
	public Requisitos getRequisitos(String unidad) {
		String sql = "Select nombreEdificio, nivelEdificio, nombreTecnologia from RequisitosUnidades where unidad = ?";
		Connection conn = null;
		ResultSet rs = null;
		
		Requisitos requisitos = new Requisitos();
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, unidad);
			
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
	public List<Unidad> getTodasUnidades(Usuario usuario, Ciudad ciudad, String raza) {
		
		System.out.println(usuario);
		System.out.println(ciudad);
		
		List<Unidad> listaUnidades = new ArrayList<Unidad>();
		
		String sql = "Select u.unidad as nombreUnidad, ataque, defensa, velocidad, capacidad, antena, sobres, jueces, militantes, tiempoConstruccion from Unidades u where (raza = ? or raza is null);";
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, raza);
			
			rs = ps.executeQuery();

			while(rs.next()){
				
				HashMap<Recursos,Integer> listaRecursos = new HashMap<Recursos,Integer>();
				listaRecursos.put(Recursos.Sobres, rs.getInt("sobres"));
				listaRecursos.put(Recursos.Antena, rs.getInt("antena"));
				listaRecursos.put(Recursos.Jueces, rs.getInt("jueces"));
				listaRecursos.put(Recursos.Militantes, rs.getInt("militantes"));
				
				/*Las fechas necesitan milisegundos*/
				int tiempo = rs.getInt("tiempoConstruccion") * 1000;
				/*Empieza el 1 de Enero a la 1:00, se necesita disminuir ese tiempo*/
				Date tiempoConstruccion = new Date(-3600 * 1000 + tiempo);
				
				boolean cumpleRequisitos = true;
				Requisitos requisitos = new Requisitos();
				
				
				if(!cumpleRequisitos(usuario, ciudad, rs.getString("nombreUnidad"))){
					cumpleRequisitos = false;
					requisitos = getRequisitos(rs.getString("nombreUnidad"));
					System.out.println("requisitos: " + requisitos);
				}
				
				Unidad unidad = new Unidad(rs.getString("nombreUnidad"), rs.getInt("ataque"), rs.getInt("defensa"), rs.getInt("velocidad"), rs.getInt("capacidad"), listaRecursos, tiempoConstruccion, cumpleRequisitos, requisitos);
				listaUnidades.add(unidad);
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
		
		return listaUnidades;
	}

	@Override
	public boolean crearCola(Usuario usuario, Ciudad ciudad, Unidad unidad, HashMap<Recursos, Long> recursos) {
		
		boolean correcto = false;
		
		String sql = "call crearColaUnidad(?, ?, ?, ?, ?, ?, ?);";
		Connection conn = null;
		ResultSet rs = null;
			
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ciudad.getNombre());
			ps.setString(2, usuario.getUsuario());
			ps.setString(3, unidad.getNombre());
			ps.setInt(4, unidad.getCantidad());
			ps.setLong(5, recursos.get(Recursos.Sobres));
			ps.setLong(6, recursos.get(Recursos.Antena));
			ps.setLong(7, recursos.get(Recursos.Jueces));
				
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
	public boolean recursosNecesarios(Unidad unidad, HashMap<Recursos, Integer> recursos) {
		
		boolean recursosNecesarios = false;
		
		String sql = "Select count(*) from unidades where unidad = ? and (sobres * ? <= ? and antena  * ? <= ? and jueces * ? <= ? and militantes * ? <= ?)";
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, unidad.getNombre());
			ps.setInt(2, unidad.getCantidad());
			ps.setInt(3, recursos.get(Recursos.Sobres));
			ps.setInt(4, unidad.getCantidad());
			ps.setInt(5, recursos.get(Recursos.Antena));
			ps.setInt(6, unidad.getCantidad());
			ps.setInt(7, recursos.get(Recursos.Jueces));
			ps.setInt(8, unidad.getCantidad());
			ps.setInt(9, recursos.get(Recursos.Militantes));
			
			rs = ps.executeQuery();

			if(rs.next()){
				if(rs.getInt(1) >= 1){
					recursosNecesarios = true;
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
		return recursosNecesarios;
	}
}
