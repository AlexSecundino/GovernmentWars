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
import Classes.Usuario;
import Repository.EdificioDAO;

@Controller
@SessionAttributes({"usuario", "ciudad", "edificios"})
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
}
