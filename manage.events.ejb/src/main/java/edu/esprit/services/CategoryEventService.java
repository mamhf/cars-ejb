package edu.esprit.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.entities.CategoryEvent;
import edu.esprit.entities.Event;
import edu.esprit.interfaces.CategoryEventServiceLocal;

@Stateless
@Local(CategoryEventServiceLocal.class)
public class CategoryEventService implements CategoryEventServiceLocal {

	@PersistenceContext(name = "manage.events.ejb")
	EntityManager entityManager;

	@Override
	public void addCategoryEvent(CategoryEvent categoryEvent) {
		entityManager.persist(categoryEvent);

	}

	@Override
	public void deleteCategoryEvent(CategoryEvent categoryEvent) {
		entityManager.remove(findCategoryEventById(categoryEvent.getId()));

	}

	@Override
	public CategoryEvent findCategoryEventById(int id) {

		return entityManager.find(CategoryEvent.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryEvent> findAllCategoryEvents() {
		Query query = entityManager
				.createQuery("select ce from CategoryEvent ce");
		return query.getResultList();
	}

	@Override
	public CategoryEvent updateCategoryEvent(CategoryEvent categoryEvent) {

		return entityManager.merge(categoryEvent);
	}

	@Override
	public CategoryEvent findCategoryEventByType(String type) {
		Query q = entityManager.createQuery(
				"select u from CategoryEvent " + "u where u.typeEvenement=:p1")
				.setParameter("p1", type);

		return (CategoryEvent) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findAllEventsPerType(int id) {
		return entityManager.createNamedQuery("findAllEventsPerType")
				.setParameter("var", id).getResultList();
	}
}
