package task.management.ejb.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import task.management.ejb.domain.Task;
import task.management.ejb.domain.TaskPK;
import task.management.ejb.domain.TaskState;
import task.management.ejb.domain.TeamMember;
import task.management.ejb.domain.UserStory;
import task.management.ejb.domain.UserStoryState;
import task.management.services.exceptions.NoResultExceptionHandler;

@LocalBean
@Stateless
public class UserStoryManagement {
	@PersistenceContext
	EntityManager em;
	
	
	public void assignTaskToMember(TeamMember teamMember, String description,
			UserStory userStory, String role) {
		userStory.setState(UserStoryState.ONSPRINT);
		em.merge(userStory);
		Task task = new Task(TaskState.DOING, description);
		task.setPk(new TaskPK(teamMember.getIdUser(), userStory
				.getIdUserStory(), role));
		em.persist(task);

	}

	public List<Task> findTaskByMember(TeamMember member)
			throws NoResultExceptionHandler {
		TypedQuery<Task> query = em.createNamedQuery("findTaskByMember",
				Task.class);
		query.setParameter("email", member.getEmail());
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			throw new NoResultExceptionHandler();
		}
	}

	public void changeTaskState(Task task) {
		em.merge(task);
		
	}

}
