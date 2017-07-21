package edu.msg.ro.business.user.service;

import java.util.List;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.user.dto.UserDTO;

public class UserServiceTest extends AbstractIntegrationTest {

	@EJB
	private UserService sut;

	@Test
	public void testSaveNewUser() {
		String LASTNAME = "Smith";

		// ARRANGE
		List<UserDTO> userList = sut.getUserByLastName(LASTNAME);
		Assert.assertEquals("No user should exist!", 0, userList.size());

		// ACT
		sut.saveNewUser("John", LASTNAME);

		// ASSERT
		userList = sut.getUserByLastName(LASTNAME);
		Assert.assertEquals("Exactly one user should be persisted", 1, userList.size());
	}

}
