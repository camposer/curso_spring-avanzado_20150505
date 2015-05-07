package rest.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import model.Persona;

public class PersonaResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String apellido;

	private Date fechaNacimiento;

	private String nombre;

	private List<OrdenadorResponse> ordenadores;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<OrdenadorResponse> getOrdenadores() {
		return this.ordenadores;
	}

	public void setOrdenadores(List<OrdenadorResponse> ordenadores) {
		this.ordenadores = ordenadores;
	}

	public static PersonaResponse build(Persona persona) {
		PersonaResponse response = new PersonaResponse();
		response.setId(persona.getId());
		response.setNombre(persona.getNombre());
		response.setApellido(persona.getApellido());
		response.setFechaNacimiento(persona.getFechaNacimiento());
		return response;
	}
	
}




