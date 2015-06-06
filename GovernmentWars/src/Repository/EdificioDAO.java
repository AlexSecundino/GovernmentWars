package Repository;

import java.util.HashMap;
import java.util.List;

import Classes.Ciudad;
import Classes.Edificio;
import Classes.Recursos;
import Classes.Unidad;
import Classes.Usuario;

public interface EdificioDAO {

	public boolean crearCola(Usuario usuario, Ciudad ciudad, Edificio edificio, HashMap<Recursos, Long> recursos);
	
	public List<Edificio> getEdificios(Usuario usuario, Ciudad ciudad);
}
