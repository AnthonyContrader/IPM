package it.contrader.dto;

import lombok.Data;
// import it.contrader.model.Category;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import it.contrader.model.Packet;

// Permette la creazione automatica dei principali metodi di un Model (o di un DTO)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnvironmentDTO {
	
	private Long id;
	private String name;
	private String description;	
	private Packet environmentpacket;
	// private Category category;
}