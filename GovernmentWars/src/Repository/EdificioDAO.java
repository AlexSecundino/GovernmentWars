package Repository;

import Classes.Edificio;

public interface EdificioDAO {

	public boolean crearCola();
	
	public boolean aumentarNivelEdificio();
	
	public boolean eliminarCola();
	
	public boolean comprobarRequisitos();
}
