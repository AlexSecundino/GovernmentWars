package Repository;

import java.util.List;

import Classes.Bonus;
import Classes.Ciudad;

public interface BonusDAO {

	/*No implementado. Según las tecnologías, aumentaría el ataque de las unidades*/
	
	public List<Bonus> cargarBonus(Ciudad ciudad);
	
	public boolean insertarBonus();
	
}
