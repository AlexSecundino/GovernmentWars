package Classes;

import java.util.Date;
import java.util.HashMap;

public class LogAtaques {

		private Usuario atacante;
		private String nCiudadAtacante;
		private Usuario defensor;
		private String nCiudadDefensor;
		
		private int nTropasEnviadas;
		private int nTropasPerdidasAtacante;
		private int nTropasDefensor;
		private int nTropasPerdidasDefensor;
		private HashMap<Recursos, Integer> botin;
		
		private Date fechaAtaque;
		private boolean isLeido;

		public LogAtaques(Usuario atacante, String nCiudadAtacante,
				Usuario defensor, String nCiudadDefensor, int nTropasEnviadas,
				int nTropasPerdidasAtacante, int nTropasDefensor,
				int nTropasPerdidasDefensor, HashMap<Recursos, Integer> botin,
				Date fechaAtaque, boolean isLeido) {
			super();
			this.atacante = atacante;
			this.nCiudadAtacante = nCiudadAtacante;
			this.defensor = defensor;
			this.nCiudadDefensor = nCiudadDefensor;
			this.nTropasEnviadas = nTropasEnviadas;
			this.nTropasPerdidasAtacante = nTropasPerdidasAtacante;
			this.nTropasDefensor = nTropasDefensor;
			this.nTropasPerdidasDefensor = nTropasPerdidasDefensor;
			this.botin = botin;
			this.fechaAtaque = fechaAtaque;
			this.isLeido = isLeido;
		}

		public String getAtacante() {
			return atacante.getUsuario();
		}

		public void setAtacante(Usuario atacante) {
			this.atacante = atacante;
		}
		
		public String getnCiudadAtacante() {
			return nCiudadAtacante;
		}

		public void setnCiudadAtacante(String nCiudadAtacante) {
			this.nCiudadAtacante = nCiudadAtacante;
		}

		public String getDefensor() {
			return defensor.getUsuario();
		}

		public void setDefensor(Usuario defensor) {
			this.defensor = defensor;
		}

		public String getnCiudadDefensor() {
			return nCiudadDefensor;
		}

		public void setnCiudadDefensor(String nCiudadDefensor) {
			this.nCiudadDefensor = nCiudadDefensor;
		}

		public int getnTropasEnviadas() {
			return nTropasEnviadas;
		}

		public void setnTropasEnviadas(int nTropasEnviadas) {
			this.nTropasEnviadas = nTropasEnviadas;
		}

		public int getnTropasPerdidasAtacante() {
			return nTropasPerdidasAtacante;
		}

		public void setnTropasPerdidasAtacante(int nTropasPerdidasAtacante) {
			this.nTropasPerdidasAtacante = nTropasPerdidasAtacante;
		}

		public int getnTropasDefensor() {
			return nTropasDefensor;
		}

		public void setnTropasDefensor(int nTropasDefensor) {
			this.nTropasDefensor = nTropasDefensor;
		}

		public int getnTropasPerdidasDefensor() {
			return nTropasPerdidasDefensor;
		}

		public void setnTropasPerdidasDefensor(int nTropasPerdidasDefensor) {
			this.nTropasPerdidasDefensor = nTropasPerdidasDefensor;
		}

		public int getRecurso(String recurso) {
			
			int rec = 0;
			
			switch(recurso){
				case "Sobres":
					rec = botin.get(Recursos.Sobres);
					break;
				case "Antena":
					rec = botin.get(Recursos.Antena);
					break;
				case "Jueces":
					rec = botin.get(Recursos.Jueces);
					break;
			
			}
			return rec; 
		}
		
		public HashMap<Recursos, Integer> getBotin() {
			return botin;
		}

		public void setBotin(HashMap<Recursos, Integer> botin) {
			this.botin = botin;
		}

		public Date getFechaAtaque() {
			return fechaAtaque;
		}

		public void setFechaAtaque(Date fechaAtaque) {
			this.fechaAtaque = fechaAtaque;
		}

		public boolean isLeido() {
			return isLeido;
		}

		public void setLeido(boolean isLeido) {
			this.isLeido = isLeido;
		}

		@Override
		public String toString() {
			return "LogAtaques [atacante=" + atacante + ", nCiudadAtacante="
					+ nCiudadAtacante + ", defensor=" + defensor
					+ ", nCiudadDefensor=" + nCiudadDefensor
					+ ", nTropasEnviadas=" + nTropasEnviadas
					+ ", nTropasPerdidasAtacante=" + nTropasPerdidasAtacante
					+ ", nTropasDefensor=" + nTropasDefensor
					+ ", nTropasPerdidasDefensor=" + nTropasPerdidasDefensor
					+ ", botin=" + botin + ", fechaAtaque=" + fechaAtaque
					+ ", isLeido=" + isLeido + "]";
		}
}
