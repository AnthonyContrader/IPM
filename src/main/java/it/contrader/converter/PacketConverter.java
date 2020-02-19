package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.PacketDTO;
import it.contrader.model.Packet;

@Component
public class PacketConverter extends AbstractConverter<Packet, PacketDTO>{

	@Override
	public Packet toEntity(PacketDTO dto) {
		if (dto == null)
			return null;
		
		return new Packet (
			dto.getId(),
			dto.getName(),
			dto.getDescription(),
			dto.getPacketostype()
			);
	}

	@Override
	public PacketDTO toDTO(Packet entity) {
		if (entity == null)
			return null;
		
		return new PacketDTO (
				entity.getId(),
				entity.getName(),
				entity.getDescription(),
				entity.getPacketostype()
				);
	}

}
