package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Reader;

public class ReaderHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BookList");

	public void insertReader(Reader s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Reader> showAllReaders(){
		EntityManager em = emfactory.createEntityManager();
		List<Reader> allReaders = em.createQuery("SELECT s from Reader s", Reader.class).getResultList();
		return allReaders;
	}
	
	public Reader findReader(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Reader> typedQuery = em.createQuery("select sh from Reader sh where sh.readerName = :selectedName", Reader.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Reader foundReader;
		try {
			foundReader = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundReader = new Reader(nameToLookUp);
		}
		em.close();

		return foundReader;
	}
}