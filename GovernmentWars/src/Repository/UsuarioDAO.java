package Repository;

import Classes.Usuario;

public interface UsuarioDAO {
		
		public boolean isRegistrado(Usuario usuario); 
	
	    public Usuario getUsuario(Usuario usuario);

	    public boolean registrarUsuario(Usuario usuario);
}
