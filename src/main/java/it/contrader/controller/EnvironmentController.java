package it.contrader.controller;

import java.util.List;
import it.contrader.dto.EnvironmentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.EnvironmentService;

public class EnvironmentController implements Controller {
	private static String sub_package = "environment.";
	private EnvironmentService environmentService;
	
	public EnvironmentController() {
		this.environmentService = new EnvironmentService();
	}
	
	@Override
	public void doControl (Request request) {
		String mode = (String) request.get ("mode");
		String choice = (String) request.get ("choice");
		int id_env;
		String name;
		String description;
		switch (mode) {
		case "READ":
			id_env = Integer.parseInt(request.get("id_env").toString());
			EnvironmentDTO environmentDTO = environmentService.read(id_env);
			request.put("environment", environmentDTO);
			MainDispatcher.getInstance().callView(sub_package + "EnvironmentRead", request);
			break;
		case "INSERT":
			name = request.get("name").toString();
			description = request.get("description").toString();
			EnvironmentDTO envtoinsert = new EnvironmentDTO (name, description);
			environmentService.insert(envtoinsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "EnvironmentInsert", request);
			break;
		case "DELETE":
			id_env = Integer.parseInt(request.get("id_env").toString());
			environmentService.delete(id_env);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "EnvironmentDelete", request);
			break;
		case "UPDATE":
			id_env = Integer.parseInt(request.get("id_env").toString());
			name = request.get("name").toString();
			description = request.get("description").toString();
			EnvironmentDTO envtoupdate = new EnvironmentDTO(name, description);
			envtoupdate.setId_env(id_env);
			environmentService.update(envtoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "EnvironmentUpdate", request);
			break;
		case "ENVIRONMENTLIST":
			List<EnvironmentDTO> environmentsDTO = environmentService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("environments", environmentsDTO);
			MainDispatcher.getInstance().callView("Environment", request);
			break;
		case "GETCHOICE":		
		//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
				case "L":
					MainDispatcher.getInstance().callView(sub_package + "EnvironmentRead", null);
					break;		
				case "I":
					MainDispatcher.getInstance().callView(sub_package + "EnvironmentInsert", null);
					break;		
				case "M":
					MainDispatcher.getInstance().callView(sub_package + "EnvironmentUpdate", null);
					break;		
				case "C":
					MainDispatcher.getInstance().callView(sub_package + "EnvironmentDelete", null);
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
	