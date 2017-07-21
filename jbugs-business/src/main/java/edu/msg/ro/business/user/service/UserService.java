package edu.msg.ro.business.user.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.exception.JBugsBusinessException;
import edu.msg.ro.business.exception.ObjectNotFoundException;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.dto.mapper.UserDTOMapper;
import edu.msg.ro.persistence.user.dao.UserDao;
import edu.msg.ro.persistence.user.entity.User;

@Stateless
public class UserService {

	@EJB
	private UserDao userDao;

	@EJB
	private UserDTOMapper userMapper;

	public void saveNewUser(final String firstName, final String lastName) {
		final User newUser = new User();
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setActive(true);

		userDao.persistUser(newUser);
	}

	public List<UserDTO> getUserByLastName(final String lastName) {
		final List<User> users = userDao.getUserByLastName(lastName);

		return users.stream().map(userEntity -> userMapper.mapToDTO(userEntity)).collect(Collectors.toList());
	}

	/**
	 * Delete the user with the given {@code userId}.
	 * 
	 * @param userId
	 *            todo
	 * @return todo
	 * @throws JBugsBusinessException
	 *             if user with given idis not found
	 */
	public boolean deleteUser(final Long userId) throws JBugsBusinessException {
		final User user = userDao.findById(userId);
		if (user == null) {
			// TODO: maybe is better to return only false value!?
			throw new ObjectNotFoundException("User with id " + userId + " not found!");
		}
		// TODO
		// validate business constraints (Nu se pot sterge utilizatorii care au
		// asignate taskuri care nu sunt inca terminate / inchise) - in caz
		// contrar aruncam BusinessValidationException

		user.setActive(false);

		return true;
	}

}
