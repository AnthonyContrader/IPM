package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.EnvironmentDTO;
import it.contrader.model.Environment;

public class EnvironmentConverter {
	
	public EnvironmentDTO toDTO (Environment environment) {
		return new EnvironmentDTO (environment.getId_env(), environment.getName(), environment.getDescription());
	}
	
	public Environment toEntity (EnvironmentDTO environmentDTO) {
		return new Environment (environmentDTO.getId_env(), environmentDTO.getName(), environmentDTO.getDescription());	
	}
	
	public List <EnvironmentDTO> toDTOList (List<Environment> environmentsList) {
		List <EnvironmentDTO> environmentDTOList = new ArrayList <EnvironmentDTO>();
		for (Environment environment : environmentsList) {
			environmentDTOList.add (toDTO(environment));
		}
		return environmentDTOList;
	}
}