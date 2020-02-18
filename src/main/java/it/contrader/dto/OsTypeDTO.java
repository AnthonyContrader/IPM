package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OsTypeDTO {

	private Long id;
	
	private String osType;
	
	private String command;
	
}
