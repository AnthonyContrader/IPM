package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.dto.EnvironmentPacketDTO;
import it.contrader.model.EnvironmentPacket;

// Permette di definire una classe generica (Abstract, Interface, ecc.)
@Component
public class EnvironmentPacketConverter extends AbstractConverter<EnvironmentPacket, EnvironmentPacketDTO>{
	
	@Override
	public EnvironmentPacket toEntity (EnvironmentPacketDTO environmentDTO) {
		EnvironmentPacket environment = null;
		if (environmentDTO != null) {
			environment = new EnvironmentPacket (environmentDTO.getId(), environmentDTO.getEnvironment(), environmentDTO.getPacket());
		}
		return environment;
	}
	
	@Override
	public EnvironmentPacketDTO toDTO (EnvironmentPacket environment) {
		EnvironmentPacketDTO environmentDTO = null;
		if (environment != null) {
			environmentDTO = new EnvironmentPacketDTO (environment.getId(), environment.getPacket(), environment.getEnvironment());
		}
		return environmentDTO;
	}
}
