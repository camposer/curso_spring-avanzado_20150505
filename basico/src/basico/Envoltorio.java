package basico;

import org.springframework.stereotype.Component;

@Component
public class Envoltorio {
	public String saludar(String nombre) {
		return "saludando = " + nombre;
	}
}
