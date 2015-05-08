package edu.esprit.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.entities.Venue;
import edu.esprit.interfaces.VenueServiceLocal;


@Stateless
@Local(VenueServiceLocal.class)
public class VenueService implements VenueServiceLocal{

	@PersistenceContext(name="manage.events.ejb")
	EntityManager entityManager;

	@Override
	public void addVenue(Venue venue)
 {
		entityManager.persist(venue);
		
	}

	@Override
	public void deleteVenue(Venue venue) {
		entityManager.remove(findVenueById(venue.getId()));
		
	}

	@Override
	public Venue findVenueById(int id){
		 
		return entityManager.find(Venue.class,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Venue> findAllVenues(){
		Query query=entityManager.createQuery("select l from Venue l");
		return query.getResultList();
	}

	@Override
	public Venue updateVenue(Venue venue) {
		
		return entityManager.merge(venue);
	}
	
}
