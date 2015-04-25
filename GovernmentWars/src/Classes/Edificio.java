package Classes;

import java.util.Date;
import java.util.List;

public class Edificio {

	private String nombre;
	private int nivel;
	private List<Recursos> recursos;
	private Bonus bonus;
	private Date tiempoConstruccion;
	
	public Edificio(String nombre, int nivel, List<Recursos> recursos, Bonus bonus, Date tiempoConstruccion) {
		this.nombre = nombre;
		this.nivel = nivel;
		this.recursos = recursos;
		this.bonus = bonus;
		this.tiempoConstruccion = tiempoConstruccion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public List<Recursos> getRecursos() {
		return recursos;
	}
	
	public void setRecursos(List<Recursos> recursos) {
		this.recursos = recursos;
	}
	
	public Bonus getBonus() {
		return bonus;
	}
	
	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}
	
	public Date getTiempoConstruccion() {
		return tiempoConstruccion;
	}
	
	public void setTiempoConstruccion(Date tiempoConstruccion) {
		this.tiempoConstruccion = tiempoConstruccion;
	}
	
	@Override
	public String toString() {
		return "Edificio [nombre=" + nombre + ", nivel=" + nivel
				+ ", recursos=" + recursos + ", Bonus=" + bonus
				+ ", tiempoConstruccion=" + tiempoConstruccion + "]";
	}
}


