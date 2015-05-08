package edu.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: LocalEvenement
 *
 */
@Entity
@NamedQuery(name = "findAllReservationPerVenue", query = "select liste from Venue lv join lv.reservations liste where lv.id like :var")
public class Venue implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String address;
	private float rentalPrice;
	private List<Reservation> reservations;

	public Venue() {

	}

	public Venue(int id, String address, float rentalPrice) {
		super();
		this.id = id;
		this.address = address;
		this.rentalPrice = rentalPrice;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(float rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	@OneToMany(mappedBy = "venue")
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
		result = prime * result + Float.floatToIntBits(rentalPrice);
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
		Venue other = (Venue) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(rentalPrice) != Float
				.floatToIntBits(other.rentalPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", address=" + address + ", rentalPrice="
				+ rentalPrice + "]";
	}

}
