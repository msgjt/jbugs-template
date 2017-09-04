package edu.msg.ro.business.user.boundary;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dto.UserDTO;

public class UserFacadeTest extends AbstractIntegrationTest {

	@EJB
	private UserFacade sut;

	@Test
	public void createUser_succesfull() throws BusinessException {
		UserDTO testUser = new UserDTO();
		testUser.setFirstname("John");
		testUser.setLastname("Doe");

		UserDTO createdUser = sut.createUser(testUser);

		Assert.assertNotNull("The newly persisted user should have an id!", createdUser.getId());
	}

	@Test
	public void createUser_ActiveByDefault() throws BusinessException {
		UserDTO testUser = new UserDTO();

		UserDTO createdUser = sut.createUser(testUser);

		Assert.assertTrue("The newly persisted user should be active!", createdUser.isActive());
	}

}
