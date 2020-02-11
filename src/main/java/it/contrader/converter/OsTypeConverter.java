package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.OsTypeDTO;
import it.contrader.model.OsType;

public class OsTypeConverter implements Converter<OsType, OsTypeDTO> {

	@Override
	public OsTypeDTO toDTO(OsType osType) {
		OsTypeDTO osTypeDTO = new OsTypeDTO(osType.getId(), 
				osType.getName(), osType.getCommand());
		return osTypeDTO;
	}

	@Override
	public OsType toEntity(OsTypeDTO osTypeDTO) {
		OsType osType = new OsType(osTypeDTO.getId(), 
				osTypeDTO.getName(), osTypeDTO.getCommand());
		return osType;
	}

	@Override
	public List<OsTypeDTO> toDTOList(List<OsType> osTypeList) {
		List<OsTypeDTO> osTypeDTOList = new ArrayList<OsTypeDTO>();
		for (OsType osType : osTypeList) {
			osTypeDTOList.add(toDTO(osType));
		}
		return osTypeDTOList;
	}

}
