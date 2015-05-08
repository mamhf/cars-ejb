package edu.esprit.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.entities.Event;
import edu.esprit.entities.Participant;
import edu.esprit.entities.Reservation;
import edu.esprit.interfaces.EventServiceLocal;


@Stateless
@Local(EventServiceLocal.class)
public class EventService implements EventServiceLocal {
	
	@PersistenceContext(name="manage.events.ejb")
	EntityManager entityManager;

	@Override
	public void addEvent(Event event) {
		entityManager.persist(event);
		
	}

	@Override
	public void deleteEvent(Event event) {
		entityManager.remove(findEventById(event.getId()));
		
	}

	@Override
	public Event findEventById(int id) {
		
		return entityManager.find(Event.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findAllEvnets() {
		
		Query query=entityManager.createQuery("select e from Event e");
		return query.getResultList();
	}

	@Override
	public Event updateEvent(Event event) {
		
		return entityManager.merge(event);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Participant> findAllParticipantsByEvent(int id) {
		return entityManager.createNamedQuery("findAllParticipantsPerEvent")
				.setParameter("var",id).getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> findAllReservationsByEvent(int id) {
		return entityManager.createNamedQuery("findAllReservationsPerEvent")
				.setParameter("var", id).getResultList();
	}

}
