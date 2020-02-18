package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.OsTypeDTO;
import it.contrader.service.OsTypeService;

@Controller
@RequestMapping("/ostype")
public class OsTypeController {
	
	@Autowired
	private OsTypeService service;
	
	@GetMapping("/getall")
	public String getAll (HttpServletRequest request) {
		setAll(request);
		return "ostypes";
	}
	
	public void setAll (HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
	
	@PostMapping("/insert")
	public String insert (HttpServletRequest request, @RequestParam("osType") String osType,
			@RequestParam("command") String command) {
		OsTypeDTO dto = new OsTypeDTO();
		dto.setOsType(osType);
		dto.setCommand(command);

		service.insert(dto);
		
		setAll(request);
		return "ostypes";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readostype";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "ostypes";
	}
	
	@GetMapping ("/preupdate")
		public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
			request.getSession().setAttribute("dto", service.read(id));
			return "updateostype";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("ostype") String osType,
			@RequestParam("command") String command) {
		OsTypeDTO dto = new OsTypeDTO();
		dto.setId(id);
		dto.setOsType(osType);
		dto.setCommand(command);
		
		service.update(dto);
		setAll(request);
		return "ostypes";
	}
	
}
