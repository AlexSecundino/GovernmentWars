package Classes;

import java.util.HashMap;

public class Produccion {

	private HashMap<Recursos, Integer> produccion;
	
	private int a;
	private int b;
	private int c;
	
	public Produccion() {
		produccion = new HashMap<Recursos, Integer>();
	}
	
	public void add(Recursos recurso, int cantidad){
		switch(recurso.toString()){
			case "Antena":
				a = cantidad;
				produccion.put(Recursos.Antena, cantidad);
				break;
			case "Sobres":
				b = cantidad;
				produccion.put(Recursos.Sobres, cantidad);
				break;
			case "Jueces":
				c = cantidad;
				produccion.put(Recursos.Jueces, cantidad);
				break;
		}
	}

	public int getRecurso(Recursos recurso) {
		
		switch(recurso.toString()){
			case "Antena":
				return produccion.get(Recursos.Antena);
			case "Sobres":
				return produccion.get(Recursos.Sobres);
			case "Jueces":
				return produccion.get(Recursos.Jueces);
			default:
				return produccion.get(Recursos.Antena);
		}
	}

	@Override
	public String toString() {
		return "Produccion [produccion=A)" + a + "B)" + b + "C)" + c + "]";
	}
	
	
}
