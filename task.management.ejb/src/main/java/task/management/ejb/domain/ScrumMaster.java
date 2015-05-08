package task.management.ejb.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "findScrumMasterByemail", query = "select s from ScrumMaster s where s.email=:email"),
	@NamedQuery(name="hasBacklog",query="select s from ScrumMaster s where s.email=:email and s.productBacklog is not null")

})
public class ScrumMaster extends User {

	private static final long serialVersionUID = 1L;
	private ProductBacklog productBacklog;
	private List<TeamMember> team;

	public ScrumMaster(String firstName, String lastName, String email,
			String password, int age) {
		super(firstName, lastName, email, password, age);
	}

	public ScrumMaster() {
		super();
	}

	@OneToOne
	@JoinColumn(name = "productBacklog_FK")
	public ProductBacklog getProductBacklog() {
		return productBacklog;
	}

	public void setProductBacklog(ProductBacklog productBacklog) {
		this.productBacklog = productBacklog;
	}

	@OneToMany(mappedBy = "scrumMaster")
	public List<TeamMember> getTeam() {
		return team;
	}

	public void setTeam(List<TeamMember> team) {
		this.team = team;
	}

}
