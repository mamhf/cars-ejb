package edu.esprit.interfaces;

import java.util.List;

import edu.esprit.entities.Organizer;


public interface OrganizerServiceLocal {

	void addOrganizer(Organizer organizer);

	void deleteOrganizer(Organizer organizer);

	Organizer findOrganizerById(String login);

	List<Organizer> findAllOrganizers();

	Organizer updateOrganizer(Organizer organizer);
}
