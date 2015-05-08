package task.management.ejb.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ 
	
	@NamedQuery(name="findUserStoryById",query="select u from UserStory u where u.idUserStory=:id"),
	@NamedQuery(name="findUserStoryByDescription",query="select u from UserStory u where u.description=:desc"),
	@NamedQuery(name = "findByProductBacklog", query = "select us from UserStory us where us.productBacklog.idProductBacklog=:idProductBacklog") })
public class UserStory implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idUserStory;
	private List<Task> tasks;
	private String description;
	private BacklogSprint backlogSprint;
	private ProductBacklog productBacklog;
	private SystemActor actor;
	private String action;
	private UserStoryState state;

	public UserStory(SystemActor actor, String action, UserStoryState state, String description) {
		super();
		this.description = description;
		this.actor = actor;
		this.action = action;
		this.state = state;
	}

	public UserStory() {
		super();
	}

	@OneToMany(mappedBy = "userStory",cascade=CascadeType.REMOVE)
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name = "backlogSprint_FK")
	public BacklogSprint getBacklogSprint() {
		return backlogSprint;
	}

	public void setBacklogSprint(BacklogSprint backlogSprint) {
		this.backlogSprint = backlogSprint;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "actor_FK")
	public SystemActor getActor() {
		return actor;
	}

	public void setActor(SystemActor actor) {
		this.actor = actor;
	}

	public UserStoryState getState() {
		return state;
	}

	public void setState(UserStoryState state) {
		this.state = state;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdUserStory() {
		return idUserStory;
	}

	public void setIdUserStory(int idUserStory) {
		this.idUserStory = idUserStory;
	}

	@ManyToOne
	@JoinColumn(name = "productBacklog_FK")
	public ProductBacklog getProductBacklog() {
		return productBacklog;
	}

	public void setProductBacklog(ProductBacklog productBacklog) {
		this.productBacklog = productBacklog;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + idUserStory;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserStory other = (UserStory) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idUserStory != other.idUserStory)
			return false;
		return true;
	}

}
