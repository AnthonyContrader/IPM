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

public class PacketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public PacketServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<PacketDTO> service = new PacketService();
		List<PacketDTO> packetListDTO = service.getAll();
		
		request.setAttribute("list", packetListDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<PacketDTO> service = new PacketService();
		String mode = request.getParameter("mode");
		PacketDTO dto;
		int id_pack;
		boolean answer;
		
		switch ( mode.toUpperCase() ) {
		
		case "PACKETLIST":
			this.updateList( request );
			this.getServletContext().getRequestDispatcher("/packet/packetmanager.jsp").forward( request, response );
			
			break;
			
		case "READ":
			id_pack = Integer.parseInt( request.getParameter("id") );
			
			dto = service.read(id_pack);
			
			request.setAttribute("dto", dto);
			
			if ( request.getParameter("update") == null )
				this.getServletContext().getRequestDispatcher("/packet/packetread.jsp").forward( request, response );
			else
				this.getServletContext().getRequestDispatcher("/packet/packetupdate.jsp").forward( request, response );
			
			break;
			
		case "INSERT":
			String name = request.getParameter("packetName").toString();
			String description = request.getParameter("packetDescription").toString();
			dto = new PacketDTO (name, description);
			answer = service.insert(dto);
			
			request.setAttribute("ans", answer);
			updateList(request);
			getServletContext().getRequestDispatcher("/packet/packetmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			dto = new PacketDTO (
					Integer.parseInt( request.getParameter("id") ),
					request.getParameter("packetName"),
					request.getParameter("packetDescription")
					);
			
			answer = service.update( dto );
			
			updateList(request);
			getServletContext().getRequestDispatcher("/packet/packetmanager.jsp").forward(request, response);
			
			break;
		
		case "DELETE":
			id_pack = Integer.parseInt( request.getParameter("id") );
			answer = service.delete( id_pack );
			request.setAttribute("ans", answer);
			
			updateList(request);
			getServletContext().getRequestDispatcher("/packet/packetmanager.jsp").forward(request, response);
			
			break;
		}
	}
	

}
