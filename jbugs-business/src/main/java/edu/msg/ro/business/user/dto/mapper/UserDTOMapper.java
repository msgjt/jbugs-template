package edu.msg.ro.business.user.dto.mapper;

import javax.ejb.Stateless;

import edu.msg.ro.business.user.dto.UserDTO;
import entities.User;

@Stateless
public class UserDTOMapper {

	public UserDTO mapToDTO(User userEntity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setFirstName(userEntity.getFirstName());
		userDTO.setLastName(userEntity.getLastName());

		return userDTO;
	}

	public User mapToEntity(UserDTO userDTO, User userEntity) {
		userEntity.setFirstName(userDTO.getFirstName());
		userEntity.setLastName(userEntity.getLastName());

		return userEntity;
	}

}
