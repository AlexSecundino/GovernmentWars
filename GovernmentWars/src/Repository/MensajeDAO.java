package Repository;

import java.util.List;

import Classes.Mensaje;
import Classes.Usuario;

public interface MensajeDAO {
	
	public boolean enviarMensaje(Usuario destinatario);
	
	public boolean eliminarMensaje(Mensaje mensaje);
	
	public boolean comprobarNuevoMensaje(Usuario destinatario);
	
	public List<Mensaje> cargarMensajes(Usuario destinatario);
	
	public List<Mensaje> cargarTodosLosMensajes();
}
