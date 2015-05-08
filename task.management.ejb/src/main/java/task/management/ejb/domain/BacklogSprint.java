package task.management.ejb.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class BacklogSprint implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idSprintBacklog;
	private List<UserStory> userStories;
	private ProductBacklog productBacklog;
	private Date startingDate;
	private Date endingDate;

	public BacklogSprint(Date startingDate, Date endingDate) {
		super();
		this.startingDate = startingDate;
		this.endingDate = endingDate;
	}

	public BacklogSprint() {
		super();
	}

	@OneToMany(mappedBy = "backlogSprint")
	public List<UserStory> getUserStories() {
		return userStories;
	}

	public void setUserStories(List<UserStory> userStories) {
		this.userStories = userStories;
	}

	@Temporal(TemporalType.DATE)
	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdSprintBacklog() {
		return idSprintBacklog;
	}

	public void setIdSprintBacklog(int idSprintBacklog) {
		this.idSprintBacklog = idSprintBacklog;
	}

	@ManyToOne
	@JoinColumn(name = "prodBackloh_FK")
	public ProductBacklog getProductBacklog() {
		return productBacklog;
	}

	public void setProductBacklog(ProductBacklog productBacklog) {
		this.productBacklog = productBacklog;
	}

}
