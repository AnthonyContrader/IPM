package it.contrader.controller;


import java.util.List;

import it.contrader.dto.OsTypeDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.OsTypeService;

public class OsTypeController implements Controller {
	private static String sub_pack = "osType.";
	private OsTypeService osTypeService;
	
	public OsTypeController () { this.osTypeService=new OsTypeService();}
	
	@Override
	public void doControl (Request request) {
		String mode =(String) request.get("mode");
		String choice = (String) request.get("choice");
		int id;
		String name;
		String command;
		
		switch (mode) {
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			OsTypeDTO osTypeDTO = osTypeService.read(id);
			request.put("osType", osTypeDTO);
			MainDispatcher.getInstance().callView(sub_pack + "OsTypeRead", request);
			break;
			
		case "INSERT":
			name=request.get("name").toString();
			command=request.get("command").toString();
			
			OsTypeDTO ostypetoinsert = new OsTypeDTO(name, command);
			osTypeService.insert(ostypetoinsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_pack+"OsTypeInsert", request);
			break;
			
		case "DELETE":
			id=Integer.parseInt(request.get("id").toString());
			osTypeService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_pack+"OsTypeDelete", request);
			break;
			
		case "UPDATE":
			id=Integer.parseInt(request.get("id").toString());
			name=request.get("name").toString();
			command=request.get("command").toString();
			OsTypeDTO ostypetoupdate = new OsTypeDTO();
			ostypetoupdate.setId_ostype(id);
			osTypeService.update(ostypetoupdate);
			request=new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_pack + "OsTypeUpdate", request);
			break;
			
		case "OSTYPELIST":
			List<OsTypeDTO> osTypeDTOList = osTypeService.getAll();
			request.put("osTypes", osTypeDTOList);
			MainDispatcher.getInstance().callView("OsType", request);
			break;

		case "GETCHOICE":
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_pack + "OsTypeRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_pack + "OsTypeInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_pack + "OsTypeUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_pack + "OsTypeDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}


		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
