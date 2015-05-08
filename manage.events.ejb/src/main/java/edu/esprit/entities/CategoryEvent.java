package edu.esprit.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TypeEvenement
 *
 */
@Entity
@NamedQuery(name="findAllEventsPerType",query="select liste from CategoryEvent ce join ce.events liste where ce.id like :var")

public class CategoryEvent implements Serializable {

	   
	
	private int id;
	private String typeEvenement;
	private static final long serialVersionUID = 1L;
	private List<Event> events;

	public CategoryEvent() {
		super();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getTypeEvenement() {
		return this.typeEvenement;
	}

	public void setTypeEvenement(String typeEvenement) {
		this.typeEvenement = typeEvenement;
	}
	@OneToMany(mappedBy="categoryEvent")
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		CategoryEvent other = (CategoryEvent) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public CategoryEvent(String typeEvenement) {
		super();
		this.typeEvenement = typeEvenement;
	}
   
}
