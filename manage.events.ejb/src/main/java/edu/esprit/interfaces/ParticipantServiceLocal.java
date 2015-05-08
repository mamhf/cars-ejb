package edu.esprit.interfaces;

import java.util.List;

import edu.esprit.entities.Participant;

public interface ParticipantServiceLocal {

	void addParticipant(Participant participant);

	void deleteParticipant(Participant participant);

	Participant findParticipantById(String login);

	List<Participant> findAllParticipants();

	Participant updateParticipant(Participant participant);
}
