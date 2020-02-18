package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.OsTypeDTO;
import it.contrader.model.OsType;

@Component
public class OsTypeConverter extends AbstractConverter<OsType, OsTypeDTO>{

	@Override
	public OsType toEntity(OsTypeDTO dto) {
		OsType osType = null;
		if (dto != null) {
			osType = new OsType(dto.getId(), dto.getOsType(), dto.getCommand());
		}
	return osType;
	}


	@Override
	public OsTypeDTO toDTO(OsType entity) {
		OsTypeDTO osTypeDTO = null;
		if (entity != null) {
			osTypeDTO = new OsTypeDTO(entity.getId(), entity.getOsType(), entity.getCommand());
		}
		return osTypeDTO;
	}

}
