package Repository;

import java.util.HashMap;
import java.util.List;

import Classes.Ciudad;
import Classes.Edificio;
import Classes.Recursos;
import Classes.Requisitos;
import Classes.Unidad;
import Classes.Usuario;
import Classes.Tecnologia;

public interface TecnologiaDAO {

	public boolean crearCola(Usuario usuario, Ciudad ciudad, Tecnologia tecnologia, HashMap<Recursos, Long> recursos);
	
	public boolean cumpleRequisitos(Usuario usuario, Ciudad ciudad, String tecnologia);
	
	public Requisitos getRequisitos(String nombreTecnologia);
	
	public List<Tecnologia> getTecnologias(Usuario usuario, Ciudad ciudad, String raza);
}
