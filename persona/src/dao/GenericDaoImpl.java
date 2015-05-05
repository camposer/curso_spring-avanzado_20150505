package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class GenericDaoImpl<E, K> implements GenericDao<E, K> {
	private Class<E> clase;
	@PersistenceContext // Spring manejará los entity managers
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		this.clase = (Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void agregar(E e) {
		entityManager.persist(e);
	}

	@Override
	public void modificar(E e) {
		entityManager.merge(e);
	}

	@Override
	public void eliminar(K id) {
		E e = entityManager.find(clase, id);
		entityManager.remove(e);
	}

	@Override
	public E obtener(K id) {
		return entityManager.find(clase, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> obtenerTodos() {
		return entityManager.createNamedQuery(clase.getSimpleName() + ".findAll").getResultList();
	}

}
