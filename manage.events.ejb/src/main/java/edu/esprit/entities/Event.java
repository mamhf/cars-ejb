package edu.esprit.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Evenement
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="findAllReservationsPerEvent",query="select ls from Event e join e.reservations ls where e.id like :var"),
	@NamedQuery(name="findAllParticipantsPerEvent",query="select liste from Event ev join ev.participants liste where ev.id like :var"),
})
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int nbPlace;
	private int nbPlaceInitial;
	private Date date;
	private String  eventName;
	private List<Reservation> reservations;
	private List<Participant> participants;
	private CategoryEvent categoryEvent;
	private Organizer organizer;
	private Float fees;

	public Event() {
		
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getNbPlace() {
		return this.nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	
	@OneToMany(mappedBy="event",cascade=CascadeType.REMOVE)
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	@ManyToMany(mappedBy="evenements",cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	public List<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
	@ManyToOne
	public CategoryEvent getCategoryEvent() {
		return categoryEvent;
	}
	public void setCategoryEvent(CategoryEvent categoryEvent) {
		this.categoryEvent = categoryEvent;
	}
	@ManyToOne
	public Organizer getOrganizer() {
		return organizer;
	}
	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int getNbPlaceInitial() {
		return nbPlaceInitial;
	}
	public void setNbPlaceInitial(int nbPlaceInitial) {
		this.nbPlaceInitial = nbPlaceInitial;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public Float getFees() {
		return fees;
	}
	public void setFees(Float fees) {
		this.fees = fees;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fees == null) ? 0 : fees.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((eventName == null) ? 0 : eventName.hashCode());
		result = prime * result + id;
		result = prime * result + nbPlace;
		result = prime * result + nbPlaceInitial;
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
		Event other = (Event) obj;
		if (fees == null) {
			if (other.fees != null)
				return false;
		} else if (!fees.equals(other.fees))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		if (id != other.id)
			return false;
		if (nbPlace != other.nbPlace)
			return false;
		if (nbPlaceInitial != other.nbPlaceInitial)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", nbPlace=" + nbPlace + ", nbPlaceInitial="
				+ nbPlaceInitial + ", date=" + date + ", eventName="
				+ eventName + ", costs=" + fees + "]";
	}
	public Event(int id, int nbPlace, int nbPlaceInitial, Date date,
			String eventName, Float costs) {
		super();
		this.id = id;
		this.nbPlace = nbPlace;
		this.nbPlaceInitial = nbPlaceInitial;
		this.date = date;
		this.eventName = eventName;
		this.fees = costs;
	}
	

	
	
   
}
