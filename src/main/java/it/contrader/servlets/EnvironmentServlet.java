package it.contrader.servlets;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.EnvironmentDTO;
import it.contrader.service.Service;
import it.contrader.service.EnvironmentService;


public class EnvironmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EnvironmentServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<EnvironmentDTO> service = new EnvironmentService();
		List<EnvironmentDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<EnvironmentDTO> service = new EnvironmentService();
		String mode = request.getParameter("mode");
		EnvironmentDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "ENVIRONMENTLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/environment/environmentmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/environment/readenvironment.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/environment/updateenvironment.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			String description = request.getParameter("description").toString();
			dto = new EnvironmentDTO (name, description);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/environment/environmentmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			name = request.getParameter("name");
			description = request.getParameter("description");
			dto = new EnvironmentDTO (id, name, description);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/environment/environmentmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/environment/environmentmanager.jsp").forward(request, response);	
			break;
		}
	}
}