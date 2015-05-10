package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Classes.Ciudad;
import Classes.Requisitos;
import Classes.Unidad;
import Classes.Usuario;

public interface UnidadDAO {

	public List<Unidad> getUnidades(Usuario usuario, Ciudad ciudad);
	
	public List<Unidad> getTodasUnidades(Usuario usuario, Ciudad ciudad, String raza);
	
	public boolean cumpleRequisitos(Usuario usuario, Ciudad ciudad, String unidad);
	
	public Requisitos getRequisitos(String nombreTecnologia);
}
