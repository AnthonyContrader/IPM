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
	
	// Converts a packet to DTO and reads it
	// @param: the packet id to be modified
	// @return: the converted packet
	public PacketDTO read(int packetIdToModify) {
		return this.packetConverter.toDTO( this.packetDAO.read( packetIdToModify ) );
	}
	
	// Inserts a packet
	// @param: packet to insert
	// @return: true if inserted, false otherwise
	public boolean insert(PacketDTO pDto) {
		return this.packetDAO.insert( this.packetConverter.toEntity(pDto) );
	}
	
	// Updates a packet
	// @param: packet to update
	// @return: true if updated, false otherwise
	public boolean update(PacketDTO pDto) {
		return this.packetDAO.update( this.packetConverter.toEntity(pDto) );
	}
	
	// Deletes a packet
	// @param: packet id to delete
	// @return: true if packet was deleted, false otherwise
	public boolean delete(int packetIdToDelete) {
		return this.packetDAO.delete( packetIdToDelete );
	}
	
	public PacketDTO search(String packetToFindName) {
		return this.packetConverter.toDTO( packetDAO.search( packetToFindName ) );
	}
}