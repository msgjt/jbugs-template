package edu.msg.ro.business;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.msg.ro.persistence.user.entity.User;

@Stateless
public class SomeEjb {

	@PersistenceContext(unitName = "jbugs-persistence")
	private EntityManager em;

	public User createUser() {
		User user = new User();

		em.persist(user);

		return user;
	}

	public User loadUser(Long id) {

		return em.find(User.class, id);
	}

}
