package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.OsTypeDTO;
import it.contrader.service.OsTypeService;
import it.contrader.service.Service;

/**
 * Servlet implementation class OsTypeServlet
 */
public class OsTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OsTypeServlet() { }

	
	protected void updateList (HttpServletRequest request) {
		Service <OsTypeDTO> service = new OsTypeService();
		List<OsTypeDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Service<OsTypeDTO> service = new OsTypeService();
		String mode = request.getParameter("mode");
		OsTypeDTO dto;
		int id;
		boolean ans;
		
		switch (mode.toUpperCase()) {
		
		case "OSTYPELIST":
			updateList(request);
			getServletContext().getRequestDispatcher
			("/ostype/ostypemanager.jsp").forward(request, response);
			break;
		
		case "READ":
			id=Integer.parseInt(request.getParameter("id"));
			dto=service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update")==null) {
				getServletContext().getRequestDispatcher
				("/ostype/readostype.jsp")
				.forward(request, response);;
			} else 
				getServletContext().getRequestDispatcher
				("/ostype/updateostype.jsp")
				.forward(request, response);;
			
			break;
			
		case "INSERT":
			String name = request.getParameter("name").toString();
			String comm = request.getParameter("comm").toString();
			dto = new OsTypeDTO(name, comm);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher
			("/ostype/ostypemanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name=request.getParameter("ostypeName");
			comm=request.getParameter("ostypeCommand");
			id=Integer.parseInt(request.getParameter("id"));
			dto=new OsTypeDTO(id, name, comm);
			ans=service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/ostype/ostypemanager.jsp").forward(request, response);
			break;
			
		case "DELETE":
			id=Integer.parseInt(request.getParameter("id"));
			ans=service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher
			("/ostype/ostypemanager.jsp").forward(request, response);
		
			break;
		}
	}
}
