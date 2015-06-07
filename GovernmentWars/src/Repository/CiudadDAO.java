package Repository;

import java.util.HashMap;
import java.util.List;

import Classes.Bonus;
import Classes.Ciudad;
import Classes.Produccion;
import Classes.Recursos;
import Classes.Usuario;

public interface CiudadDAO {

	public Ciudad getCiudad(Usuario usuario);
	
	public Produccion getProduccion(Usuario usuario, Ciudad ciudad);
	
	public boolean cambiarNombre(String antiguoNombre, String nombre, Usuario usuario);
	
	public boolean actualizarRecursos(Usuario usuario, Ciudad ciudad); 
}
