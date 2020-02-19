package it.contrader.dto;

import it.contrader.model.OsType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacketDTO {
	private Long id;
	
	private String name;
	
	private String description;
	
	private OsType packetostype;
}
