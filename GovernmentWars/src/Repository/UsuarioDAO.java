package Repository;

import java.util.List;

import Classes.Usuario;

public interface UsuarioDAO {
		
		public boolean isRegistrado(Usuario usuario); 
		
		public boolean isAdmin(Usuario usuario); 
	
	    public Usuario getUsuario(Usuario usuario);

	    public boolean registrarUsuario(Usuario usuario);

		public String getRaza(Usuario usuario);
		
		public List<Usuario> getUsuarios();
		
		public boolean bloquearUsuario(Usuario usuario);
		
		public boolean desbloquearUsuario(Usuario usuario);
		
		public List<Usuario> getCiudadesAtacar();
}
