package Classes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Tecnologia {

	private String nombre;
	private HashMap<Recursos, Integer> recursos;
	private int bonus;
	private Date tiempoConstruccion;
	private boolean isInvestigada;
	
	public Tecnologia(String nombre, HashMap<Recursos, Integer> recursos, int bonus, Date tiempoConstruccion, boolean isInvestigada) {
		this.nombre = nombre;
		this.recursos = recursos;
		this.bonus = bonus;
		this.tiempoConstruccion = tiempoConstruccion;
		this.isInvestigada = isInvestigada;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashMap<Recursos, Integer> getRecursos() {
		return recursos;
	}

	public void setRecursos(HashMap<Recursos, Integer> recursos) {
		this.recursos = recursos;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public Date getTiempoConstruccion() {
		return tiempoConstruccion;
	}

	public void setTiempoConstruccion(Date tiempoConstruccion) {
		this.tiempoConstruccion = tiempoConstruccion;
	}

	public boolean isInvestigada() {
		return isInvestigada;
	}

	public void setInvestigada(boolean isInvestigada) {
		this.isInvestigada = isInvestigada;
	}

	@Override
	public String toString() {
		return "Tecnologia [nombre=" + nombre + ", investigada="
				+ isInvestigada + ", recursos=" + recursos + ", bonus=" + bonus
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
