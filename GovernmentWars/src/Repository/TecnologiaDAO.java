package Repository;

import java.util.List;

import Classes.Ciudad;
import Classes.Edificio;
import Classes.Requisitos;
import Classes.Usuario;
import Classes.Tecnologia;

public interface TecnologiaDAO {

	public boolean crearCola();
	
	public boolean eliminarCola();
	
	public boolean cumpleRequisitos(Usuario usuario, Ciudad ciudad, String tecnologia);
	
	public Requisitos getRequisitos(String nombreTecnologia);
	
	public List<Tecnologia> getTecnologias(Usuario usuario, Ciudad ciudad, String raza);
}
