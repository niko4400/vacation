package application.vacation.ejb.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import application.vacation.api.dao.UserDAO;
import application.vacation.api.exception.UserNotFoundException;
import application.vacation.api.manager.UserManager;
import application.vacation.model.User;


/**
 * Session Bean implementation class DefaultUserManager
 */

@Stateless
public class DefaultUserManager implements UserManager {

	@EJB
	private UserDAO userDAO;

	@Override
	public void removeUser(User user) {
		userDAO.removeUser(user);
	}

	@Override
	public void persistUser(User user) {
		userDAO.persistUser(user);
	}

	@Override
	public User mergeUser(User user) {
		return userDAO.mergeUser(user);
	}

	@Override
	public User findUser(Long id) throws UserNotFoundException {
		User user = userDAO.findUser(id);
		if (user == null)
			throw new UserNotFoundException();
		return user;
	}

	@Override
	public List<User> findAllUsers() {
		return userDAO.findAllUsers();
	}
	
	@Override
	public List<User> findUserToLogin(User user) throws UserNotFoundException {
		List<User> users = userDAO.findAllUsers();
		if (users == null)
			throw new UserNotFoundException();
		return users;
	}
	
	
}
