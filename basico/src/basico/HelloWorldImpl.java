package basico;

public class HelloWorldImpl implements HolaMundo {
	private Envoltorio envoltorio;

	public String saludar(String nombre) {
		return "Hello " + envoltorio.saludar(nombre);
	}

	public Envoltorio getEnvoltorio() {
		return envoltorio;
	}

	public void setEnvoltorio(Envoltorio envoltorio) {
		this.envoltorio = envoltorio;
	}
}
