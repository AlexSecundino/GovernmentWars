package Repository;

import java.util.List;

import Classes.Bonus;
import Classes.Ciudad;
import Classes.Recursos;

public interface CiudadDAO {

	public boolean cambiarNombre();
	
	public List<Recursos> cargarRecursos();
	
	public boolean actualizarCiudad();
	
	public boolean implementarBonus(List<Bonus> listaBonus); //Algoritmia para implementar los bonus en los recursos, capacidad de nuevas tropas etc 
}
