package services.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import domain.Car;
import domain.CarType;
import domain.Customer;

@Local
public interface RentalServicesLocal {
	Boolean addCar(Car car);

	Boolean deleteCar(Integer id);

	Boolean updateCar(Car car);

	Car findCarById(Integer id);

	List<Car> findAllCars();

	Boolean addCarType(CarType carType);

	Boolean createContract(Customer customer, Car car, Date startDate,
			Integer days);

	Long countContracts(Integer idCar);

	CarType findCarTypeByName(String name);

	List<CarType> findAllCarTypes();

	List<Car> findCarsByCarTpe(CarType carType);
}
