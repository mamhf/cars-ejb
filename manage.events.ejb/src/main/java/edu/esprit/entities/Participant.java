package edu.esprit.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Participant
 *
 */
@Entity
@NamedQuery(name = "listEventsPerPerticipant", query = "select liste from Participant p join p.evenements liste where p.login like :var")
public class Participant extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Float solde;
	
	private List<Event> evenements = new ArrayList<Event>();

	public Participant() {
		super();
	}

	@ManyToMany(fetch = FetchType.EAGER)
	public List<Event> getEvenements() {
		return evenements;
	}

	public void setEvenements(List<Event> evenements) {
		this.evenements = evenements;
	}

	

	public Float getSolde() {
		return solde;
	}

	
	public void setSolde(Float solde) {
		this.solde = solde;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(solde);
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participant other = (Participant) obj;
		if (Float.floatToIntBits(solde) != Float.floatToIntBits(other.solde))
			return false;
		return true;
	}

	public Participant(Float solde) {
		super();
		this.solde = solde;
	}

	

}
