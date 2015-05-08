package services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import services.interfaces.RentalServicesLocal;
import services.interfaces.RentalServicesRemote;
import domain.Car;
import domain.CarType;
import domain.Contract;
import domain.Customer;

/**
 * Session Bean implementation class RentalServices
 */
@Stateless
public class RentalServices implements RentalServicesRemote,
		RentalServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public RentalServices() {
	}

	@Override
	public Boolean addCar(Car car) {
		Boolean b = false;
		try {
			entityManager.persist(car);
			b = true;
		} catch (Exception e) {
			System.out.println("problem ...");
		}
		return b;
	}

	@Override
	public Boolean deleteCar(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(findCarById(id));
			b = true;
		} catch (Exception e) {
			System.out.println("problem ...");
		}
		return b;
	}

	@Override
	public Boolean updateCar(Car car) {
		Boolean b = false;
		try {
			entityManager.merge(car);
			b = true;
		} catch (Exception e) {
			System.out.println("problem ...");
		}
		return b;
	}

	@Override
	public Car findCarById(Integer id) {
		return entityManager.find(Car.class, id);
	}

	@Override
	public List<Car> findAllCars() {
		return entityManager.createQuery("select c from Car c", Car.class)
				.getResultList();
	}

	@Override
	public Boolean addCarType(CarType carType) {
		Boolean b = false;
		try {
			entityManager.persist(carType);
			b = true;
		} catch (Exception e) {
			System.out.println("problem ...");
		}
		return b;
	}

	@Override
	public Boolean createContract(Customer customer, Car car, Date startDate,
			Integer days) {
		Boolean b = false;
		try {
			Contract contract = new Contract(customer, car, startDate, days);
			entityManager.persist(contract);
			b = true;
		} catch (Exception e) {
			System.out.println("problem ...");
		}
		return b;
	}

	@Override
	public Long countContracts(Integer idCar) {
		Long contractsCount = 0L;
		TypedQuery<Long> query = entityManager.createQuery("select count(c) from Contract c where c.contractId.idCar=:param1" ,Long.class);
		query.setParameter("param1", idCar);
		try{
			contractsCount = query.getSingleResult();
		}catch(NoResultException ex){
			System.out.println("no contract");
		}
		return contractsCount;
	}

	@Override
	public CarType findCarTypeByName(String name) {
		CarType found = null;
		TypedQuery<CarType> query = entityManager.createQuery("select c from CarType c where c.name=:param1" ,CarType.class);
		query.setParameter("param1", name);
		try{
			found = query.getSingleResult();
		}catch(NoResultException ex){
			System.out.println("no such carType");
		}
		return found;
	}

	@Override
	public List<CarType> findAllCarTypes() {
		return entityManager.createQuery("select c from CarType c",CarType.class).getResultList();
	}

	@Override
	public List<Car> findCarsByCarTpe(CarType carType) {
		return entityManager.createQuery("select c from Car c where c.carType=:param1",Car.class).setParameter("param1", carType).getResultList();
	}
}
