package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.PacketConverter;
import it.contrader.dao.PacketRepository;
import it.contrader.dto.PacketDTO;
import it.contrader.model.Packet;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class PacketService extends AbstractService<Packet, PacketDTO>{
	
	@Autowired
	private PacketConverter packetConverter;
	
	@Autowired
	private PacketRepository packetRepository;
	
	public PacketDTO findByName(String name) {
		return packetConverter.toDTO( packetRepository.findByName(name) );
	}
}
