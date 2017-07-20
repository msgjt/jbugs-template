package edu.msg.ro.business.user.service;

import java.util.List;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.service.UserService;

public class UserServiceTest extends AbstractIntegrationTest {

	@EJB
	private UserService sut;

	@Test
	public void testSaveNewUser() {
		String LASTNAME = "ILIE";

		List<UserDTO> userList = sut.getUserByLastName(LASTNAME);

		Assert.assertEquals("No user should exist!", 0, userList.size());

		sut.saveNewUser("John", LASTNAME);

		userList = sut.getUserByLastName(LASTNAME);

		Assert.assertEquals("Exactly one user should be persisted", 1, userList.size());
	}

}
