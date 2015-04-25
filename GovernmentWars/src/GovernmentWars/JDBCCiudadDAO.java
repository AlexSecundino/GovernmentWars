package GovernmentWars;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Classes.Bonus;
import Classes.Recursos;
import Repository.CiudadDAO;

public class JDBCCiudadDAO implements CiudadDAO{

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public boolean cambiarNombre() {
		boolean correcto = true;
		
		return correcto;
	}

	@Override
	public List<Recursos> cargarRecursos() {
		List<Recursos> listaRecursos = new ArrayList<>();
		
		return listaRecursos;
	}

	@Override
	public boolean actualizarCiudad() {
		boolean correcto = true;
		
		return correcto;
	}

	@Override
	public boolean implementarBonus(List<Bonus> listaBonus) {
		boolean correcto = true;
		
		return correcto;
	}
}
