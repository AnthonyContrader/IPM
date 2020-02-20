package it.contrader.dto;

import lombok.Data;
import it.contrader.model.Packet;
import it.contrader.model.Environment;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// Permette la creazione automatica dei principali metodi di un Model (o di un DTO)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnvironmentPacketDTO {
	
	private Long id;
	private Packet packet;
	private Environment environment;
}