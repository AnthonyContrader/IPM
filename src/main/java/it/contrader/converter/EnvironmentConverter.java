package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.EnvironmentDTO;
import it.contrader.model.Environment;

public class EnvironmentConverter implements Converter<Environment, EnvironmentDTO> {
	
	public EnvironmentDTO toDTO(Environment environment) {
		return new EnvironmentDTO(
				environment.getId_env(),
				environment.getName(),
				environment.getDescription(),
				environment.getPacketKey(),
				environment.getCategoryKey()
					);
	}
	
	public Environment toEntity(EnvironmentDTO environmentDTO) {
		return new Environment (
				environmentDTO.getId_env(),
				environmentDTO.getName(),
				environmentDTO.getDescription(),
				environmentDTO.getPacketKey(),
				environmentDTO.getCategoryKey()				
				);
	}
	
	public List<EnvironmentDTO> toDTOList(List<Environment> environmentList) {
		List<EnvironmentDTO> environmentDTOList = new ArrayList<EnvironmentDTO>();
		for (Environment environment : environmentList)
			environmentDTOList.add( this.toDTO( environment ) );
		return environmentDTOList;
	}
}
