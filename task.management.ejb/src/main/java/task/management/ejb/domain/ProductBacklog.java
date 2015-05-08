package task.management.ejb.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({

@NamedQuery(name = "findBacklogByMaster", query = "select p from ProductBacklog p where p.scrumMaster.email=:email") })
public class ProductBacklog implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idProductBacklog;

	private String name;
	private Date releaseDate;
	private ScrumMaster scrumMaster;
	private List<UserStory> userStories;

	public ProductBacklog() {
		super();
	}

	public ProductBacklog(Date releaseDate, String name) {
		super();
		this.releaseDate = releaseDate;
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdProductBacklog() {
		return idProductBacklog;
	}

	public void setIdProductBacklog(int idProductBacklog) {
		this.idProductBacklog = idProductBacklog;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne(mappedBy = "productBacklog")
	public ScrumMaster getScrumMaster() {
		return scrumMaster;
	}

	public void setScrumMaster(ScrumMaster scrumMaster) {
		this.scrumMaster = scrumMaster;
	}

	@OneToMany(mappedBy = "productBacklog", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public List<UserStory> getUserStories() {
		return userStories;
	}

	public void setUserStories(List<UserStory> userStories) {
		this.userStories = userStories;
	}

}
