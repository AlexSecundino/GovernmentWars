package Classes;

import java.util.List;

public class Usuario {

	private String usuario;
	private String pass;
	private Gender genero;
	//private String email;	
	private String descripcion;
	private String pais;
	private Raza raza;
	
	public Usuario() {
		super();
	}

	public Usuario(String usuario) {
		this.usuario = usuario;
	}
	
	public Usuario(String usuario, String pass) {
		this.usuario = usuario;
		this.pass = pass;
	}
	
	public Usuario(String usuario, Gender genero, String descripcion, String pais) {
		this.usuario = usuario;
		this.genero = genero;
		this.descripcion = descripcion;
		this.pais = pais;
	}

	
	public Usuario(String usuario, String pass, Gender genero, String descripcion, String pais) {
		this.usuario = usuario;
		this.pass = pass;
		this.genero = genero;
		this.descripcion = descripcion;
		this.pais = pais;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Gender getGenero() {
		return genero;
	}

	public void setGenero(Gender genero) {
		this.genero = genero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", pass=" + pass + ", genero="
				+ genero + ", descripcion=" + descripcion + ", pais=" + pais
				+ ", raza=" + raza + "]";
	}
}
