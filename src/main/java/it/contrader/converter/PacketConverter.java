package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PacketDTO;
import it.contrader.model.Packet;


public class PacketConverter {
	public PacketDTO toDTO(Packet packet) {
		return new PacketDTO(
						packet.getId_pack(),
						packet.getName(),
						packet.getDescription() );
	}
	
	public Packet toEntity(PacketDTO packetDTO) {
		return new Packet(
				packetDTO.getId_pack(),
				packetDTO.getName(),
				packetDTO.getDescription() );
	}
	
}