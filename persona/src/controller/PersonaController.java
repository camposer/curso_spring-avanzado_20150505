package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.PersonaService;

@Controller
@RequestMapping("/persona/*")
public class PersonaController {
	@Autowired
	private PersonaService personaService;
	
	@RequestMapping("index")
	public String index(Model model) {
		init(model);
		return "/WEB-INF/persona/index.jsp";
	}
	
	private void init(Model model) {
		model.addAttribute("personas", personaService.obtenerPersonas());
	}

	@RequestMapping(value = "agregar", method = RequestMethod.POST)
	public String agregar(@RequestParam String nombre,
			@RequestParam String apellido,
			@RequestParam("fechaNacimiento") String fnac,
			Model model) {
		
		Persona p = new Persona(nombre, apellido);
		try {
			p.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fnac));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			personaService.agregarPersona(p);

			return "redirect:/persona/index.do"; // => response.sendRedirect("/persona/persona/index.do");
		} catch (Exception e) {
			e.printStackTrace();
		
			// TODO Agregar manejo de errores
			init(model);
			return "forward:/WEB-INF/persona/index.jsp"; // => getServletContext().getRequestDispatcher("/WEB-INF/persona/index.jsp").forward(request, response);
		}
	}
	
	@RequestMapping(value = "eliminar", method = RequestMethod.GET)
	public String eliminar(@RequestParam Integer id, Model model) {
		try {
			personaService.eliminarPersona(id);

			return "redirect:/persona/index.do";
		} catch (Exception e) {
			e.printStackTrace();
		
			// TODO Agregar manejo de errores
			init(model);
			return "forward:/WEB-INF/persona/index.jsp";
		}
	}
	
}






