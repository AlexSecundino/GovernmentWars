package Classes;

import java.util.Date;
import java.util.List;

public class Ciudad {

	private int nombre;
	
	private int coordenadas;
	
	private List<Recursos> recursos;
	
	private int nivelCorrupcion;
	
	private Date ultimaFechaActualizacion;

	public Ciudad(int nombre, int coordenadas, List<Recursos> recursos, int nivelCorrupcion, Date ultimaFechaActualizacion) {
		this.nombre = nombre;
		this.coordenadas = coordenadas;
		this.recursos = recursos;
		this.nivelCorrupcion = nivelCorrupcion;
		this.ultimaFechaActualizacion = ultimaFechaActualizacion;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(int coordenadas) {
		this.coordenadas = coordenadas;
	}

	public List<Recursos> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recursos> recursos) {
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
}
