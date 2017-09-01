package edu.msg.ro.business.dto.mapper;

import edu.msg.ro.business.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.User;

public class UserDTOMapper {

	public UserDTO mapToDTO(User userEntity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setLastname(userEntity.getLastname());
		userDTO.setFirstname(userEntity.getFirstname());

		return userDTO;
	}

	public void mapToEntity(UserDTO userDTO, User userEntity) {
		// TODO maybe
		// if userDTO.id == null, then persist
		// else load entity and update

		userEntity.setId(userDTO.getId());
		userEntity.setFirstname(userDTO.getFirstname());
		userEntity.setLastname(userDTO.getLastname());
	}

}
