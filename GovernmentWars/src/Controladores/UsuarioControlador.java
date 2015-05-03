package Controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import Classes.Ciudad;
import Classes.Mensaje;
import Classes.Raza;
import Classes.Usuario;
import Repository.CiudadDAO;
import Repository.MensajeDAO;
import Repository.UsuarioDAO;

@Controller
@SessionAttributes({"usuario", "ciudad", "edificios"})
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
		
		if(session.getAttribute("usuario") == null){
			return "index";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		CiudadDAO ciudadDAO = (CiudadDAO) context.getBean("CiudadDAO");
		
		Ciudad ciudad = ciudadDAO.getCiudad(new Usuario(session.getAttribute("usuario").toString()));
		
		session.setAttribute("ciudad", ciudad);
		
		modelo.addAttribute("ciudad", ciudad);
		
		return "ResumenCiudad";
	}
	
	@RequestMapping("/Perfil")
	public String Perfil(Model modelo, HttpSession session) {
		
		if(session.getAttribute("usuario") == null){
			return "index";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
			
		Usuario usuario = new Usuario(session.getAttribute("usuario").toString());

		Usuario datosUsuario = usuarioDAO.getUsuario(usuario);
		
		modelo.addAttribute("datosUsuario", datosUsuario);
		
		return "Perfil";
	}
	
	@RequestMapping("/Mensajes")
	public String Mensajes(Model modelo, HttpSession session) {
		
		if(session.getAttribute("usuario") == null){
			return "index";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		MensajeDAO mensajeDAO = (MensajeDAO) context.getBean("MensajeDAO");
			
		Usuario usuario = new Usuario(session.getAttribute("usuario").toString());
		
		List<Mensaje> listaMensajes = mensajeDAO.cargarMensajes(usuario);
		
		boolean nuevoMensaje = mensajeDAO.comprobarNuevoMensaje(usuario);
		
		modelo.addAttribute("listaMensajes", listaMensajes);
		modelo.addAttribute("nuevoMensaje", nuevoMensaje);
		
		return "Mensajes";
	}
}
