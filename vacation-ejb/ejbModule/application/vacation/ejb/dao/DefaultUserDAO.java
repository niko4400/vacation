package application.vacation.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import application.vacation.api.dao.UserDAO;
import application.vacation.model.User;

/**
 * Session Bean implementation class DefaultUserDAO
 */
@Stateless
public class DefaultUserDAO implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public User findUser(Long id) {
		return entityManager.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUserToLogin(User user) {
		return entityManager.createNamedQuery("SELECT user "
				+ "FROM User user WHERE user.login = :" + user.getLogin() 
				+ " AND user.password = :" + user.getPassword()).getResultList();
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		return entityManager.createNamedQuery("User.findAllOrdered").getResultList();
	}

	@Override
	public User mergeUser(User user) {
		return entityManager.merge(user);
	}
	
	@Override
	public void persistUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void removeUser(User user) {
		entityManager.remove(user);
	}

}
