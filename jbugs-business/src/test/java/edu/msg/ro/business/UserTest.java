package edu.msg.ro.business;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.persistence.user.entity.User;

public class UserTest extends AbstractIntegrationTest {

	@EJB
	private SomeEjb someEjb;

	@Test
	public void testUserCreation() {
		User createUser = someEjb.createUser();

		User loadUser = someEjb.loadUser(createUser.getId());

		Assert.assertTrue(true);
	}
}
