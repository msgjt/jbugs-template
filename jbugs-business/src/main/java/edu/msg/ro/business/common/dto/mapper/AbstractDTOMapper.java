package edu.msg.ro.business.common.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import edu.msg.ro.business.common.dto.AbstractDTO;
import edu.msg.ro.persistence.user.entity.AbstractEntity;

public abstract class AbstractDTOMapper<E extends AbstractEntity, DTO extends AbstractDTO> {

	public abstract DTO getDTOInstance();

	public DTO mapToDTO(E entity) {
		if (entity == null) {
			return null;
		} else {
			DTO dto = getDTOInstance();

			dto.setId(entity.getId());
			dto.setLockVersion(entity.getLockVersion());

			mapEntityToDTOFields(entity, dto);

			return dto;
		}

	}

	public void mapToEntity(DTO dto, E entity) {
		entity.setLockVersion(dto.getLockVersion());

		mapDTOToEntityFields(dto, entity);
	}

	public List<DTO> mapToDTOs(List<E> entities) {
		// TODO refactor with Java8 map()

		List<DTO> dtos = new ArrayList<>();
		for (E entity : entities) {
			dtos.add(mapToDTO(entity));
		}

		return dtos;
	}

	// TODO implement mapToEntites()

	protected abstract void mapEntityToDTOFields(E entity, DTO dto);

	protected abstract void mapDTOToEntityFields(DTO dto, E entity);

}
