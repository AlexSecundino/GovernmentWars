package Repository;

import java.util.List;

import Classes.Ciudad;
import Classes.Edificio;
import Classes.Usuario;
import Classes.Tecnologia;

public interface TecnologiaDAO {

	public boolean crearCola();
	
	public boolean eliminarCola();
	
	public boolean comprobarRequisitos();
	
	public List<Tecnologia> getTecnologias(Usuario usuario, Ciudad ciudad, String raza);
}
