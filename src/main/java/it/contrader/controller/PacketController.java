package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.PacketDTO;
import it.contrader.model.OsType;
import it.contrader.service.OsTypeService;
import it.contrader.service.PacketService;

@Controller
@RequestMapping("/packet")
public class PacketController {
	
	@Autowired
	private PacketService service;
	
	@Autowired
	private OsTypeService serviceos;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "packets";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute( "list", service.getAll() );
		request.getSession().setAttribute( "listos", serviceos.getAll());
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("packetOstype") OsType ost) {
		PacketDTO dto = new PacketDTO();
		dto.setName(name);
		dto.setDescription(description);
		dto.setPacketostype(ost);
		
		service.insert( dto );
		
		setAll(request);
		return "packets";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readpacket";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "packets";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		request.getSession().setAttribute("listos", serviceos.getAll());
		return "updatepacket";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("packetOstype") OsType ost) {

		PacketDTO dto = new PacketDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setDescription(description);
		dto.setPacketostype(ost);
		
		service.update(dto);
		
		setAll(request);
		return "packets";
	}
	
	@GetMapping("/find")
	public String find(HttpServletRequest request, @RequestParam("nameFind") String nameFind) {
		PacketDTO dto = service.findByName(nameFind);
		
		request.getSession().setAttribute("dto", service.read( dto.getId() ) );
		return "readpacket";
	}
}
