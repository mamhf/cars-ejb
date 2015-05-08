package edu.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6838869964765206094L;
	
	private Date reservationDate;
	private Event event;
	private Venue venue;
	private ReservationId reservationId;
	
	public Reservation() {
	}
	

	public Reservation(Date reservationDate, Event event, Venue venue) {
		super();
		this.reservationDate = reservationDate;
		this.event = event;
		this.venue = venue;
		reservationId=new ReservationId(event.getId(), venue.getId());
	}


	@ManyToOne
	@JoinColumn(name = "idEvent", referencedColumnName = "id", insertable = false, updatable = false)
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}

	@ManyToOne
	@JoinColumn(name = "idVenue", referencedColumnName = "id", insertable = false, updatable = false)
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	@EmbeddedId
	public ReservationId getReservationId() {
		return reservationId;
	}

	public void setReservationId(ReservationId reservationId) {
		this.reservationId = reservationId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getReservationDate() {
		return reservationDate;
	}
	
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((reservationDate == null) ? 0 : reservationDate.hashCode());
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
		Reservation other = (Reservation) obj;
		if (reservationDate == null) {
			if (other.reservationDate != null)
				return false;
		} else if (!reservationDate.equals(other.reservationDate))
			return false;
		return true;
	}

	
}
