package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Packet;

@Repository
@Transactional
public interface PacketRepository extends CrudRepository<Packet, Long> {
	
	Packet findByName(String name);
	
}
