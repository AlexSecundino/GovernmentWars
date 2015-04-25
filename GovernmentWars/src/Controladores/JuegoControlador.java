package Controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import Classes.Bonus;
import Classes.Edificio;
import Classes.Recursos;

@Controller
@SessionAttributes("usuarioSession")
@RequestMapping("/Juego")
public class JuegoControlador {
	

	@RequestMapping("/Edificios")
	public String Edificios(Model modelo, HttpSession session) {
		
		Edificio edificio = (Edificio) session.getAttribute("edificio");
		
		
		System.out.println(edificio);
		return "Edificios";
	}
}
