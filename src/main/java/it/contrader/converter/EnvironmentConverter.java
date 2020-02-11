package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.EnvironmentDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Environment;
import it.contrader.model.User;

public class EnvironmentConverter implements Converter<Environment, EnvironmentDTO>{
	
	public EnvironmentDTO toDTO (Environment environment) {
		return new EnvironmentDTO (environment.getId_env(), environment.getName(), environment.getDescription());
	}
	
	public Environment toEntity (EnvironmentDTO environmentDTO) {
		return new Environment (environmentDTO.getId(), environmentDTO.getName(), environmentDTO.getDescription());		
	}
	
	public List <EnvironmentDTO> toDTOList (List<Environment> environmentList){
		List <EnvironmentDTO> environmentDTOList = new ArrayList <EnvironmentDTO>();
		for (Environment environment : environmentList) {
			environmentDTOList.add (toDTO(environment));
		}
		return environmentDTOList;
	}
	
}