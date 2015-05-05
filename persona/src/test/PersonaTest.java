package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import model.Persona;

public class PersonaTest {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("persona");
		
		EntityManager entityManager = 
				entityManagerFactory.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		
		try {
			tx.begin();
			
			entityManager.persist(new Persona("Juan", "Pérez"));
			entityManager.persist(new Persona("María", "García"));
			
			List<Persona> personas = entityManager
					.createQuery("from Persona p").getResultList();
			for (Persona p : personas) 
				System.out.println(p);
			
			tx.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (entityManager != null)
				entityManager.close();
		}
	}
}
