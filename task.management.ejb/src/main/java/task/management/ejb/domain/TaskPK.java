package task.management.ejb.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TaskPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private int teamMember_FK;
	private int userStory_FK;
	private String role;

	public TaskPK() {
		super();
	}

	
	public TaskPK(int teamMember_FK, int userStory_FK, String role) {
		super();
		this.teamMember_FK = teamMember_FK;
		this.userStory_FK = userStory_FK;
		this.role = role;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + teamMember_FK;
		result = prime * result + userStory_FK;
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
		TaskPK other = (TaskPK) obj;
		if (teamMember_FK != other.teamMember_FK)
			return false;
		if (userStory_FK != other.userStory_FK)
			return false;
		return true;
	}


	public int getTeamMember_FK() {
		return teamMember_FK;
	}

	public void setTeamMember_FK(int teamMember_FK) {
		this.teamMember_FK = teamMember_FK;
	}

	public int getUserStory_FK() {
		return userStory_FK;
	}

	public void setUserStory_FK(int userStory_FK) {
		this.userStory_FK = userStory_FK;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

}
