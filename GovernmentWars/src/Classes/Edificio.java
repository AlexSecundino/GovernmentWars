package Classes;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Edificio {

	private String nombre;
	private int nivel;
	private HashMap<Recursos, Integer> recursos;
	private Bonus bonus;
	private Date tiempoConstruccion;
	
	public Edificio(String nombre, int nivel, HashMap<Recursos, Integer> recursos, Date tiempoConstruccion) {
		this.nombre = nombre;
		this.nivel = nivel;
		this.recursos = recursos;
		this.tiempoConstruccion = tiempoConstruccion;
	}
	
	public Edificio(String nombre, int nivel, HashMap<Recursos, Integer> recursos, Bonus bonus, Date tiempoConstruccion) {
		this.nombre = nombre;
		this.nivel = nivel;
		this.recursos = recursos;
		this.bonus = bonus;
		this.tiempoConstruccion = tiempoConstruccion;
	}
	
	public Edificio(String nombre, int nivel) {
		this.nombre = nombre;
		this.nivel = nivel;
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
		  
		  }
		  return rec; 
		 }	
	
	public HashMap<Recursos, Integer> getRecursos() {
		return recursos;
	}
	
	public void setRecursos(HashMap<Recursos, Integer> recursos) {
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


