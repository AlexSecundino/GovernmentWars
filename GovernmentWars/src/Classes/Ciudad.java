package Classes;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class Ciudad {

	private String nombre;
	
	private String coordenadas;
	
	private HashMap<Recursos,Integer> recursos;
	
	private int nivelCorrupcion;
	
	private Date ultimaFechaActualizacion;

	public Ciudad(){}
	
	public Ciudad(String ciudad) {
		this.nombre = ciudad;
	}
	
	public Ciudad(String nombre, String coordenadas, HashMap<Recursos,Integer> recursos, int nivelCorrupcion, Date ultimaFechaActualizacion) {
		this.nombre = nombre;
		this.coordenadas = coordenadas;
		this.recursos = recursos;
		this.nivelCorrupcion = nivelCorrupcion;
		this.ultimaFechaActualizacion = ultimaFechaActualizacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	public HashMap<Recursos,Integer> getRecursos() {
		return recursos;
	}
	
	public int getRecurso(Recursos recurso) {
		System.out.println("METODO");
		System.out.println("Parametro: " + recurso);
		System.out.println("Listado recursos " + recursos);
		switch(recurso.toString()){
			case "Antena":
				return recursos.get(Recursos.Antena);
			case "Sobres":
				return recursos.get(Recursos.Sobres);
			case "Militantes":
				return recursos.get(Recursos.Militantes);
			case "Jueces":
				return recursos.get(Recursos.Jueces);
			default:
				return recursos.get(Recursos.Antena);
		}
	}

	public void setRecursos(HashMap<Recursos,Integer> recursos) {
		this.recursos = recursos;
	}

	public int getNivelCorrupcion() {
		return nivelCorrupcion;
	}

	public void setNivelCorrupcion(int nivelCorrupcion) {
		this.nivelCorrupcion = nivelCorrupcion;
	}

	public Date getUltimaFechaActualizacion() {
		return ultimaFechaActualizacion;
	}

	public void setUltimaFechaActualizacion(Date ultimaFechaActualizacion) {
		this.ultimaFechaActualizacion = ultimaFechaActualizacion;
	}

	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + ", coordenadas=" + coordenadas
				+ ", recursos=" + recursos + ", nivelCorrupcion="
				+ nivelCorrupcion + ", ultimaFechaActualizacion="
				+ ultimaFechaActualizacion + "]";
	}
}
