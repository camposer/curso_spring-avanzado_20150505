package service;

import java.util.List;

import model.Ordenador;
import model.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.OrdenadorDao;
import dao.PersonaDao;

@Service
@Transactional
public class OrdenadorServiceImpl implements OrdenadorService {
	@Autowired
	private OrdenadorDao ordenadorDao;
	@Autowired
	private PersonaDao personaDao;

	@Override
	public void agregarOrdenador(Ordenador o) {
		Persona p = personaDao.obtener(o.getPersona().getId());
		o.setPersona(p);
		ordenadorDao.agregar(o);
	}

	@Override
	public void modificarOrdenador(Ordenador o) {
		Persona p = personaDao.obtener(o.getPersona().getId());
		o.setPersona(p);
		ordenadorDao.modificar(o);
	}

	@Override
	public void eliminarOrdenador(Integer id) {
		ordenadorDao.eliminar(id);
	}

	@Override
	public Ordenador obtenerOrdenador(Integer id) {
		return ordenadorDao.obtener(id);
	}

	@Override
	public List<Ordenador> obtenerOrdenadores() {
		return ordenadorDao.obtenerTodos();
	}

}
