package edu.esprit.init;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import edu.esprit.entities.CategoryEvent;
import edu.esprit.entities.Event;
import edu.esprit.entities.Organizer;
import edu.esprit.entities.Participant;
import edu.esprit.entities.Venue;
import edu.esprit.interfaces.CategoryEventServiceLocal;
import edu.esprit.interfaces.EventServiceLocal;
import edu.esprit.interfaces.OrganizerServiceLocal;
import edu.esprit.interfaces.ParticipantServiceLocal;
import edu.esprit.interfaces.ReservationServiceLocal;
import edu.esprit.interfaces.VenueServiceLocal;

@Singleton
@Startup
public class Init {

	@EJB
	EventServiceLocal eventServiceLocal;

	@EJB
	VenueServiceLocal venueServiceLocal;

	@EJB
	CategoryEventServiceLocal categoryEventServiceLocal;

	@EJB
	ReservationServiceLocal reservationServiceLocal;

	@EJB
	ParticipantServiceLocal participantServiceLocal;

	@EJB
	OrganizerServiceLocal organizerServiceLocal;

	@PostConstruct
	public void init() {

		/*
		 * add organizer
		 */
		Organizer organizer = new Organizer();
		organizer.setLastName("Ben Mohamed");
		organizer.setFirstName("ali");
		organizer.setLogin("organizer");
		organizer.setPassword("organizer");
		organizer.setEmail("ali.benmohamed@esprit.tn");
		organizer.setAge(25);
		organizerServiceLocal.addOrganizer(organizer);
		/*
		 * add participant
		 */

		Participant participant = new Participant();
		participant.setLastName("Ben Salah");
		participant.setFirstName("ahmed");
		participant.setLogin("participant");
		participant.setPassword("par");
		participant.setEmail("ali@esprit.tn");
		participant.setSolde(100000F);
		participantServiceLocal.addParticipant(participant);

		/*
		 * add three venues
		 */

		Venue espritCharguiya = new Venue();

		espritCharguiya.setAddress("ESPRIT CHARGUIYA");
		espritCharguiya.setRentalPrice(125);

		Venue espritGhazela = new Venue();
		espritGhazela.setAddress("ESPRIT GHAZELA");
		espritGhazela.setRentalPrice(180);

		Venue technopoleGhazela = new Venue();
		technopoleGhazela.setAddress("SALLE DES CONFERENCES ELGHAZELA ");
		technopoleGhazela.setRentalPrice(200);

		venueServiceLocal.addVenue(espritCharguiya);
		venueServiceLocal.addVenue(espritGhazela);
		venueServiceLocal.addVenue(technopoleGhazela);

		/*
		 * add two categories
		 */

		CategoryEvent conference = new CategoryEvent();
		CategoryEvent formation = new CategoryEvent();

		conference.setTypeEvenement("confèrence");
		formation.setTypeEvenement("formation");
		categoryEventServiceLocal.addCategoryEvent(conference);
		categoryEventServiceLocal.addCategoryEvent(formation);
		
		

	}
}
