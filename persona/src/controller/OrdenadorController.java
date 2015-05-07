package controller;

import javax.validation.Valid;

import model.Ordenador;
import model.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.OrdenadorService;
import service.PersonaService;
import controller.form.OrdenadorForm;
import controller.validator.OrdenadorFormValidator;

@Controller
@RequestMapping("/ordenador/*")
public class OrdenadorController {
	@Autowired
	private PersonaService personaService;
	@Autowired
	private OrdenadorService ordenadorService;
	@Autowired
	private OrdenadorFormValidator ordenadorFormValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(ordenadorFormValidator);
	}
	
	@ModelAttribute
	public OrdenadorForm getOrdenadorForm() {
		return new OrdenadorForm();
	}

	@RequestMapping("index")
	public String index(Model model) {
		init(model);
		return "/WEB-INF/ordenador/index.jsp";
	}

	private void init(Model model) {
		model.addAttribute("ordenadores", ordenadorService.obtenerOrdenadores());
		model.addAttribute("personas", personaService.obtenerPersonas());
	}

	@RequestMapping(value = "guardar", method = RequestMethod.POST)
	public String guardar(
			@ModelAttribute @Valid OrdenadorForm ordenadorForm,
			Model model,
			BindingResult result) {
		
		if (!result.hasErrors()) {
			Ordenador o = new Ordenador();
			o.setId(ordenadorForm.getId());
			o.setNombre(ordenadorForm.getNombre());
			o.setSerial(ordenadorForm.getSerial());
			o.setPersona(new Persona(ordenadorForm.getPersonaId()));
			
			try {
				if (ordenadorForm.getId() != null) {
					ordenadorService.modificarOrdenador(o);
				} else
					ordenadorService.agregarOrdenador(o);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return "redirect:/ordenador/index.do"; 
		} else {
			init(model);
			return "forward:/WEB-INF/ordenador/index.jsp"; 
		}
	}

	@RequestMapping(value = "eliminar", method = RequestMethod.GET)
	public String eliminar(@RequestParam Integer id, Model model) {
		try {
			ordenadorService.eliminarOrdenador(id);

			return "redirect:/ordenador/index.do";
		} catch (Exception e) {
			e.printStackTrace();

			// TODO Agregar manejo de errores
			init(model);
			return "forward:/WEB-INF/ordenador/index.jsp";
		}
	}

	@RequestMapping(value = "mostrar", method = RequestMethod.GET)
	public String mostrar(@RequestParam Integer id, 
			@ModelAttribute OrdenadorForm ordenadorForm, Model model) {
		try {
			Ordenador o = ordenadorService.obtenerOrdenador(id);
			ordenadorForm.setId(o.getId());
			ordenadorForm.setNombre(o.getNombre());
			ordenadorForm.setSerial(o.getSerial());
			ordenadorForm.setPersonaId(o.getPersona().getId());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Agregar manejo de errores
		}

		init(model);
		return "forward:/WEB-INF/ordenador/index.jsp";
	}
}
