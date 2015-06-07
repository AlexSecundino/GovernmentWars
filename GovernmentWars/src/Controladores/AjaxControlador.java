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
import Classes.Mensaje;
import Classes.Recursos;
import Classes.Tecnologia;
import Classes.Unidad;
import Classes.Usuario;
import Repository.CiudadDAO;
import Repository.EdificioDAO;
import Repository.MensajeDAO;
import Repository.TecnologiaDAO;
import Repository.UnidadDAO;
import Repository.UsuarioDAO;

@Controller
//@SessionAttributes({"usuario", "ciudad", "edificios", "tecnologias", "raza"})
@RequestMapping("/Ajax")
public class AjaxControlador {
		
	@RequestMapping(value="/Login", method=RequestMethod.POST)
	public @ResponseBody String Login(
				@RequestParam("usuario") String name,
				@RequestParam("password") String password, HttpSession session, HttpServletRequest request) {

		session.invalidate();
		
		String response = "0";
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
			
		Usuario usuario = new Usuario(name, password);
		
		if(usuarioDAO.isRegistrado(usuario)){
			
			if(usuarioDAO.isBloqueado(usuario)){
				response = "2";
			}
			else{
				usuario.setPass("");
				session = request.getSession(true);
				
				if(usuarioDAO.isAdmin(usuario)){
					session.setAttribute("isAdmin", true);
				}
				else{
					session.setAttribute("isAdmin", false);
				}
				
				CiudadDAO ciudadDAO = (CiudadDAO) context.getBean("CiudadDAO");
				Ciudad ciudad = ciudadDAO.getCiudad(usuario);
				
				if(ciudadDAO.actualizarRecursos(usuario, ciudad)){
					System.out.println("recursos actualizados");
				}
				
				session.setAttribute("ciudad", ciudad);
				session.setAttribute("usuario", usuario);
				session.setAttribute("raza", usuarioDAO.getRaza(usuario));

				response = "1";
			}
		}
		
		return response;
		
	}
	
	@RequestMapping(value="/CambiarNombreCiudad", method=RequestMethod.POST)
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
	
	@RequestMapping(value="/MensajeLeido", method=RequestMethod.POST)
	public @ResponseBody String mensajeLeido(
				@RequestParam("id") int id,
				HttpSession session) {
		
		String response = "false";
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		MensajeDAO mensajeDAO = (MensajeDAO) context.getBean("MensajeDAO");
		
		Mensaje msg = new Mensaje(id);
		
		if(mensajeDAO.mensajeLeido(msg)){
			response = "true";
		}
		
		return response;
	}
	
	@RequestMapping(value="/EliminarMensaje", method=RequestMethod.POST)
	public @ResponseBody String EliminarMensaje(
				@RequestParam("id") int idMensaje,
				HttpSession session) {
		
		String respuesta = "";
		boolean response = false;
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		MensajeDAO mensajeDAO = (MensajeDAO) context.getBean("MensajeDAO");
		
		Mensaje mensaje = new Mensaje(idMensaje);
		response = mensajeDAO.eliminarMensaje(mensaje);
		
		if(response)
			respuesta = "true";
		else
			respuesta = "false";
		
		return respuesta;
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
				@RequestParam("tecnologia") String nTecnologia,
				@RequestParam("sobres") long sobres,
				@RequestParam("antena") long antena,
				@RequestParam("jueces") long jueces,
				HttpSession session) {
		
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
