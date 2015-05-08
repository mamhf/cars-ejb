package edu.esprit.interfaces;

import java.util.List;

import edu.esprit.entities.Event;
import edu.esprit.entities.Participant;
import edu.esprit.entities.Reservation;

public interface EventServiceLocal {

	public void addEvent(Event event);

	public void deleteEvent(Event event);

	public Event findEventById(int id);

	public List<Event> findAllEvnets();

	public Event updateEvent(Event event);

	public List<Participant> findAllParticipantsByEvent(int id);
	public List<Reservation> findAllReservationsByEvent(int id);

}
