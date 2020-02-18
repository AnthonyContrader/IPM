package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.EnvironmentDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User.Usertype;
import it.contrader.service.EnvironmentService;

// Annotation che indica che il seguente è un Controller
@Controller

// Va inserito all'interno del Controller per mappare le operazioni
@RequestMapping ("/environment")
public class EnvironmentController {
	
	// Permette di iniettare le istanze all’interno di una classe, sostituisce il costruttore, creando le dipendenze. 
	@Autowired
	private EnvironmentService service;
	
	private void setAll (HttpServletRequest request) {
		request.getSession().setAttribute("list",  service.getAll());
	}
	
	// Indica il metodo HTTP che viene applicato per quella richiesta
	@GetMapping ("/delete")
	public String delete (HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "environments";
	}
	
	@GetMapping ("/getall")
	public String getAll (HttpServletRequest request) {
		setAll(request);
		return "environments";
	}
	
	@GetMapping ("/preupdate")
	public String preUpdate (HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute ("dto", service.read(id));
		return "updateenvironment";		
	}
	
	@GetMapping ("/read")
	public String read (HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "environments";
	}
	
	// Altra annotation che permette di indicare che viene applicato il metodo HTTP POST
	@PostMapping ("/update")
	public String update (HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("description") String description) {
		EnvironmentDTO dto = new EnvironmentDTO();
		dto.setId(id);
		dto.setName(name);;
		dto.setDescription(description);
		service.update(dto);
		setAll(request);
		return "environments";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name,
			@RequestParam("description") String description) {
		EnvironmentDTO dto = new EnvironmentDTO();
		dto.setName(name);
		dto.setDescription(description);
		service.insert(dto);
		setAll(request);
		return "environments";
	}
}