package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.dto.EnvironmentDTO;
import it.contrader.model.Environment;

// Permette di definire una classe generica (Abstract, Interface, ecc.)
@Component
public class EnvironmentConverter extends AbstractConverter<Environment, EnvironmentDTO>{
	
	@Override
	public Environment toEntity (EnvironmentDTO environmentDTO) {
		Environment environment = null;
		if (environmentDTO != null) {
			environment = new Environment (environmentDTO.getId(), environmentDTO.getName(), environmentDTO.getDescription());
		}
		return environment;
	}
	
	@Override
	public EnvironmentDTO toDTO (Environment environment) {
		EnvironmentDTO environmentDTO = null;
		if (environment != null) {
			environmentDTO = new EnvironmentDTO (environment.getId(), environment.getName(), environment.getDescription());
		}
		return environmentDTO;
	}
}
