package Controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import Classes.Ciudad;
import Classes.Usuario;
import Repository.CiudadDAO;
import Repository.UsuarioDAO;

@Controller
@SessionAttributes("usuarioSession")
@RequestMapping("/Ajax")
public class AjaxControlador {
		
	@RequestMapping(value="/Login", method=RequestMethod.GET)
	public @ResponseBody String processAJAXRequest(
				@RequestParam("usuario") String name,
				@RequestParam("password") String password, HttpSession sessionAnterior, HttpServletRequest request) {
		

		/*Deletea la session anterior y crea una nueva*/
		sessionAnterior.invalidate();
		HttpSession session = request.getSession(true);
		
		String response = "false";
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
			
		Usuario usuario = new Usuario(name, password);
		
		if(usuarioDAO.isRegistrado(usuario)){
			response = "true";
			session.setAttribute("usuarioSession", usuario.getUsuario());
		}
		
		return response;
		
	}
	
	@RequestMapping(value="/CambiarNombreCiudad", method=RequestMethod.GET)
	public @ResponseBody String cambiarNombreCiudad(
				@RequestParam("antiguoNombre") String antiguoNombre,
				@RequestParam("nombre") String nombre) {
		
		String response = "false";
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		CiudadDAO ciudadDAO = (CiudadDAO) context.getBean("CiudadDAO");
		
		
		System.out.println(antiguoNombre + nombre);
		if(ciudadDAO.cambiarNombre(antiguoNombre, nombre)){
			response = "true";
		}
		
		return response;
	}
}
