package application.vacation.api.dao;


import java.util.List;

import application.vacation.model.User;

public interface UserDAO {
	User findUser(Long id);
	List<User> findUserToLogin(User user);
	List<User> findAllUsers();
	List<User> findAllUsersExclude(User user);
	User mergeUser(User user);
	void persistUser(User user);
	void removeUser(User user);

}
