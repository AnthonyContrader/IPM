package it.contrader.servlets;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.PacketDTO;
import it.contrader.service.Service;
import it.contrader.service.PacketService;
import it.contrader.dto.CategoryDTO;
import it.contrader.service.CategoryService;
import it.contrader.dto.EnvironmentDTO;
import it.contrader.dto.OsTypeDTO;
import it.contrader.service.EnvironmentService;
import it.contrader.service.OsTypeService;;


public class EnvironmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public EnvironmentServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<PacketDTO> service = new PacketService();
		List<PacketDTO> packetListDTO = service.getAll();
		
		Service<EnvironmentDTO> serviceos = new EnvironmentService();
		List<EnvironmentDTO> serviceListDTO = serviceos.getAll();
		
		Service<CategoryDTO> servicec = new CategoryService();
		List<CategoryDTO> categoryListDTO = servicec.getAll();
		
		request.setAttribute("list", packetListDTO);
		request.setAttribute("listos", serviceListDTO);
		request.setAttribute("listc", categoryListDTO);

	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<EnvironmentDTO> service = new EnvironmentService();
		String mode = request.getParameter("mode");
		EnvironmentDTO dto;
		int id_env;
		boolean answer;
		
		switch ( mode.toUpperCase() ) {
		
		case "ENVIRONMENTLIST":
			this.updateList( request );
			this.getServletContext().getRequestDispatcher("/environment/environmentmanager.jsp").forward( request, response );
			
			break;
			
		case "READ":
			id_env = Integer.parseInt( request.getParameter("id") );
			
			dto = service.read(id_env);
			
			Service<PacketDTO> servicep = new PacketService();
			Service<CategoryDTO> servicec = new CategoryService();

			List<CategoryDTO> servicecListDTO = servicec.getAll();
			List<PacketDTO> servicepListDTO = servicep.getAll();
			
			request.setAttribute("dto", dto);
			request.setAttribute("listp", servicepListDTO);
			request.setAttribute("listc", servicecListDTO);
			
			if ( request.getParameter("update") == null )
				this.getServletContext().getRequestDispatcher("/environment/readenvironment.jsp").forward( request, response );
			else
				this.getServletContext().getRequestDispatcher("/environment/updateenvironment.jsp").forward( request, response );
			
			break;
			
		case "INSERT":
			String name = request.getParameter("environmentName").toString();
			String description = request.getParameter("environmentDescription").toString();
			String packet = request.getParameter("environmentPacket").toString() ;
			String category = request.getParameter("environmentCategory").toString() ;
			
			dto = new EnvironmentDTO (name, description, packet, category);
			answer = service.insert(dto);
			
			request.setAttribute("ans", answer);
			updateList(request);
			getServletContext().getRequestDispatcher("/environment/environmentmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			dto = new EnvironmentDTO (
					Integer.parseInt( request.getParameter("id") ),
					request.getParameter("environmentName"),
					request.getParameter("environmentDescription"),
					request.getParameter("environmentPacket"),
					request.getParameter("environmentCategory")
					);
			
			answer = service.update( dto );
			
			updateList(request);
			getServletContext().getRequestDispatcher("/environment/environmentmanager.jsp").forward(request, response);
			
			break;
		
		case "DELETE":
			id_env = Integer.parseInt( request.getParameter("id") );
			answer = service.delete( id_env );
			request.setAttribute("ans", answer);
			
			updateList(request);
			getServletContext().getRequestDispatcher("/environment/environmentmanager.jsp").forward(request, response);
			
			break;
		}	
	}
}
