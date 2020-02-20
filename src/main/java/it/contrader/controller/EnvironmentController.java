package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.EnvironmentDTO;
import it.contrader.dto.PacketDTO;
import it.contrader.service.EnvironmentService;
import it.contrader.service.PacketService;
import it.contrader.model.Packet;
//import it.contrader.service.CategoryService;


// Annotation che indica che il seguente è un Controller
@Controller

// Va inserito all'interno del Controller per mappare le operazioni
@RequestMapping ("/environment")
public class EnvironmentController {
	
	// Permette di iniettare le istanze all’interno di una classe, sostituisce il costruttore, creando le dipendenze. 
	@Autowired
	private EnvironmentService service;
	
	@Autowired
	private PacketService servicep;
	
	private void setAll (HttpServletRequest request) {
		request.getSession().setAttribute("list",  service.getAll());
		request.getSession().setAttribute("listp",  servicep.getAll());
		//request.getSession().setAttribute("listc",  servicec.getAll());

	}
	
	@GetMapping ("/getall")
	public String getAll (HttpServletRequest request) {
		setAll(request);
		return "environments";
	}
	
	// Indica il metodo HTTP che viene applicato per quella richiesta
	@GetMapping ("/delete")
	public String delete (HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "environments";
	}
	
	@GetMapping ("/preupdate")
	public String preUpdate (HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute ("dto", service.read(id));
		request.getSession().setAttribute("listp", servicep.getAll());
		return "updateenvironment";		
	}
	
	@GetMapping ("/read")
	public String read (HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readenvironment";
	}
	
	// Altra annotation che permette di indicare che viene applicato il metodo HTTP POST
	@PostMapping ("/update")
	public String update (HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("environmentPacket") Packet environmentpacket) {
		EnvironmentDTO dto = new EnvironmentDTO();
		dto.setId(id);
		dto.setName(name);;
		dto.setDescription(description);
		dto.setEnvironmentpacket(environmentpacket);
		service.update(dto);
		setAll(request);
		return "environments";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("environmentPacket") Packet environmentpacket) {
		EnvironmentDTO dto = new EnvironmentDTO();
		dto.setName(name);
		dto.setDescription(description);
		dto.setEnvironmentpacket(environmentpacket);
		service.insert(dto);
		setAll(request);
		return "environments";
	}
}