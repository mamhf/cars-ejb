package task.management.ejb.services;

import java.util.ArrayList;
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
import task.management.ejb.domain.User;
import task.management.services.exceptions.NoResultExceptionHandler;

@Stateless
@LocalBean
public class UserManagement {

	@PersistenceContext
	private EntityManager em;

	public void addTeamMember(TeamMember member) {
		em.persist(member);
	}

	public void addScrumMaster(ScrumMaster scrumMaster,
			ProductBacklog productBacklog) {
		em.persist(productBacklog);
		scrumMaster.setProductBacklog(productBacklog);
		em.persist(scrumMaster);
		productBacklog.setScrumMaster(scrumMaster);
		em.merge(productBacklog);

	}

	public List<TeamMember> findTeamByScrumMaster(ScrumMaster scrumMaster)
			throws NoResultExceptionHandler {
		TypedQuery<TeamMember> query = em.createNamedQuery("findByScrumMaster",
				TeamMember.class);
		query.setParameter("email", scrumMaster.getEmail());
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			throw new NoResultExceptionHandler();
		}

	}

	public boolean hasProductBacklog(ScrumMaster scrumMaster) {
		TypedQuery<ScrumMaster> query = em.createNamedQuery("hasBacklog",
				ScrumMaster.class);
		query.setParameter("email", scrumMaster.getEmail());
		try {
			query.getSingleResult();
			return true;
		} catch (NoResultException ex) {
			return false;
		}
	}

	public User findUserByEmailAndPassword(String email, String password)
			throws NoResultExceptionHandler {
		TypedQuery<User> query = em.createNamedQuery("findByEmailAndPwd",
				User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			throw new NoResultExceptionHandler();
		}
	}

	public boolean findUserByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("findByEmail", User.class);
		query.setParameter("email", email);
		return (query.getResultList().size() > 0);
	}

	public void registerUser(User user) {
		em.persist(user);
	}

	public List<User> findAllUsers() {
		TypedQuery<User> query = em.createNamedQuery("findAll", User.class);
		return query.getResultList();
	}

	public List<TeamMember> findAllMembers() {
		TypedQuery<TeamMember> query = em.createNamedQuery("findAllMembers",
				TeamMember.class);
		return query.getResultList();
	}

	public void addTeamMemberToScrumMaster(TeamMember teamMember,
			ScrumMaster scrumMaster) {
		List<TeamMember> team = new ArrayList<TeamMember>();
		teamMember.setScrumMaster(scrumMaster);
		em.persist(teamMember);
		try {
			team = findTeamByScrumMaster(scrumMaster);
			team.add(teamMember);

		} catch (NoResultException | NoResultExceptionHandler e) {
			e.printStackTrace();
			team.add(teamMember);
			scrumMaster.setTeam(team);
		}
		em.merge(scrumMaster);

	}

	public void attachTeamMemberToScrumMaster(TeamMember teamMember,
			ScrumMaster scrumMaster) {

		teamMember.setScrumMaster(scrumMaster);
		em.merge(teamMember);

	}

	public TeamMember findTeamMemberByMail(String email)
			throws NoResultExceptionHandler {
		TypedQuery<TeamMember> query = em.createNamedQuery("findMemberByMail",
				TeamMember.class);
		query.setParameter("email", email);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			throw new NoResultExceptionHandler();
		}
	}

	
}
