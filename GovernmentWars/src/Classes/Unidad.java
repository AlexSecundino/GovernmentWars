package Classes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Unidad {

	private String nombre;
	private int cantidad;
	private int ataque;
	private int defensa;
	private int speed;
	private int capacidad;
	private HashMap<Recursos, Integer> recursos;
	private Date tiempoConstruccion;
	private boolean cumpleRequisitos;
	private Requisitos requisitos;
	private String pathImg;
	
	public Unidad(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	public Unidad(String nombre, int ataque, int defensa, int speed, int capacidad, HashMap<Recursos, Integer> recursos, Date tiempoConstruccion, boolean cumpleRequisitos, Requisitos requisitos) {
		this.nombre = nombre;
		this.ataque = ataque;
		this.defensa = defensa;
		this.speed = speed;
		this.capacidad = capacidad;
		this.recursos = recursos;
		this.tiempoConstruccion = tiempoConstruccion;
		this.cumpleRequisitos = cumpleRequisitos;
		this.requisitos = requisitos;
	}
	
	public Unidad(String nombre, int cantidad, int ataque, int defensa, int speed, HashMap<Recursos, Integer> recursos, Date tiempoConstruccion) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.ataque = ataque;
		this.defensa = defensa;
		this.speed = speed;
		this.recursos = recursos;
		this.tiempoConstruccion = tiempoConstruccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getRecurso(String recurso) {
		
		int rec = 0;
		
		switch(recurso){
			case "Sobres":
				rec = recursos.get(Recursos.Sobres);
				break;
			case "Antena":
				rec = recursos.get(Recursos.Antena);
				break;
			case "Jueces":
				rec = recursos.get(Recursos.Jueces);
				break;
			case "Militantes":
				rec = recursos.get(Recursos.Militantes);
				break;
		
		}
		return rec; 
	}
	
	public HashMap<Recursos, Integer> getRecursos() {
		return recursos;
	}

	public void setRecursos(HashMap<Recursos, Integer> recursos) {
		this.recursos = recursos;
	}

	public Date getTiempoConstruccion() {
		return tiempoConstruccion;
	}

	public void setTiempoConstruccion(Date tiempoConstruccion) {
		this.tiempoConstruccion = tiempoConstruccion;
	}

	public boolean getCumpleRequisitos() {
		return cumpleRequisitos;
	}

	public void setCumpleRequisitos(boolean cumpleRequisitos) {
		this.cumpleRequisitos = cumpleRequisitos;
	}
	
	public Requisitos getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(Requisitos requisitos) {
		this.requisitos = requisitos;
	}

	public String getPathImg() {
		return pathImg;
	}

	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}

	@Override
	public String toString() {
		return "Unidad [nombre=" + nombre + ", ataque=" + ataque + ", defensa="
				+ defensa + ", speed=" + speed + ", recursos=" + recursos
				+ ", tiempoConstruccion=" + tiempoConstruccion + ", pathImg="
				+ pathImg + "]";
	}
	
	public String formatearTiempo(Date fecha){
		
		String cadenaTiempo = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("d:H:mm:ss");
		
		String tiempoConstruccion = sdf.format(fecha);
	
		String[] tiempo = tiempoConstruccion.split(":");
		
		int dias = Integer.parseInt(tiempo[0]);
		int horas = Integer.parseInt(tiempo[1]);
		int minutos = Integer.parseInt(tiempo[2]);
		int segundos = Integer.parseInt(tiempo[3]);

		/*Las fechas empiezan el 1 de enero; 1 de Enero equivale al primer dia, es decir, dia 0*/
		if(dias <= 1){
			dias = 0;
			cadenaTiempo = horas + "h:" + minutos + "m:" + segundos + "s";
		}
		else{
			dias--;
			cadenaTiempo = dias + "d:" + horas + "h:" + minutos + "m:" + segundos + "s";
		}
		
		return cadenaTiempo;
	}
}
