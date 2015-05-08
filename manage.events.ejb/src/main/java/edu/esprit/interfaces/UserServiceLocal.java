package edu.esprit.interfaces;

import edu.esprit.entities.User;

public interface UserServiceLocal {

	 User authenticate(String login, String motdepasse);

}
