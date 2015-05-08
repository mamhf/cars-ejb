package task.management.ejb.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import task.management.ejb.domain.ProductBacklog;
import task.management.ejb.domain.ScrumMaster;
import task.management.ejb.domain.SystemActor;
import task.management.ejb.domain.TeamMember;
import task.management.ejb.domain.UserStory;
import task.management.ejb.domain.UserStoryState;
import task.management.ejb.services.ProductBacklogManagement;
import task.management.ejb.services.UserManagement;

@Singleton
@Startup
public class Stratup {

	@EJB
	UserManagement userManageService;
	@EJB
	ProductBacklogManagement productBackService;

	@PostConstruct
	public void init() {
		

		// Create BacklogProduct
		ProductBacklog productBacklog = new ProductBacklog(new Date(2016, 12,
				22), "My backlog");
		SystemActor actor = new SystemActor("administrator");
		UserStory userStory = new UserStory(actor, "a", UserStoryState.TODO,
				"as an " + actor.getName() + " i want to add a user");
		userStory.setProductBacklog(productBacklog);
		
		
		SystemActor actor2 = new SystemActor("Scrum master");
		UserStory userStory2 = new UserStory(actor2, "a", UserStoryState.TODO,
				"as a " + actor2.getName() + " i want to add a user story");
		userStory2.setProductBacklog(productBacklog);
		
		
		SystemActor actor3 = new SystemActor("team member");
		UserStory userStory3 = new UserStory(actor3, "a", UserStoryState.TODO,
				"as an " + actor3.getName() + " i want to consult the list of tasks assigned to me");
		userStory3.setProductBacklog(productBacklog);
		
		
		List<UserStory> userStories = new ArrayList<UserStory>();
		userStories.add(userStory);
		userStories.add(userStory2);
		userStories.add(userStory3);
		productBacklog.setUserStories(userStories);

		// Create Team member
		TeamMember teamMember = new TeamMember("ali", "ben salah",
				"ali@esprit.tn", "ali", 25, 2);
		userManageService.addTeamMember(teamMember);

		TeamMember teamMember2 = new TeamMember("imen", "ben mahmoud",
				"imen@esprit.tn", "imen", 25, 2);
		userManageService.addTeamMember(teamMember2);
		
		

		// Create Scrum Master
		ScrumMaster scrumMaster = new ScrumMaster("mouhamed", "ben salah",
				"master@esprit.tn", "master", 22);
		userManageService.addScrumMaster(scrumMaster, productBacklog);

		userManageService.attachTeamMemberToScrumMaster(teamMember,scrumMaster);
		userManageService.attachTeamMemberToScrumMaster(teamMember2,scrumMaster);
	}

	public Stratup() {
		super();
	}

}
