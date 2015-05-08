package edu.esprit.interfaces;

import java.util.List;

import edu.esprit.entities.Venue;

public interface VenueServiceLocal {

	void addVenue(Venue venue);

	void deleteVenue(Venue venue);

	Venue findVenueById(int id);

	List<Venue> findAllVenues();

	Venue updateVenue(Venue venue);
}
