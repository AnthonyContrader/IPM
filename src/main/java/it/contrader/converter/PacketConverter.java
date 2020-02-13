package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PacketDTO;
import it.contrader.model.Packet;

public class PacketConverter implements Converter<Packet, PacketDTO> {
	
	public PacketDTO toDTO(Packet packet) {
		return new PacketDTO(
					packet.getId_pack(),
					packet.getName(),
					packet.getDescription(),
					packet.getOsKey()
					);
	}
	
	public Packet toEntity(PacketDTO packetDTO) {
		return new Packet (
				packetDTO.getId_pack(),
				packetDTO.getName(),
				packetDTO.getDescription(),
				packetDTO.getOsKey()
				);
	}
	
	public List<PacketDTO> toDTOList(List<Packet> packetList) {
		List<PacketDTO> packetDTOList = new ArrayList<PacketDTO>();
		
		for (Packet packet : packetList)
			packetDTOList.add( this.toDTO( packet ) );
		
		return packetDTOList;
	}
}
