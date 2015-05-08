package edu.esprit.interfaces;

import java.util.List;

import edu.esprit.entities.Reservation;

public interface ReservationServiceLocal {

	void addReservation(Reservation reservation);

	Reservation findReservationById(int id);

	List<Reservation> findAllReservations();

	Reservation updateReservation(Reservation reservation);

}
