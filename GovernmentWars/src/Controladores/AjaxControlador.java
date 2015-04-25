package Controladores;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import Classes.Usuario;
import Repository.UsuarioDAO;

@Controller
@SessionAttributes("usuarioSession")
@RequestMapping("/Ajax")
public class AjaxControlador {
		
	@RequestMapping(value="/Login", method=RequestMethod.GET)
	public @ResponseBody String processAJAXRequest(
				@RequestParam("usuario") String name,
				@RequestParam("password") String password, HttpSession session) {

		String response = "false";
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
			
		Usuario usuario = new Usuario(name, password);
		
		session.setAttribute("usuarioSession", null);
		
		if(usuarioDAO.isRegistrado(usuario)){
			response = "true";
			session.setAttribute("usuarioSession", usuario.getUsuario());
		}
		
		return response;
		
	}
}
