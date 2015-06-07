package Repository;

import java.util.List;

import Classes.Mensaje;
import Classes.Usuario;

public interface MensajeDAO {
	
	public boolean enviarMensaje(Usuario remitente, Usuario destinatario, Mensaje mensaje);
	
	public boolean eliminarMensaje(Mensaje mensaje);
	
	public boolean mensajeLeido(Mensaje mensaje);
	
	public boolean comprobarNuevoMensaje(Usuario destinatario);

	public List<Mensaje> cargarMensajes(Usuario destinatario);
}
