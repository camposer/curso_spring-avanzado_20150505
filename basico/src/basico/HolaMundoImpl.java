package basico;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("holaMundoImpl") // Esto le dice a Spring que maneje la instancia!
@Scope("prototype")
public class HolaMundoImpl implements HolaMundo {
	@Autowired // Le dice a Spring inyecta la dependencia por tipo!!!
	@Qualifier("envoltorio") // Identificador del bean
	private Envoltorio envoltorio;
	
	@PostConstruct
	public void init() {
		System.out.println("Inicializando");
	}
	
	public String saludar(String nombre) {
		return "Hola " + envoltorio.saludar(nombre);
	}

//	public void setEnvoltorio(Envoltorio envoltorio) {
//		this.envoltorio = envoltorio;
//	}
}
