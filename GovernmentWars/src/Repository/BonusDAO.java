package Repository;

import java.util.List;

import Classes.Bonus;
import Classes.Ciudad;

public interface BonusDAO {

	public List<Bonus> cargarBonus(Ciudad ciudad);
	
	public boolean insertarBonus();
	
}
