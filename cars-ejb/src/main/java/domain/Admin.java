package domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
public class Admin implements Serializable {

	private Integer id;
	private static final long serialVersionUID = 1L;

	private Credentials credentials;

	public Admin() {
		super();
	}

	public Admin(Credentials credentials) {
		super();
		this.credentials = credentials;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(unique=true)
	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

}
