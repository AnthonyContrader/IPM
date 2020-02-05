package it.contrader.service;

import java.util.List;

import it.contrader.converter.PacketConverter;
import it.contrader.dao.PacketDAO;
import it.contrader.dto.PacketDTO;

public class PacketService {
	
	private PacketDAO packetDAO;
	private PacketConverter packetConverter;
	
	// Default constructor
	public PacketService() {
		this.packetDAO = new PacketDAO();
		this.packetConverter = new PacketConverter();
	}
	
	// Asks the DAO access the DB and converts them to DTO
	// @param: /
	// @return: A DTO List of packets
	public List<PacketDTO> getAll() {
		return this.packetConverter.toDTOList( this.packetDAO.getAll() );
	}
	
	// Converts a packet to DTO
	// @param: the packet id to be modified
	// @return: the converted packet
	public PacketDTO read(int packetIdToModify) {
		return this.packetConverter.toDTO( this.packetDAO.read( packetIdToModify ) );
	}
	
	
}