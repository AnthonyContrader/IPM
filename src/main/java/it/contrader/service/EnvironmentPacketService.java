package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.EnvironmentPacketConverter;
import it.contrader.dao.EnvironmentPacketRepository;
import it.contrader.dto.EnvironmentPacketDTO;
import it.contrader.model.Environment;
import it.contrader.model.EnvironmentPacket;
import it.contrader.model.Packet;

// Annotation che indica che si sta implementando un Service
@Service
public class EnvironmentPacketService extends AbstractService<EnvironmentPacket, EnvironmentPacketDTO>{
	
	@Autowired
	private EnvironmentPacketConverter converter;
	
	@Autowired
	private EnvironmentPacketRepository repository;
	
	public EnvironmentPacketDTO findByEnvironmentAndPacket (Environment environment, Packet packet) {
		return converter.toDTO(repository.findByEnvironmentAndPacket(environment, packet));
	}
}