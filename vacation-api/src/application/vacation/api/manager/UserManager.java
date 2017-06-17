package application.vacation.api.manager;

import java.util.List;

import javax.ejb.Remote;

import application.vacation.api.exception.UserNotFoundException;
import application.vacation.model.User;

@Remote
public interface UserManager {
	List<User> findAllUsers();
	List<User> findUserToLogin(User user) throws UserNotFoundException ;
	User findUser(Long id) throws UserNotFoundException;
	User mergeUser(User user);
	void persistUser(User user);
	void removeUser(User user);
}
