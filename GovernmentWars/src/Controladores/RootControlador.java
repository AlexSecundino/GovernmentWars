package Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootControlador {
    
	@RequestMapping(value = "/")
    public String root() {
        return "index";
    }
}