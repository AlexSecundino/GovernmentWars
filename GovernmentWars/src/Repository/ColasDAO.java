package Repository;

import java.util.List;

import Classes.Ciudad;
import Classes.ColaConstruccion;
import Classes.Usuario;

public interface ColasDAO {

	public List<ColaConstruccion> getColas(Usuario usuario, Ciudad ciudad);
}
