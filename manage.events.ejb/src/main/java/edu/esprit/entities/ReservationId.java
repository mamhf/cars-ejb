package edu.esprit.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ReservationId implements Serializable {

	
	private static final long serialVersionUID = -7262901468819152781L;
	private int idEvent;
	private int idVenue;

	

	
	public int getIdEvent() {
		return idEvent;
	}

	public ReservationId(int idEvent, int idVenue) {
		super();
		this.idEvent = idEvent;
		this.idVenue = idVenue;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public int getIdVenue() {
		return idVenue;
	}

	public void setIdVenue(int idVenue) {
		this.idVenue = idVenue;
	}

	public ReservationId() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEvent;
		result = prime * result + idVenue;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationId other = (ReservationId) obj;
		if (idEvent != other.idEvent)
			return false;
		if (idVenue != other.idVenue)
			return false;
		return true;
	}

	
	
}
