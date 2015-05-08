package services;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import services.interfaces.RentalServicesLocal;
import services.interfaces.UserServicesLocal;
import domain.Admin;
import domain.Car;
import domain.CarType;
import domain.Credentials;
import domain.Customer;

/**
 * Session Bean implementation class Populator
 */
@Singleton
@Startup
@LocalBean
public class Populator {
	@EJB
	private UserServicesLocal userServicesLocal;
	@EJB
	private RentalServicesLocal rentalServicesLocal;

	/**
	 * Default constructor.
	 */
	public Populator() {
	}

	@PostConstruct
	public void initDB() {
		Credentials credentials = new Credentials("admin", "admin");
		Admin agency = new Admin(credentials);

		Credentials credentials2 = new Credentials("c1", "c1");
		Customer customer = new Customer("foulen", credentials2);
		Credentials credentials3 = new Credentials("c2", "c2");
		Customer customer2 = new Customer("foulena", credentials3);

		CarType carType = new CarType("SUV");
		CarType carType2 = new CarType("BERLINE");
		CarType carType3 = new CarType("PICKUP");

		Car car = new Car("Mercedes-Benz ML350", "177TU8040", carType);
		Car car4 = new Car("Citroën C4 Cactus", "180TU8630", carType);
		Car car2 = new Car("BMW 320d", "166TU5061", carType2);
		Car car3 = new Car("ISUZU", "155TU6854", carType3);
		car3.setAvailable(false);

		userServicesLocal.addAdmin(agency);
		userServicesLocal.addCustomer(customer);
		userServicesLocal.addCustomer(customer2);

		rentalServicesLocal.addCar(car);
		rentalServicesLocal.addCar(car2);
		rentalServicesLocal.addCar(car3);
		rentalServicesLocal.addCar(car4);

		rentalServicesLocal.addCarType(carType);
		rentalServicesLocal.addCarType(carType2);
		rentalServicesLocal.addCarType(carType3);

		rentalServicesLocal.createContract(customer, car,
				DateHelper.toDate("24/04/15 11:49:30"), 3);
		rentalServicesLocal.createContract(customer, car,
				DateHelper.toDate("25/04/15 11:49:30"), 5);
		rentalServicesLocal.createContract(customer, car,
				DateHelper.toDate("26/04/15 11:49:30"), 7);
		rentalServicesLocal.createContract(customer2, car,
				DateHelper.toDate("24/04/15 11:49:30"), 2);
		rentalServicesLocal.createContract(customer2, car,
				DateHelper.toDate("25/04/15 11:49:30"), 4);
		rentalServicesLocal.createContract(customer, car2,
				DateHelper.toDate("22/04/15 11:49:30"), 3);
		rentalServicesLocal.createContract(customer2, car2,
				DateHelper.toDate("05/04/15 11:49:30"), 1);
		rentalServicesLocal.createContract(customer, car3,
				DateHelper.toDate("01/04/15 11:49:30"), 4);

	}

}
