package task.management.ejb.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import task.management.ejb.domain.ProductBacklog;
import task.management.ejb.domain.ScrumMaster;
import task.management.ejb.domain.TeamMember;
import task.management.ejb.domain.UserStory;
import task.management.services.exceptions.NoResultExceptionHandler;

@LocalBean
@Stateless
public class ProductBacklogManagement {

	@PersistenceContext
	EntityManager em;

	public void createProductBacklog(ProductBacklog productBacklog,
			ScrumMaster scrumMaster) {

		em.persist(productBacklog);
		TypedQuery<ScrumMaster> query = em.createNamedQuery(
				"findScrumMasterByemail", ScrumMaster.class);
		query.setParameter("email", scrumMaster.getEmail());
		scrumMaster = query.getSingleResult();
		scrumMaster.setProductBacklog(productBacklog);
		em.merge(scrumMaster);

	}

	public void addUserStory(UserStory userStory, ProductBacklog backlog) {
		userStory.setProductBacklog(backlog);
		em.persist(userStory);
		backlog.getUserStories().add(userStory);
		em.merge(backlog);
	}

	public List<UserStory> findBacklogUserStories(ProductBacklog backlog)
			throws NoResultExceptionHandler {
		TypedQuery<UserStory> query = em.createNamedQuery(
				"findByProductBacklog", UserStory.class);
		query.setParameter("idProductBacklog", backlog.getIdProductBacklog());
		try {
			return query.getResultList();
		} catch (NoResultException ex) {
			throw new NoResultExceptionHandler();
		}
	}

	public ProductBacklog findBacklogByMaster(ScrumMaster scrumMaster)
			throws NoResultExceptionHandler {
		TypedQuery<ProductBacklog> query = em.createNamedQuery(
				"findBacklogByMaster", ProductBacklog.class);
		query.setParameter("email", scrumMaster.getEmail());
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			throw new NoResultExceptionHandler();
		}
	}

	public void removeUserStory(UserStory selectedUserStory) {
		em.remove(em.merge(selectedUserStory));
	}

	public List<TeamMember> findTeamMemebers(ProductBacklog productBacklog)
			throws NoResultExceptionHandler {
		TypedQuery<TeamMember> query = em.createNamedQuery("findByProdBack",
				TeamMember.class);
		query.setParameter("id", productBacklog.getIdProductBacklog());
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			throw new NoResultExceptionHandler();
		}

	}

	public UserStory findUserStoryByDescription(String description) throws NoResultExceptionHandler {
		TypedQuery<UserStory> query = em.createNamedQuery(
				"findUserStoryByDescription", UserStory.class);
		query.setParameter("desc", description);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			throw new NoResultExceptionHandler();
		}
	}

}
