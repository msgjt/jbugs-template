package edu.msg.ro.business.user.dto.mapper;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.User;

public class UserDTOMapperTest extends AbstractIntegrationTest {

	@Inject
	UserDTOMapper sut;

	@Test
	public void mapToDTO_validEntity() {
		// arrange
		User entity = new User();
		entity.setEmail("test@msg.com");
		entity.setFirstname("Ale");
		entity.setLastname("Mihai");
		entity.setPassword("msg");
		entity.setLockVersion(1L);
		entity.setPhoneNumber("54545");
		entity.setUsername("msg");
		entity.setActive(true);

		// act

		UserDTO userDTO = sut.mapToDTO(entity);

		// assert

		Assert.assertEquals("Email mapping failed", entity.getEmail(), userDTO.getEmail());

	}

	@Test
	public void mapToDTO_NullEntity() {
		UserDTO userDTO = sut.mapToDTO(null);
		Assert.assertNull("Return value of an NULL input should be also NULL", userDTO);
	}

}
