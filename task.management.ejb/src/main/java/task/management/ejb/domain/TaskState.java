package task.management.ejb.domain;

public enum TaskState {

	TODO("TO DO"),
	DOING("Doing"),
	DONE("Done");

	private String description;

	private TaskState(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
