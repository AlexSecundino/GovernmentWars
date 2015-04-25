package Controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import Classes.Bonus;
import Classes.Edificio;
import Classes.Mensaje;
import Classes.Raza;
import Classes.Recursos;
import Classes.Usuario;
import Repository.MensajeDAO;
import Repository.UsuarioDAO;

@Controller
@SessionAttributes("usuarioSession")
@RequestMapping("/Usuario")
public class UsuarioControlador {
	
	@RequestMapping("/Registro")
	public String Registro(){
		
		return "Registro";
	}
	
	@RequestMapping("/Registrar")
	public String Registrar(
					@RequestParam("usuario") String nombre,
					@RequestParam("password") String password,
					@RequestParam("raza") int raza,
					HttpSession session,
					Model modelo) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
		
		Usuario usuario = new Usuario();
		usuario.setUsuario(nombre);
		usuario.setPass(password);
		
		switch(raza){
			
			case 1:
				usuario.setRaza(Raza.Anarquista);
				break;
			case 2:
				usuario.setRaza(Raza.Socialdemocrata);
				break;
			case 3:
				usuario.setRaza(Raza.Liberal);
				break;
			default:
				usuario.setRaza(Raza.Socialdemocrata);
				break;
		}
		
		if(usuarioDAO.registrarUsuario(usuario)){
			modelo.addAttribute("registroCorrecto", true);
		}
		else{
			modelo.addAttribute("registroCorrecto", false);
		}
		
		return "index";
	}
	
	@RequestMapping("/Index")
	public String Bienvenido(Model modelo, HttpSession session) {
		
		if(session.getAttribute("usuarioSession") == null){
			return "index";
		}
		
		List<Recursos> recursos = new ArrayList();
		recursos.add(Recursos.Antena);
		recursos.add(Recursos.Jueces);
		recursos.add(Recursos.Militantes);
		recursos.add(Recursos.Militantes);
		
		Edificio edifico = new Edificio("edificio1", 1, recursos, new Bonus(1), new Date());
		
		session.setAttribute("edificio", edifico);
		
		return "VistaResumen";
	}
	
	@RequestMapping("/Perfil")
	public String Perfil(Model modelo, HttpSession session) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
			
		Usuario usuario = new Usuario(session.getAttribute("usuarioSession").toString());

		Usuario datosUsuario = usuarioDAO.getUsuario(usuario);
		
		modelo.addAttribute("datosUsuario", datosUsuario);
		
		return "Perfil";
	}
	
	@RequestMapping("/Mensajes")
	public String Mensajes(Model modelo, HttpSession session) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		MensajeDAO mensajeDAO = (MensajeDAO) context.getBean("MensajeDAO");
			
		Usuario usuario = new Usuario(session.getAttribute("usuarioSession").toString());
		
		List<Mensaje> listaMensajes = mensajeDAO.cargarMensajes(usuario);
		
		boolean nuevoMensaje = mensajeDAO.comprobarNuevoMensaje(usuario);
		
		modelo.addAttribute("listaMensajes", listaMensajes);
		modelo.addAttribute("nuevoMensaje", nuevoMensaje);
		
		return "Mensajes";
	}
}
