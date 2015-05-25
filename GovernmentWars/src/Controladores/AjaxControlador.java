package Controladores;

import java.lang.reflect.Array;
import java.util.HashMap;

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
import Classes.Recursos;
import Classes.Unidad;
import Classes.Usuario;
import Repository.CiudadDAO;
import Repository.UnidadDAO;
import Repository.UsuarioDAO;

@Controller
//@SessionAttributes({"usuario", "ciudad", "edificios", "tecnologias", "raza"})
@RequestMapping("/Ajax")
public class AjaxControlador {
		
	@RequestMapping(value="/Login", method=RequestMethod.GET)
	public @ResponseBody String processAJAXRequest(
				@RequestParam("usuario") String name,
				@RequestParam("password") String password, HttpSession session, HttpServletRequest request) {

		session.invalidate();
		
		String response = "false";
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
			
		Usuario usuario = new Usuario(name, password);
		
		if(usuarioDAO.isRegistrado(usuario)){
			response = "true";
			usuario.setPass("");
			session = request.getSession(true);
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
	
	@RequestMapping(value="/CrearUnidad", method=RequestMethod.GET)
	public @ResponseBody String CrearUnidad(
				@RequestParam("unidad") String unidad,
				@RequestParam("cantidad") int cantidad,
				@RequestParam("recursos") int[] listaRecursos,
				HttpSession session) {
		
		System.out.println("unidad" + unidad + "\ncantidad: " + cantidad);
		
		String response = "false";
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UnidadDAO unidadDAO = (UnidadDAO) context.getBean("UnidadDAO");
		
		Unidad tropa = new Unidad(unidad, cantidad);
		
		HashMap<Recursos, Integer> recursos = new HashMap<Recursos, Integer>();
		recursos.put(Recursos.Antena, listaRecursos[0]);
		recursos.put(Recursos.Sobres, listaRecursos[1]);
		recursos.put(Recursos.Jueces, listaRecursos[2]);
		recursos.put(Recursos.Militantes, listaRecursos[3]);
		
		response = unidadDAO.crearCola(new Usuario(session.getAttribute("usuario").toString()), (Ciudad)session.getAttribute("ciudad"), tropa, recursos);
		
		return response;
	}
}
