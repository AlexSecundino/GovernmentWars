package Repository;

import java.util.List;

import Classes.Bonus;
import Classes.Ciudad;
import Classes.Recursos;
import Classes.Usuario;

public interface CiudadDAO {

	public Ciudad getCiudad(Usuario usuario);
	
	public boolean cambiarNombre(String antiguoNombre, String nombre, Usuario usuario);
	
	public List<Recursos> cargarRecursos();
	
	public boolean actualizarCiudad();
	
	public boolean implementarBonus(List<Bonus> listaBonus); //Algoritmia para implementar los bonus en los recursos, capacidad de nuevas tropas etc 
}
