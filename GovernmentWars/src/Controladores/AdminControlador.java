package Controladores;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import Classes.Raza;
import Classes.Usuario;
import Repository.UsuarioDAO;

@Controller
//@SessionAttributes({"usuario", "ciudad", "edificios", "tecnologias", "raza"})
@RequestMapping("/Admin")
public class AdminControlador {

	
	@RequestMapping("/Usuarios")
	public String Usuarios(Model modelo, HttpSession session) {
		
		if(session.getAttribute("usuario") == null || !(boolean)session.getAttribute("isAdmin")){
			return "index";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
		
		List<Usuario> listaUsuarios = usuarioDAO.getUsuarios();
	
		HashMap<Raza, Integer> estadisticasRazas = new HashMap<Raza, Integer>();
		estadisticasRazas.put(Raza.Anarquista, 0);
		estadisticasRazas.put(Raza.Socialdemocrata, 0);
		estadisticasRazas.put(Raza.Liberal, 0);

		int nTotal = 0;
		
		for(Usuario user : listaUsuarios) {
			switch(user.getFaccion()){
				case "Anarquista":
					estadisticasRazas.replace(Raza.Anarquista, estadisticasRazas.get(Raza.Anarquista) + 1);
					break;
				case "Socialdemocrata":
					estadisticasRazas.replace(Raza.Socialdemocrata, estadisticasRazas.get(Raza.Socialdemocrata) + 1);
					break;
				case "Liberal":
					estadisticasRazas.replace(Raza.Liberal, estadisticasRazas.get(Raza.Liberal) + 1);
					break;
			
			}
			nTotal++;
		}
		
		estadisticasRazas.replace(Raza.Anarquista, estadisticasRazas.get(Raza.Anarquista) * 100/nTotal);
		estadisticasRazas.replace(Raza.Socialdemocrata, estadisticasRazas.get(Raza.Socialdemocrata) * 100/nTotal);
		estadisticasRazas.replace(Raza.Liberal, estadisticasRazas.get(Raza.Liberal) * 100/nTotal);
		
		System.out.println(estadisticasRazas);
		
		
		session.setAttribute("estadisticas", estadisticasRazas);
		
		modelo.addAttribute("estadisticas", estadisticasRazas);
		modelo.addAttribute("listaUsuarios", listaUsuarios);
		
		return "Admin";
	}
	
	@RequestMapping("/Bloquear")
	public String Bloquear(Model modelo, HttpSession session, @RequestParam("usuario") String name) {
		
		if(session.getAttribute("usuario") == null || !(boolean)session.getAttribute("isAdmin")){
			return "index";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
		
		Usuario usuario = new Usuario(name);
		
		boolean correcto = usuarioDAO.bloquearUsuario(usuario);
	
		List<Usuario> listaUsuarios = usuarioDAO.getUsuarios();
	
		HashMap<Raza, Integer> estadisticasRazas = (HashMap<Raza, Integer>)session.getAttribute("estadisticas");
		
		modelo.addAttribute("estadisticas", estadisticasRazas);	
		
		modelo.addAttribute("listaUsuarios", listaUsuarios);
		modelo.addAttribute("bloqueado", correcto);
		
		return "redirect:/Admin/Usuarios";
	}
	
	@RequestMapping("/Desbloquear")
	public String Desbloquear(Model modelo, HttpSession session, @RequestParam("usuario") String name) {
		
		if(session.getAttribute("usuario") == null || !(boolean)session.getAttribute("isAdmin")){
			return "index";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("UsuarioDAO");
		
		Usuario usuario = new Usuario(name);
		
		boolean correcto = usuarioDAO.desbloquearUsuario(usuario);
	
		List<Usuario> listaUsuarios = usuarioDAO.getUsuarios();
		
		HashMap<Raza, Integer> estadisticasRazas = (HashMap<Raza, Integer>)session.getAttribute("estadisticas");
		
		modelo.addAttribute("estadisticas", estadisticasRazas);
		
		modelo.addAttribute("listaUsuarios", listaUsuarios);
		modelo.addAttribute("desbloqueado", correcto);
		
		return "redirect:/Admin/Usuarios";
	}
}
