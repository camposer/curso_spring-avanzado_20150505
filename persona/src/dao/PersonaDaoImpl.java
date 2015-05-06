package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.Persona;

@Repository
public class PersonaDaoImpl
		extends GenericDaoImpl<Persona, Integer>
		implements PersonaDao {

	@Override
	public List<Persona> obtenerTodosPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
