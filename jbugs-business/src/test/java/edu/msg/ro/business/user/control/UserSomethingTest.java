package edu.msg.ro.business.user.control;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dto.UserDTO;

public class UserSomethingTest extends AbstractIntegrationTest {

	@EJB
	private UserSomething sut;

	@Test
	public void createUser_EmailValidationFail() throws BusinessException {
		UserDTO testUser = new UserDTO();
		testUser.setFirstname("John");
		testUser.setLastname("Doe");
		testUser.setEmail("unique@mail.com");

		UserDTO createdUser = sut.createUser(testUser);

		UserDTO testUser2 = new UserDTO();
		testUser2.setFirstname("Mary");
		testUser2.setLastname("Jane");
		testUser2.setEmail("unique@mail.com");

		try {
			UserDTO createdUser2 = sut.createUser(testUser2);
		} catch (BusinessException e) {
			Assert.assertEquals("User already exists with given email unique@mail.com", e.getMessage());
			return;
		}
		Assert.fail("Email validation should fail!");
	}

}
