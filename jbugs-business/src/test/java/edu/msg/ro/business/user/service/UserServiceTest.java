package edu.msg.ro.business.user.service;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.junit.InSequence;
import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.exception.JBugsBusinessException;
import edu.msg.ro.business.exception.ObjectNotFoundException;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.dao.UserDao;
import edu.msg.ro.persistence.user.entity.User;

public class UserServiceTest extends AbstractIntegrationTest {

	@EJB
	private UserService sut;

	@EJB
	private UserDao userDao;

	@Test
	@InSequence(1)
	public void testSaveNewUser_Successful() {
		final String LASTNAME = "Smith";

		// ARRANGE
		List<UserDTO> userList = sut.getUserByLastName(LASTNAME);
		Assert.assertEquals("No user should exist!", userList.size(), 0);

		// ACT
		sut.saveNewUser("John", LASTNAME);

		// ASSERT
		userList = sut.getUserByLastName(LASTNAME);
		Assert.assertEquals("Exactly one user should be persisted", userList.size(), 1);
		Assert.assertTrue(userList.get(0).isActive());
	}

	@Test
	@InSequence(2)
	public void testSaveNewUser_validateState() {

		final List<UserDTO> userList = sut.getUserByLastName("Smith");

		Assert.assertTrue("TODO: check Arquillian docu for create/recreate db strategies", true);
	}

	@Test
	public void testDeleteUser() throws JBugsBusinessException {
		// ARRANGE
		final List<User> userList = userDao.getUserByLastName("Doe");
		Assert.assertEquals("There should be a user with name 'Doe'!", userList.size(), 1);
		Assert.assertTrue("The user should be active", userList.get(0).isActive());

		// ACT
		sut.deleteUser(userList.get(0).getId());

		// ASSERT
		final User deletedUser = userDao.findById(userList.get(0).getId());
		Assert.assertNotNull("Deletion is only logical, not physical!", deletedUser);
		Assert.assertFalse("User should be deactivated", deletedUser.isActive());
	}

	@Test(expected = ObjectNotFoundException.class)
	public void testDeleteUser_throwsObjectNotFoundException() throws JBugsBusinessException {
		// ARRANGE
		final User nonExistinguser = userDao.findById(3000L);
		Assert.assertNull("User should not exist", nonExistinguser);

		// ACT
		sut.deleteUser(3000L);

		// ASSERT
		// throws ObjectNotFoundException
	}

}
