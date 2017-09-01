package edu.msg.ro.business;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.dto.UserDTO;
import edu.msg.ro.business.ejbs.UserEjb;

public class UserTest extends AbstractIntegrationTest {

	@EJB
	private UserEjb sut;

	@Test
	public void testUserEjb_loadUserByLastname() {
		UserDTO user = sut.getUserByLastname("Mustermann");

		Assert.assertEquals("Mustermann", user.getLastname());
		Assert.assertEquals("Max", user.getFirstname());
	}

}
