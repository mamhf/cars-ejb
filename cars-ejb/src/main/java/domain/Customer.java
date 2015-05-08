package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
public class Customer implements Serializable {

	private Integer id;
	private String name;
	private static final long serialVersionUID = 1L;

	private Credentials credentials;
	private List<Contract> contracts;

	public Customer() {
		super();
	}

	public Customer(String name, Credentials credentials) {
		super();
		this.name = name;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(unique=true)
	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	@OneToMany(mappedBy = "customer")
	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

}
