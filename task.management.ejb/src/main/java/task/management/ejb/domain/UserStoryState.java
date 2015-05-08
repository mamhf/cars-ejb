package task.management.ejb.domain;

public enum UserStoryState {

	TODO("This user story is not assigned to team member"),
	ONSPRINT("This user story is assigned to a team member"),
	DONE("This user story is done");

	private String description;

	private UserStoryState(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
