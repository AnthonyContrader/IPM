package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PacketDTO;
import it.contrader.model.Packet;


public class PacketConverter {
	
	// Converts a simple packet to a PacketDTO
	// @param: the normal packet
	// @return: the converted packet (packetDTO)
	public PacketDTO toDTO(Packet packet) {
		return new PacketDTO(
						packet.getId_pack(),
						packet.getName(),
						packet.getDescription() );
	}
	
	// Converts a PacketDTO to a packet
	// @param: the Packet data transfer object
	// @return: the converted packet
	public Packet toEntity(PacketDTO packetDTO) {
		return new Packet(
				packetDTO.getId_pack(),
				packetDTO.getName(),
				packetDTO.getDescription() );
	}
	
	
	// Converts a packet list to a DTO packet list
	// @param: the packet list to be converted
	// @return: the converted packet list
	public List<PacketDTO> toDTOList(List<Packet> packetsList) {
		List<PacketDTO> packetDTOList = new ArrayList<PacketDTO>();
		
		for (Packet packet : packetsList) {
			packetDTOList.add( toDTO(packet) );
		}
		
		return packetDTOList;
	}
}