package Controladores;

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

import Classes.Ciudad;
import Classes.Edificio;
import Classes.Recursos;
import Classes.Tecnologia;
import Classes.Unidad;
import Classes.Usuario;
import Repository.CiudadDAO;
import Repository.EdificioDAO;
import Repository.TecnologiaDAO;
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
	
	@RequestMapping(value="/ColaUnidad", method=RequestMethod.GET)
	public @ResponseBody String CrearUnidad(
				@RequestParam("unidad") String unidad,
				@RequestParam("cantidad") int cantidad,
				@RequestParam("sobres") long sobres,
				@RequestParam("antena") long antena,
				@RequestParam("jueces") long jueces,
				@RequestParam("militantes") long militantes,
				HttpSession session) {
		
		System.out.println("unidad" + unidad + "\ncantidad: " + cantidad);
		
		String respuesta = "";
		boolean response = false;
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UnidadDAO unidadDAO = (UnidadDAO) context.getBean("UnidadDAO");
		
		Unidad tropa = new Unidad(unidad, cantidad);
		
		HashMap<Recursos, Long> recursos = new HashMap<Recursos, Long>();
		recursos.put(Recursos.Antena, antena);
		recursos.put(Recursos.Sobres, sobres);
		recursos.put(Recursos.Jueces, jueces);
		recursos.put(Recursos.Militantes, militantes);
		
		response = unidadDAO.crearCola((Usuario)session.getAttribute("usuario"), (Ciudad)session.getAttribute("ciudad"), tropa, recursos);
		
		if(response)
			respuesta = "true";
		else
			respuesta = "false";
			
		return respuesta;
	}
	
	@RequestMapping(value="/ColaEdificio", method=RequestMethod.GET)
	public @ResponseBody String CrearColaEdifio(
				@RequestParam("edificio") String nEdificio,
				@RequestParam("nivel") int nivel,
				@RequestParam("sobres") long sobres,
				@RequestParam("antena") long antena,
				@RequestParam("jueces") long jueces,
				HttpSession session) {
		
		System.out.println("edificio" + nEdificio + "   Nivel: " + nivel);
		
		String respuesta = "";
		boolean response = false;
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		EdificioDAO edificioDAO = (EdificioDAO) context.getBean("EdificioDAO");
		
		Edificio edificio = new Edificio(nEdificio, nivel);
		
		HashMap<Recursos, Long> recursos = new HashMap<Recursos, Long>();
		recursos.put(Recursos.Antena, sobres);
		recursos.put(Recursos.Sobres, antena);
		recursos.put(Recursos.Jueces, jueces);
		
		response = edificioDAO.crearCola((Usuario)session.getAttribute("usuario"), (Ciudad)session.getAttribute("ciudad"), edificio, recursos);
		
		if(response)
			respuesta = "true";
		else
			respuesta = "false";
		
		return respuesta;
	}
	
	@RequestMapping(value="/ColaTecnologia", method=RequestMethod.GET)
	public @ResponseBody String CrearColaTecnologia(
				@RequestParam("edificio") String nTecnologia,
				@RequestParam("sobres") long sobres,
				@RequestParam("antena") long antena,
				@RequestParam("jueces") long jueces,
				HttpSession session) {
		
		System.out.println("edificio" + nTecnologia);
		
		String respuesta = "";
		boolean response = false;
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		TecnologiaDAO tecnologiaDao = (TecnologiaDAO) context.getBean("TecnologiaDAO");
		
		Tecnologia tecnologia = new Tecnologia(nTecnologia);
		
		HashMap<Recursos, Long> recursos = new HashMap<Recursos, Long>();
		recursos.put(Recursos.Antena, sobres);
		recursos.put(Recursos.Sobres, antena);
		recursos.put(Recursos.Jueces, jueces);
		
		response = tecnologiaDao.crearCola((Usuario)session.getAttribute("usuario"), (Ciudad)session.getAttribute("ciudad"), tecnologia, recursos);
		
		if(response)
			respuesta = "true";
		else
			respuesta = "false";
		
		return respuesta;
	}
}
