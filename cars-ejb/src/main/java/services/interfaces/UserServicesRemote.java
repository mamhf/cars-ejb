package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import domain.Admin;
import domain.Customer;

@Remote
public interface UserServicesRemote {
	Boolean addAdmin(Admin admin);

	Admin findAdminById(Integer id);

	Boolean deleteAdmin(Integer id);

	Boolean updateAdmin(Admin admin);

	List<Admin> findAllAdmins();

	Boolean addCustomer(Customer customer);

	Customer findCustomerById(Integer id);

	Boolean deleteCustomer(Integer id);

	Boolean updateCustomer(Customer customer);

	List<Customer> findAllCustomers();

	Object login(String login, String password);
}
