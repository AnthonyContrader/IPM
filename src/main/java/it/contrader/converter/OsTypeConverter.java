package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.OsTypeDTO;
import it.contrader.model.OsType;

public class OsTypeConverter {

	public OsTypeDTO toDTO (OsType osType) {
		OsTypeDTO osTypeDTO = new OsTypeDTO(osType.getId(), osType.getName(), osType.getCommand());
		return osTypeDTO;
	}
	
	public OsType toEntity (OsTypeDTO osTypeDTO) {
		OsType osType = new OsType(osTypeDTO.getId_ostype(), osTypeDTO.getName(), osTypeDTO.getCommand());
		return osType;
	}
	
	public List <OsTypeDTO> toDTOList (List<OsType> osTypeList){
		List <OsTypeDTO> osTypeDTO = new ArrayList<>();
		for (OsType osType : osTypeList) {
			osTypeDTO.add(toDTO(osType));
		}
		return osTypeDTO;
	}
}
