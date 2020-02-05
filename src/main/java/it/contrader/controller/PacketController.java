package it.contrader.controller;

import java.util.List;

import it.contrader.dto.PacketDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.PacketService;

public class PacketController implements Controller {
	private static String sub_package = "packet.";
	
	private PacketService packetService;
	
	public PacketController() {
		this.packetService = new PacketService();
	}
	
	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		int id;
		String name;
		String description;
		
		switch (mode) {
		
		case "READ":
			id = Integer.parseInt( request.get("id").toString() );
			PacketDTO packetDTO = this.packetService.read(id);
			request.put("packet", packetDTO);
			MainDispatcher.getInstance().callView(sub_package + "PacketRead", request);
			break;
			
		case "INSERT":
			name = request.get("name").toString();
			description = request.get("description").toString();
			
			PacketDTO packetToInsert = new PacketDTO(name, description);
			packetService.insert(packetToInsert);
			
			request = new Request();
			request.put("mode", "mode");
			
			MainDispatcher.getInstance().callView(sub_package + "PacketInsert", request);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			
			this.packetService.delete(id);
			
			request = new Request();
			
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PacketDelete", request);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			description = request.get("description").toString();

			PacketDTO packetToUpdate = new PacketDTO(name, description);
			packetToUpdate.setId_pack( id );
			packetService.update( packetToUpdate );
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PacketUpdate", request);
			break;
		}
	}
}