package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PacketDTO;
import it.contrader.model.Packet;

public class PacketConverter implements Converter<Packet, PacketDTO> {
	
	public PacketDTO toDTO(Packet packetToConvert) {
		return new PacketDTO(
					packetToConvert.getId_pack(),
					packetToConvert.getName(),
					packetToConvert.getDescription()
					);
	}
	
	public Packet toEntity(PacketDTO packetToConvert) {
		return new Packet (
				packetToConvert.getId_pack(),
				packetToConvert.getName(),
				packetToConvert.getDescription()
				);
	}
	
	public List<PacketDTO> toDTOList(List<Packet> packetList) {
		List<PacketDTO> packetDTOList = new ArrayList<PacketDTO>();
		
		for (Packet packet : packetList)
			packetDTOList.add( this.toDTO( packet ) );
		
		return packetDTOList;
	}
}
