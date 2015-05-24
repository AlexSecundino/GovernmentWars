package Controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;

import Classes.Ciudad;
import Classes.Mensaje;
import Classes.Produccion;
import Classes.Unidad;
import Classes.Usuario;
import Repository.CiudadDAO;
import Repository.MensajeDAO;
import Repository.UnidadDAO;
import Repository.UsuarioDAO;

@Controller
@SessionAttributes({"usuario", "ciudad", "edificios", "tecnologias", "raza"})
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
	public String Bienvenido(Model modelo, HttpSession session) {
		
		if(session.getAttribute("usuario") == null){
			return "index";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		CiudadDAO ciudadDAO = (CiudadDAO) context.getBean("CiudadDAO");
		MensajeDAO mensajeDAO = (MensajeDAO) context.getBean("MensajeDAO");
		UnidadDAO unidadDAO = (UnidadDAO) context.getBean("UnidadDAO");
		
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		Ciudad ciudad = ciudadDAO.getCiudad(usuario);
		List<Unidad> unidades = unidadDAO.getUnidades(usuario, ciudad);
		Produccion produccion = ciudadDAO.getProduccion(usuario, ciudad);

		session.setAttribute("ciudad", ciudad);
		session.setAttribute("unidadesCiudad", unidades);
		
		System.out.println("Datos session: ");
		System.out.println("1) Ciudad: " + session.getAttribute("ciudad"));
		System.out.println("2) Edificios: " + session.getAttribute("edificios"));
		System.out.println("3) Tecnologias: " + session.getAttribute("tecnologias"));
		System.out.println("4) Unidades: " + session.getAttribute("unidades"));
		
		
		boolean nuevoMensaje = mensajeDAO.comprobarNuevoMensaje(usuario);

		modelo.addAttribute("nuevoMensaje", nuevoMensaje);
		modelo.addAttribute("ciudad", ciudad);
		modelo.addAttribute("unidadesCiudad", unidades);
		modelo.addAttribute("produccion", produccion);
		
		return "ResumenCiudad";
	}
	
	@RequestMapping("/Perfil")
	public String Perfil(Model modelo, HttpSession session) {
		
		if(session.getAttribute("usuario") == null){
			return "index";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
			
		Usuario usuario = (Usuario)session.getAttribute("usuario");

		Usuario datosUsuario = usuarioDAO.getUsuario(usuario);
		
		modelo.addAttribute("datosUsuario", datosUsuario);
		
		return "Perfil";
	}
	
	@RequestMapping("/Logout")
	public void Logout(Model modelo, HttpSession session, HttpServletRequest request, HttpServletResponse response) {

		
		/*No va*/
		session.invalidate();
		HttpSession sessionNueva = request.getSession(true);
		
		try {
			response.sendRedirect("Index");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
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
		
		return "Mensajes";
	}
}
