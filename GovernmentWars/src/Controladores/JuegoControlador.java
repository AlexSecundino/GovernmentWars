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
import Classes.Edificio;
import Classes.Tecnologia;
import Classes.Unidad;
import Classes.Usuario;
import Repository.ColasDAO;
import Repository.EdificioDAO;
import Repository.TecnologiaDAO;
import Repository.UnidadDAO;
import Repository.UsuarioDAO;

@Controller
//@SessionAttributes({"usuario", "ciudad", "edificios", "tecnologias", "unidadesCiudad", "unidades", "raza"})
@RequestMapping("/Juego")
public class JuegoControlador {
	

	@RequestMapping("/Edificios")
	public String Edificios(Model modelo, HttpSession session) {
		
		if(session.getAttribute("usuario") == null){
			return "index";
		}
		else if((boolean)session.getAttribute("isAdmin")){
			return "Admin";
		}
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		EdificioDAO edificioDAO = (EdificioDAO) context.getBean("EdificioDAO");
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
		
		List<Edificio> listaEdificios = edificioDAO.getEdificios((Usuario)session.getAttribute("usuario"), (Ciudad)session.getAttribute("ciudad"));
		
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		
		session.setAttribute("edificios", listaEdificios);
		
		modelo.addAttribute("edificios", listaEdificios);
		modelo.addAttribute("usuario", usuario);
		
		return "Edificios";
	}
	
	@RequestMapping("/Tecnologias")
	public String Tecnologias(Model modelo, HttpSession session) {
		
		if(session.getAttribute("usuario") == null){
			return "index";
		}
		else if((boolean)session.getAttribute("isAdmin")){
			return "Admin";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		TecnologiaDAO tecnologiaDAO = (TecnologiaDAO) context.getBean("TecnologiaDAO");
		
		List<Tecnologia> listaTecnologias = tecnologiaDAO.getTecnologias((Usuario)session.getAttribute("usuario"), (Ciudad)session.getAttribute("ciudad"), session.getAttribute("raza").toString());
		
		session.setAttribute("tecnologias", listaTecnologias);

		modelo.addAttribute("tecnologias", listaTecnologias);
		
		return "Tecnologias";
		//return "Copy of Tecnologias";
	}
	
	@RequestMapping("/Unidades")
	public String Unidades(Model modelo, HttpSession session) {
		
		if(session.getAttribute("usuario") == null){
			return "index";
		}
		else if((boolean)session.getAttribute("isAdmin")){
			return "Admin";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UnidadDAO unidadDAO = (UnidadDAO) context.getBean("UnidadDAO");
		
		List<Unidad> listaUnidades = unidadDAO.getTodasUnidades((Usuario)session.getAttribute("usuario"), (Ciudad)session.getAttribute("ciudad"), session.getAttribute("raza").toString());
		
		session.setAttribute("unidades", listaUnidades);

		modelo.addAttribute("unidades", listaUnidades);
		
		return "Unidades";
		//return "Copy of Unidades";
	}
	
	@RequestMapping("/Mapa")
	public String Mapa(Model modelo, HttpSession session) {
		
		if(session.getAttribute("usuario") == null){
			return "index";
		}
		else if((boolean)session.getAttribute("isAdmin")){
			return "Admin";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
		
		List<Usuario> listaUsuarios = usuarioDAO.getCiudadesAtacar();

		modelo.addAttribute("listaUsuarios", listaUsuarios);
		
		return "Mapa";
	}
	
	@RequestMapping("/Atacar")
	public String Atacar(Model modelo, HttpSession session
			, @RequestParam("usuario") String usuarioDefensor
			, @RequestParam("ciudad") String ciudadDefensor) {
		
		if(session.getAttribute("usuario") == null){
			return "index";
		}
		else if((boolean)session.getAttribute("isAdmin")){
			return "Admin";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		ColasDAO colasDAO = (ColasDAO) context.getBean("ColasDAO");
		
		Usuario defensor = new Usuario(usuarioDefensor);
		Ciudad cDefensor = new Ciudad(ciudadDefensor);
		
		boolean correcto = colasDAO.crearColaAtaque((Usuario)session.getAttribute("usuario"), (Ciudad)session.getAttribute("ciudad"), defensor, cDefensor);
				
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
		
		List<Usuario> listaUsuarios = usuarioDAO.getCiudadesAtacar();

		modelo.addAttribute("listaUsuarios", listaUsuarios);
		
		modelo.addAttribute("atacar", correcto);
		
		return "Mapa";
	}
	
}
