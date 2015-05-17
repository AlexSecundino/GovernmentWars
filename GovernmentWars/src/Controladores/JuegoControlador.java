package Controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import Classes.Ciudad;
import Classes.Edificio;
import Classes.Tecnologia;
import Classes.Unidad;
import Classes.Usuario;
import Repository.EdificioDAO;
import Repository.TecnologiaDAO;
import Repository.UnidadDAO;

@Controller
@SessionAttributes({"usuario", "ciudad", "edificios", "tecnologias", "unidadesCiudad", "unidades", "raza"})
@RequestMapping("/Juego")
public class JuegoControlador {
	

	@RequestMapping("/Edificios")
	public String Edificios(Model modelo, HttpSession session) {
		
		if(session.getAttribute("usuario") == null){
			return "index";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		EdificioDAO edificioDAO = (EdificioDAO) context.getBean("EdificioDAO");
		
		List<Edificio> listaEdificios = edificioDAO.getEdificios(new Usuario(session.getAttribute("usuario").toString()), (Ciudad)session.getAttribute("ciudad"));
		
		session.setAttribute("edificios", listaEdificios);

		modelo.addAttribute("edificios", listaEdificios);
		
		return "Edificios";
	}
	
	@RequestMapping("/Tecnologias")
	public String Tecnologias(Model modelo, HttpSession session) {
		
		if(session.getAttribute("usuario") == null){
			return "index";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		TecnologiaDAO tecnologiaDAO = (TecnologiaDAO) context.getBean("TecnologiaDAO");
		
		List<Tecnologia> listaTecnologias = tecnologiaDAO.getTecnologias(new Usuario(session.getAttribute("usuario").toString()), (Ciudad)session.getAttribute("ciudad"), session.getAttribute("raza").toString());
		
		session.setAttribute("tecnologias", listaTecnologias);

		modelo.addAttribute("tecnologias", listaTecnologias);
		
		return "Tecnologias";
	}
	
	@RequestMapping("/Unidades")
	public String Unidades(Model modelo, HttpSession session) {
		
		if(session.getAttribute("usuario") == null){
			return "index";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UnidadDAO unidadDAO = (UnidadDAO) context.getBean("UnidadDAO");
		
		List<Unidad> listaUnidades = unidadDAO.getTodasUnidades(new Usuario(session.getAttribute("usuario").toString()), (Ciudad)session.getAttribute("ciudad"), session.getAttribute("raza").toString());
	
		session.setAttribute("unidades", listaUnidades);

		modelo.addAttribute("unidades", listaUnidades);
		
		return "Unidades";
	}
	
	
}
