package it.contrader.service;

import it.contrader.converter.PacketConverter;
import it.contrader.dao.PacketDAO;
import it.contrader.dto.PacketDTO;
import it.contrader.model.Packet;

public class PacketService extends AbstractService<Packet, PacketDTO> {
	private PacketDAO p;
	
	public PacketService() {
		this.dao = new PacketDAO();
		this.converter = new PacketConverter();
		this.p = new PacketDAO();
	}
	
	public PacketDTO findByName(String packetToFind) {
		return this.converter.toDTO( this.p.findByName(packetToFind) );
	}
	
}
