package Classes;

import java.io.Serializable;
import java.util.Date;

public class Mensaje {

	private int id;
	private String remitente;
	private String destinatario;
	private String asunto;
	private String mensaje;
	private Date fecha;
	private boolean isLeido;
	
	public Mensaje(int id, String remitente, String destinatario, String asunto, String mensaje, Date fecha, boolean isLeido){
		
		this.id = id;
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.asunto = asunto;
		this.mensaje = mensaje;
		this.fecha = fecha;
		this.isLeido = isLeido;
	}
	
	public Mensaje(String remitente, String destinatario, String asunto, String mensaje, Date fecha, boolean isLeido){
		
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.asunto = asunto;
		this.mensaje = mensaje;
		this.fecha = fecha;
		this.isLeido = isLeido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public boolean isLeido() {
		return isLeido;
	}

	public void setLeido(boolean isLeido) {
		this.isLeido = isLeido;
	}

	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", remitente=" + remitente
				+ ", destinatario=" + destinatario + ", asunto=" + asunto
				+ ", mensaje=" + mensaje + ", fecha=" + fecha + ", isLeido="
				+ isLeido + "]";
	}
}
