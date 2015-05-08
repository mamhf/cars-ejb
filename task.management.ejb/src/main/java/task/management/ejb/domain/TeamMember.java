package task.management.ejb.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: TeamMember
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "findAllMembers", query = "select t from TeamMember t"),
		@NamedQuery(name="findMemberByMail",query="select t from TeamMember t where t.email=:email"),
		@NamedQuery(name="findByProdBack",query="select t from TeamMember t where t.scrumMaster.productBacklog.idProductBacklog=:id" ),
		@NamedQuery(name = "findByScrumMaster", query = "select t from TeamMember t where t.scrumMaster.email=:email") })
public class TeamMember extends User {

	private static final long serialVersionUID = 1L;
	private List<Task> tasks;
	private ScrumMaster scrumMaster;
	private int experienceInYears;

	public TeamMember() {
		super();
	}

	public TeamMember(String firstName, String lastName, String email,
			String password, int age, int experienceInYears) {
		super(firstName, lastName, email, password, age);
		
		this.experienceInYears = experienceInYears;
	}


	@OneToMany(mappedBy = "teamMember")
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public int getExperienceInYears() {
		return experienceInYears;
	}

	public void setExperienceInYears(int experienceInYears) {
		this.experienceInYears = experienceInYears;
	}

	@ManyToOne
	@JoinColumn(name = "scrumMaster_FK")
	public ScrumMaster getScrumMaster() {
		return scrumMaster;
	}

	public void setScrumMaster(ScrumMaster scrumMaster) {
		this.scrumMaster = scrumMaster;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + experienceInYears;
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
		TeamMember other = (TeamMember) obj;
		if (experienceInYears != other.experienceInYears)
			return false;
		return true;
	}

}
