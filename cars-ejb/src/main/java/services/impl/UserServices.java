package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import services.interfaces.UserServicesLocal;
import services.interfaces.UserServicesRemote;
import domain.Admin;
import domain.Credentials;
import domain.Customer;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserServices() {
	}

	@Override
	public Boolean addAdmin(Admin admin) {
		Boolean b = false;
		try {
			entityManager.persist(admin);
			b = true;
		} catch (Exception e) {
			System.out.println("problem ...");
		}
		return b;
	}

	@Override
	public Admin findAdminById(Integer id) {
		return entityManager.find(Admin.class, id);
	}

	@Override
	public Boolean deleteAdmin(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(findAdminById(id));
			b = true;
		} catch (Exception e) {
			System.out.println("problem ...");
		}
		return b;
	}

	@Override
	public Boolean updateAdmin(Admin admin) {
		Boolean b = false;
		try {
			entityManager.merge(admin);
			b = true;
		} catch (Exception e) {
			System.out.println("problem ...");
		}
		return b;
	}

	@Override
	public List<Admin> findAllAdmins() {
		return entityManager.createQuery("select a from Admin a", Admin.class)
				.getResultList();
	}

	@Override
	public Boolean addCustomer(Customer customer) {
		Boolean b = false;
		try {
			entityManager.persist(customer);
			b = true;
		} catch (Exception e) {
			System.out.println("problem ...");
		}
		return b;
	}

	@Override
	public Customer findCustomerById(Integer id) {
		return entityManager.find(Customer.class, id);
	}

	@Override
	public Boolean deleteCustomer(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(findCustomerById(id));
			b = true;
		} catch (Exception e) {
			System.out.println("problem ...");
		}
		return b;
	}

	@Override
	public Boolean updateCustomer(Customer customer) {
		Boolean b = false;
		try {
			entityManager.merge(customer);
			b = true;
		} catch (Exception e) {
			System.out.println("problem ...");
		}
		return b;
	}

	@Override
	public List<Customer> findAllCustomers() {
		return entityManager.createQuery("select c from Customer c",
				Customer.class).getResultList();
	}

	@Override
	public Object login(String login, String password) {
		Object user = null;
		Credentials credentials = null;
		TypedQuery<Credentials> query = entityManager.createQuery("select c from Credentials c where c.login=:param1 and c.password=:param2", Credentials.class);
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try{
			credentials = query.getSingleResult();
		}catch(NoResultException ex){
			System.out.println("access denied");
		}
		if (credentials != null) {
			try{
				user = entityManager.createQuery("select u from Admin u where u.credentials=:param1", Object.class).setParameter("param1", credentials).getSingleResult();
				
			}catch(NoResultException ex){
				System.out.println("not admin");
			}
			if (user == null) {
				try{
					user = entityManager.createQuery("select u from Customer u where u.credentials=:param1", Object.class).setParameter("param1", credentials).getSingleResult();
					
				}catch(NoResultException ex){
					System.out.println("problem...");
				}
			}
		}
		return user;
	}
}
	
	
