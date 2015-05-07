package controller;

import javax.servlet.http.HttpServletRequest;

import model.Persona;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HolaMundoController {
	// http://localhost:8080/persona/holaMundo1.do
	@RequestMapping("/holaMundo1")
	public @ResponseBody String holaMundo1() {
		String html = "<html>";
		html+= "<head></head>";
		html+= "<body>Hola mundo!</body>";
		html+= "</html>";
		return html;
	}
	
	@RequestMapping("/holaMundo2")
	public String holaMundo2() {
		return "/WEB-INF/jsp/holaMundo.jsp";
	}

	// http://localhost:8080/persona/holaMundo3.do?nombre=Pedro
	@RequestMapping("/holaMundo3")
	public String holaMundo3(HttpServletRequest request, Model model) {
		String nombre = request.getParameter("nombre");
		model.addAttribute("nombre", nombre);
		
		return "/WEB-INF/jsp/holaMundo.jsp";
	}

	@RequestMapping("/holaMundo4")
	public ModelAndView holaMundo4(@RequestParam String nombre) {
		return new ModelAndView("/WEB-INF/jsp/holaMundo.jsp", "nombre", nombre);
	}

	@RequestMapping("/holaMundo5")
	public String holaMundo5(Persona persona, Model model) {
		model.addAttribute("nombre", persona.getNombre());
		return "/WEB-INF/jsp/holaMundo.jsp";
	}

}






