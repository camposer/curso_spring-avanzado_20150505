package rest.response;

import java.io.Serializable;

import model.Ordenador;

public class OrdenadorResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombre;

	private String serial;

	private PersonaResponse persona;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public PersonaResponse getPersona() {
		return this.persona;
	}

	public void setPersona(PersonaResponse persona) {
		this.persona = persona;
	}
	
	public static OrdenadorResponse build(Ordenador ordenador) {
		OrdenadorResponse response = new OrdenadorResponse();
		response.setId(ordenador.getId());
		response.setNombre(ordenador.getNombre());
		response.setSerial(ordenador.getSerial());
		response.setPersona(PersonaResponse.build(ordenador.getPersona()));
		
		return response;
	}

}





