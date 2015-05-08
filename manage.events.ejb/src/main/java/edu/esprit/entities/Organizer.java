package edu.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Organisateur
 *
 */
@Entity
public class Organizer extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private int age;
	private List<Event> events;

	public Organizer() {
		super();
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@OneToMany(mappedBy = "organizer")
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
		result = prime * result + age;
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
		Organizer other = (Organizer) obj;
		if (age != other.age)
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Organisateur [age=" + age + "]";
	}

	public Organizer(String login, String password, String email,
			String firstName, String lastName,int age) {
		super(login,password,email,firstName,lastName);
		this.age = age;
	}

}
