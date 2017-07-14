package ro.msg.edu.jbugs.business.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ro.msg.edu.jbugs.business.UserServiceRemote;
import ro.msg.edu.jbugs.entities.User;

/**
 * Session Bean implementation class UserService
 */
@Stateless
public class UserService implements UserServiceRemote {

	@PersistenceContext(unitName = "jbugs")
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public void addUser(User user) {
		entityManager.persist(user);
	}
}
