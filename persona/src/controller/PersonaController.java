package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/persona/*")
public class PersonaController {
	@RequestMapping("index")
	public String index() {
		return "/WEB-INF/persona/index.jsp";
	}
}
