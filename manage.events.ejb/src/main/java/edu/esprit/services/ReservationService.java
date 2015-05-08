package edu.esprit.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.entities.Reservation;
import edu.esprit.interfaces.ReservationServiceLocal;

@Stateless
public class ReservationService implements ReservationServiceLocal {

	@PersistenceContext(name = "manage.events.ejb")
	EntityManager entityManager;

	@Override
	public void addReservation(Reservation reservation) {
		entityManager.persist(reservation);

	}

	@Override
	public Reservation findReservationById(int id) {
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> findAllReservations() {

		return entityManager.createQuery("SELECT r from Reservation r")
				.getResultList();
	}

	@Override
	public Reservation updateReservation(Reservation reservation) {

		return entityManager.merge(reservation);
	}
}
