package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Packet;

public interface PacketRepository extends CrudRepository<Packet, Long> {
	
	Packet findByName(String name);
	
}
