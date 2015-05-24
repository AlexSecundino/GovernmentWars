package Repository;

import java.util.HashMap;
import java.util.List;

import Classes.Ciudad;
import Classes.Recursos;
import Classes.Requisitos;
import Classes.Unidad;
import Classes.Usuario;

public interface UnidadDAO {

	public String crearCola(Usuario usuario, Ciudad ciudad, Unidad unidad, HashMap<Recursos, Integer> recursos);
	
	public boolean recursosNecesarios(Unidad unidad, HashMap<Recursos, Integer> recursos);
	
	public List<Unidad> getUnidades(Usuario usuario, Ciudad ciudad);
	
	public List<Unidad> getTodasUnidades(Usuario usuario, Ciudad ciudad, String raza);
	
	public boolean cumpleRequisitos(Usuario usuario, Ciudad ciudad, String unidad);
	
	public Requisitos getRequisitos(String nombreTecnologia);
}
