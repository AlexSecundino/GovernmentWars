package GovernmentWars;

import javax.sql.DataSource;

import Repository.EdificioDAO;

public class JDBCEdificioDAO implements EdificioDAO{

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public boolean crearCola() {
		boolean correcto = true;
		
		return correcto;
	}

	@Override
	public boolean aumentarNivelEdificio() {
		boolean correcto = true;
		
		return correcto;
	}

	@Override
	public boolean eliminarCola() {
		boolean correcto = true;
		
		return correcto;
	}

	@Override
	public boolean comprobarRequisitos() {
		boolean correcto = true;
		
		return correcto;
	}

}
