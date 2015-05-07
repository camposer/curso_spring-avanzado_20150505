package dao;

import model.Ordenador;

import org.springframework.stereotype.Repository;

@Repository
public class OrdenadorDaoImpl
		extends GenericDaoImpl<Ordenador, Integer>
		implements OrdenadorDao {

}
