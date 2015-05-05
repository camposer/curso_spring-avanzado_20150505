package basico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Le dice a Spring que aquí hay beans
public class Config {
	@Autowired
	private Envoltorio envoltorio;
	
	// id = helloWorld (nombre del método)
	@Bean // Define un bean (singleton)
	public HolaMundo helloWorld() {
		HelloWorldImpl hm = new HelloWorldImpl();
		hm.setEnvoltorio(envoltorio);
		return hm;
	}

}
