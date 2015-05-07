package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

	@RequestMapping(value = "guardar", method = RequestMethod.POST)
	public String guardar(@RequestParam String nombre,
			@RequestParam(required=false) Integer personaId,
			@RequestParam String apellido,
			@RequestParam(value="fechaNacimiento", required=false) String fnac,
			Model model) {
		
		List<String> errores = new ArrayList<String>();
		
		// TODO Incluir validaciones de nombre y apellido
		Persona p = new Persona(nombre, apellido);
		if (fnac != null && !fnac.trim().equals("")) {
			try {
				p.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fnac));
			} catch (ParseException e) {
				errores.add("Fecha inválida");
			}
		}
		
		if (errores.size() == 0) {
			try {
				if (personaId != null) {
					p.setId(personaId);
					personaService.modificarPersona(p);
				} else
					personaService.agregarPersona(p);
			} catch (Exception e) {
				e.printStackTrace();
				errores.add("Error al guardar la Persona en BD");
			}
		}
		
		if (errores.size() > 0) {
			model.addAttribute("persona", p);
			model.addAttribute("errores", errores);
			init(model);
			return "forward:/WEB-INF/persona/index.jsp"; // => getServletContext().getRequestDispatcher("/WEB-INF/persona/index.jsp").forward(request, response);
		} else
			return "redirect:/persona/index.do"; // => response.sendRedirect("/persona/persona/index.do");
			
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
	
	@RequestMapping(value = "mostrar", method = RequestMethod.GET)
	public String mostrar(@RequestParam Integer id, Model model) {
		try {
			Persona p = personaService.obtenerPersona(id);
			model.addAttribute("persona", p);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Agregar manejo de errores
		}

		init(model);
		return "forward:/WEB-INF/persona/index.jsp";
	}
}






