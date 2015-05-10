package Classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Requisitos {

	private HashMap<String, Integer> edificios;
	private List<String> tecnologias;
	
	public Requisitos(){
		edificios = new HashMap<String, Integer>();
		tecnologias = new ArrayList<String>();
	}
	
	public Requisitos(HashMap<String, Integer> edificios, List<String> tecnologias) {
		this.edificios = edificios;
		this.tecnologias = tecnologias;
	}

	public HashMap<String, Integer> getEdificios() {
		return edificios;
	}

	public void setEdificios(HashMap<String, Integer> edificios) {
		this.edificios = edificios;
	}

	public List<String> getTecnologias() {
		return tecnologias;
	}

	public void setTecnologias(List<String> tecnologias) {
		this.tecnologias = tecnologias;
	}

	@Override
	public String toString() {
		return "Requisitos [edificios=" + edificios + ", tecnologias="
				+ tecnologias + "]";
	}
}
