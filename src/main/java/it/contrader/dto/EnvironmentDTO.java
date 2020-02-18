package it.contrader.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// Permette la creazione automatica dei principali metodi di un Model (o di un DTO)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnvironmentDTO {
	
	private Long id;
	private String name;
	private String description;	
}