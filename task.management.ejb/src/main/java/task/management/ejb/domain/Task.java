package task.management.ejb.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "findTaskByMember", query = "select t from Task t where t.teamMember.email=:email") })
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;
	private TaskState state;
	private TaskPK pk;
	private TeamMember teamMember;
	private UserStory userStory;
	private String description;

	public Task(TaskState state, String description) {
		super();
		this.state = state;
		this.description = description;
	}

	public Task() {
		super();
	}

	public TaskState getState() {
		return state;
	}

	public void setState(TaskState state) {
		this.state = state;
	}

	@EmbeddedId
	public TaskPK getPk() {
		return pk;
	}

	public void setPk(TaskPK pk) {
		this.pk = pk;
	}

	@ManyToOne
	@JoinColumn(name = "teamMember_FK", insertable = false, updatable = false)
	public TeamMember getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(TeamMember teamMember) {
		this.teamMember = teamMember;
	}

	@ManyToOne
	@JoinColumn(name = "userStory_FK", insertable = false, updatable = false)
	public UserStory getUserStory() {
		return userStory;
	}

	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
