package edu.esprit.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.entities.User;
import edu.esprit.interfaces.UserServiceLocal;

@Stateless
@Local(UserServiceLocal.class)
public class UserService implements UserServiceLocal {

	@PersistenceContext(name = "gestion.evenement.ejb")
	EntityManager entityManager;

	@Override
	public User authenticate(String login, String password) {
		User found = null;
		String jpql = "select u from User u where u.login=:login and u.password=:password";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("login", login);
		query.setParameter("password", password);
		try {
			found = (User) query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(UserService.class.getName()).log(
					Level.WARNING,
					"authentication attempt failure with " + "login=" + login
							+ " and password=" + password);
		}
		return found;
	}

}
