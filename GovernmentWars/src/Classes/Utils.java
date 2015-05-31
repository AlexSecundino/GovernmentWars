package Classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	public static String formatearTiempo(Date fecha){
		
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