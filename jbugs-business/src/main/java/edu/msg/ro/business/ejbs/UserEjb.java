package edu.msg.ro.business.ejbs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.msg.ro.business.dto.UserDTO;
import edu.msg.ro.business.dto.mapper.UserDTOMapper;
import edu.msg.ro.persistence.user.entity.User;

@Stateless
public class UserEjb {

	@PersistenceContext(unitName = "jbugs-persistence")
	private EntityManager em;

	public UserDTO getUserByLastname(String lastname) {
		TypedQuery<User> query = em.createNamedQuery(User.FIND_USER_BY_LASTNAME, User.class);
		query.setParameter("lastname", lastname);

		User user = query.getSingleResult();

		return new UserDTOMapper().mapToDTO(user);
	}

	public UserDTO createUser(UserDTO user) {

		// TODO persist user

		// return persisted user
		return null;
	}

}
