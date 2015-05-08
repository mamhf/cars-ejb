package edu.esprit.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.entities.Organizer;
import edu.esprit.interfaces.OrganizerServiceLocal;


@Stateless
@Local(OrganizerServiceLocal.class)
public class OrganizerService implements OrganizerServiceLocal{

	@PersistenceContext(name="manage.events.ejb")
	EntityManager entityManager;

	
	@Override
	public void addOrganizer(Organizer organizer) {
		entityManager.persist(organizer);
		
	}

	@Override
	public  void deleteOrganizer(Organizer organizer) {
		entityManager.remove(findOrganizerById(organizer.getLogin()));
		
	}

	@Override
	public  Organizer findOrganizerById(String login){
		
		return entityManager.find(Organizer.class, login);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Organizer> findAllOrganizers() {
		
		Query query=entityManager.createQuery("select o from Organizer o");
		return query.getResultList();
	}

	@Override
	public 	 Organizer updateOrganizer(Organizer organizer) {
	 
		return entityManager.merge(organizer);
	}
}
