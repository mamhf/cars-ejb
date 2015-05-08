package edu.esprit.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.entities.Participant;
import edu.esprit.interfaces.ParticipantServiceLocal;

@Stateless
@Local(ParticipantServiceLocal.class)
public class ParticipantService implements ParticipantServiceLocal {

	@PersistenceContext(name = "manage.events.ejb")
	EntityManager entityManager;

	@Override
	public void addParticipant(Participant participant) {
		entityManager.persist(participant);

	}

	@Override
	public void deleteParticipant(Participant participant) {
		entityManager.remove(findParticipantById(participant.getLogin()));

	}

	@Override
	public Participant findParticipantById(String login) {

		return entityManager.find(Participant.class, login);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Participant> findAllParticipants() {

		Query query = entityManager.createQuery("select p from Participant p");
		return query.getResultList();
	}

	@Override
	public Participant updateParticipant(Participant participant) {

		return entityManager.merge(participant);
	}
}
