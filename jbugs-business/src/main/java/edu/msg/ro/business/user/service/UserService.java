package edu.msg.ro.business.user.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.UserDao;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.dto.mapper.UserDTOMapper;
import entities.User;

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

		userDao.persistUser(newUser);
	}

	public List<UserDTO> getUserByLastName(final String lastName) {
		List<User> users = userDao.getUserByLastName(lastName);

		return users.stream().map(userEntity -> userMapper.mapToDTO(userEntity)).collect(Collectors.toList());
	}

}
