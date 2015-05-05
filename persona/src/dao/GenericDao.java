package dao;

import java.util.List;

public interface GenericDao<E, K> {
	void agregar(E e);
	void modificar(E e);
	void eliminar(K id);
	E obtener(K id);
	List<E> obtenerTodos();
}
