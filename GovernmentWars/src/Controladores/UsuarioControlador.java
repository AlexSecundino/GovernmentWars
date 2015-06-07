package Controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Classes.Ciudad;
import Classes.ColaConstruccion;
import Classes.Gender;
import Classes.Mensaje;
import Classes.Produccion;
import Classes.Unidad;
import Classes.Usuario;
import Repository.CiudadDAO;
import Repository.ColasDAO;
import Repository.MensajeDAO;
import Repository.UnidadDAO;
import Repository.UsuarioDAO;

@Controller
//@SessionAttributes({"usuario", "ciudad", "edificios", "tecnologias", "raza"})
@RequestMapping("/Usuario")
public class UsuarioControlador {
	
	@RequestMapping("/Conocenos")
	public String Conocenos(){
		
		return "Conocenos";
	}
	
	@RequestMapping("/Ayuda")
	public String Ayuda(){
		
		return "Ayuda";
	}
	
	@RequestMapping("/Registro")
	public String Registro(){
		
		return "Registro";
	}
	
	@RequestMapping(value="/Registrar", method=RequestMethod.POST)
	public String Registrar(
					@RequestParam("usuario") String nombre,
					@RequestParam("password") String password,
					@RequestParam("raza") String raza,
					HttpSession session,
					Model modelo) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
		
		Usuario usuario = new Usuario();
		usuario.setUsuario(nombre);
		usuario.setPass(password);
		usuario.setFaccion(raza);
		
		if(usuarioDAO.registrarUsuario(usuario)){
			modelo.addAttribute("registroCorrecto", true);
		}
		else{
			modelo.addAttribute("registroCorrecto", false);
		}
	
		return "index";
	}
	
	@RequestMapping("/Index")
	public String Bienvenido(Model modelo, HttpSession session, HttpServletRequest request) {
		
		if(session.getAttribute("usuario") == null){
			return "index";
		}
		else if((boolean)session.getAttribute("isAdmin")){
			return "redirect:/Admin/Usuarios";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
		
		
		MensajeDAO mensajeDAO = (MensajeDAO) context.getBean("MensajeDAO");
		UnidadDAO unidadDAO = (UnidadDAO) context.getBean("UnidadDAO");
		ColasDAO colasDAO = (ColasDAO) context.getBean("ColasDAO");
		CiudadDAO ciudadDAO = (CiudadDAO) context.getBean("CiudadDAO");
		
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		Ciudad ciudad = (Ciudad)session.getAttribute("ciudad");
		
		/*Actualizar ciudad*/
		if(colasDAO.implementarColas(usuario, ciudad)){
			System.out.println("actualizacion correcta");
		}
		
		List<Unidad> unidades = unidadDAO.getUnidades(usuario, ciudad);
		List<ColaConstruccion> colas = colasDAO.getColas(usuario, ciudad);
		Produccion produccion = ciudadDAO.getProduccion(usuario, ciudad);
		
		/*System.out.println("Datos session: ");
		System.out.println("1) Ciudad: " + session.getAttribute("ciudad"));
		System.out.println("2) Edificios: " + session.getAttribute("edificios"));
		System.out.println("3) Tecnologias: " + session.getAttribute("tecnologias"));
		System.out.println("4) Unidades: " + session.getAttribute("unidades"));*/
		
		
		boolean nuevoMensaje = mensajeDAO.comprobarNuevoMensaje(usuario);
		
		boolean nuevoLogAtaque = colasDAO.comprobarNuevoLogAtaque(usuario);

		modelo.addAttribute("nuevoLogAtaque", nuevoLogAtaque);
		modelo.addAttribute("nuevoMensaje", nuevoMensaje);
		modelo.addAttribute("ciudad", ciudad);
		modelo.addAttribute("unidadesCiudad", unidades);
		modelo.addAttribute("produccion", produccion);
		modelo.addAttribute("colas", colas);
		
		return "ResumenCiudad";
	}
	
	@RequestMapping("/Perfil")
	public String Perfil(Model modelo, HttpSession session) {
		
		if(session.getAttribute("usuario") == null){
			return "index";
		}
		else if((boolean)session.getAttribute("isAdmin")){
			return "Admin";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
		
		Usuario usuario = (Usuario)session.getAttribute("usuario");

		Usuario datosUsuario = usuarioDAO.getUsuario(usuario);
		
		modelo.addAttribute("datosUsuario", datosUsuario);
		
		return "Perfil";
	}
	
	@RequestMapping("/Logout")
	public String Logout(Model modelo, HttpSession session, HttpServletRequest request) {
		
		session.invalidate();
		session = request.getSession(true);

		return "index";
	}
	
	@RequestMapping("/Mensajes")
	public String Mensajes(Model modelo, HttpSession session) {
		
		if(session.getAttribute("usuario") == null){
			return "index";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		MensajeDAO mensajeDAO = (MensajeDAO) context.getBean("MensajeDAO");
			
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		
		List<Mensaje> listaMensajes = mensajeDAO.cargarMensajes(usuario);

		modelo.addAttribute("listaMensajes", listaMensajes);
		

		if((boolean)session.getAttribute("isAdmin")){
			return "Admin";
		}
		else{
			return "Mensajes";
		}
	}
	
	@RequestMapping("/NuevoMensaje")
	public String NuevoMensaje(Model modelo, HttpSession session,
			@RequestParam("destinatario") String destinatario) {
		
		Usuario usuario = new Usuario(destinatario);
		
		modelo.addAttribute("destinatario", usuario);
		
		return "NuevoMensaje";
	}
	
	@RequestMapping(value="/EnviarMensaje", method=RequestMethod.POST)
	public String EnviarMensaje(Model modelo, HttpSession session,
			@RequestParam("destinatario") String destinatario,
			@RequestParam("asunto") String asunto,
			@RequestParam("mensaje") String mensaje) {
		
		Mensaje msg = new Mensaje(asunto, mensaje);
		
		boolean correcto = false;
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		MensajeDAO mensajeDAO = (MensajeDAO) context.getBean("MensajeDAO");
		
		if(mensajeDAO.enviarMensaje((Usuario)session.getAttribute("usuario"), new Usuario(destinatario), msg)){
			correcto = true;
		}
		
		modelo.addAttribute("envioMensaje", correcto);
		
		return "NuevoMensaje";
	}
	
	@RequestMapping(value="/CambiarPerfil", method=RequestMethod.POST)
	public String CambiarPerfil(
					@RequestParam("usuario") String us,
					@RequestParam("genero") String genero,
					@RequestParam("descripcion") String descripcion,
					@RequestParam("pais") String pais,
					HttpSession session,
					Model modelo) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
		
		Usuario usuario = new Usuario();
		usuario.setUsuario(us);
		
		if(genero != null){
			if(genero.equals(Gender.Hombre)){
				usuario.setGenero(Gender.Hombre);
			}
			else{
				usuario.setGenero(Gender.Mujer);
			}
		}
		else{
			usuario.setGenero(Gender.Hombre);
		}
		
		if(descripcion != null){
			usuario.setDescripcion(descripcion);
		}
		else{
			usuario.setDescripcion("");
		}
		
		if(pais != null){
			usuario.setPais(pais);
		}
		else{
			usuario.setPais("España");
		}
		
		if(usuarioDAO.actualizarPerfil(usuario)){
			modelo.addAttribute("correcto", true);
		}
		else{
			modelo.addAttribute("correcto", false);
		}
		
		Usuario datosUsuario = usuarioDAO.getUsuario(usuario);
		
		modelo.addAttribute("datosUsuario", datosUsuario);
		
		return "Perfil";
	}
}
