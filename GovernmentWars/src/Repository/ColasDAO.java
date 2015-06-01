package Repository;

import java.util.List;

import Classes.Ciudad;
import Classes.ColaConstruccion;
import Classes.LogAtaques;
import Classes.Usuario;

public interface ColasDAO {

	public List<ColaConstruccion> getColas(Usuario usuario, Ciudad ciudad);
	
	public boolean implementarColas(Usuario usuario, Ciudad ciudad);

	public boolean crearColaAtaque(Usuario usuario, Ciudad ciudad, Usuario usuarioDefensor, Ciudad ciudadDefensor);

	public boolean comprobarNuevoLogAtaque(Usuario usuario);
	
	public List<LogAtaques> getLogsAtaques(Usuario usuario);
}
