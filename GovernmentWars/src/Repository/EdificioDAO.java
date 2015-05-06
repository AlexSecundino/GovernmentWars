package Repository;

import java.util.List;

import Classes.Ciudad;
import Classes.Edificio;
import Classes.Usuario;

public interface EdificioDAO {

	public boolean crearCola();
	
	public boolean aumentarNivelEdificio();
	
	public boolean eliminarCola();
	
	public boolean comprobarRequisitos();
	
	public List<Edificio> getEdificios(Usuario usuario, Ciudad ciudad);
}
