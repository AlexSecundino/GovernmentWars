package Controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
@SessionAttributes({"usuario", "ciudad", "edificios", "tecnologias", "raza"})
@RequestMapping("/Ajax")
public class AjaxControlador {
		
	@RequestMapping(value="/Login", method=RequestMethod.GET)
	public @ResponseBody String processAJAXRequest(
				@RequestParam("usuario") String name,
				@RequestParam("password") String password, HttpSession sessionAnterior, HttpServletRequest request) {
		
		System.out.println(name);System.out.println(password);

		/*Deletea la session anterior y crea una nueva*/
		/*No va*/
		sessionAnterior.invalidate();
		HttpSession session = request.getSession(true);
		
		String response = "false";
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
			
		Usuario usuario = new Usuario(name, password);
		
		if(usuarioDAO.isRegistrado(usuario)){
			response = "true";
			usuario.setPass("");
			session.setAttribute("usuario", usuario);
			session.setAttribute("raza", usuarioDAO.getRaza(usuario));
		}
		
		return response;
		
	}
	
	@RequestMapping(value="/CambiarNombreCiudad", method=RequestMethod.GET)
	public @ResponseBody String cambiarNombreCiudad(
				@RequestParam("antiguoNombre") String antiguoNombre,
				@RequestParam("nombre") String nombre,
				HttpSession session) {
		
		String response = "false";
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		CiudadDAO ciudadDAO = (CiudadDAO) context.getBean("CiudadDAO");
		
		if(ciudadDAO.cambiarNombre(antiguoNombre, nombre, (Usuario)session.getAttribute("usuario"))){
			response = "true";
			
			//actualizar la ciudad en la sesion
			Ciudad ciudad = (Ciudad) session.getAttribute("ciudad");
			ciudad.setNombre(nombre);
			session.setAttribute("ciudad", ciudad);
			
			System.out.println(session.getAttribute("usuario"));
			System.out.println(session.getAttribute("ciudad"));
		}
		
		return response;
	}
}
