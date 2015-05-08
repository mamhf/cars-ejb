package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Contract
 *
 */
@Entity
public class Contract implements Serializable {

	private ContractId contractId;
	private Integer days;
	private static final long serialVersionUID = 1L;

	private Customer customer;
	private Car car;

	public Contract() {
		super();
	}

	public Contract(Customer customer, Car car, Date startDate, Integer days) {
		this.days = days;
		this.customer = customer;
		this.car = car;
		this.contractId = new ContractId(customer.getId(), car.getId(), startDate);
	}

	public Integer getDays() {
		return this.days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	@EmbeddedId
	public ContractId getContractId() {
		return contractId;
	}

	public void setContractId(ContractId contractId) {
		this.contractId = contractId;
	}

	@ManyToOne
	@JoinColumn(name = "idCustomer", referencedColumnName = "id", updatable = false, insertable = false)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne
	@JoinColumn(name = "idCar", referencedColumnName = "id", updatable = false, insertable = false)
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
