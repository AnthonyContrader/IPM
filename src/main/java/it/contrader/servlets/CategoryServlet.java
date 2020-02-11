package it.contrader.servlets;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.CategoryDTO;
import it.contrader.service.Service;
import it.contrader.service.CategoryService;

public class CategoryServlet extends HttpServlet
{
	/* VARIABLE */
	private static final long serialVersionUID = 1L;
	
	/* CONSTRUCTOR */
	public CategoryServlet () 
	{	
	}
	
	/* METHOD TO UPDATE LIST */
	public void updateList (HttpServletRequest request) 
	{
		Service<CategoryDTO> service = new CategoryService();
		List<CategoryDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	/* SERVICE METHOD */
	@Override
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Service<CategoryDTO> service = new CategoryService();
		String mode = request.getParameter("mode");
		CategoryDTO dto;
		int id_cat;
		boolean ans;
		
		switch (mode.toUpperCase()) 
		{
			case "CATEGORYLIST":
				updateList(request);
				getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
				break;
				
			case "READ":
				id_cat = Integer.parseInt(request.getParameter("id_cat"));
				dto = service.read(id_cat);
				request.setAttribute("dto", dto);
				
				if (request.getParameter("update") == null)
					getServletContext().getRequestDispatcher("/category/readcategory.jsp").forward(request, response);
				else
					getServletContext().getRequestDispatcher("/category/updatecategory.jsp").forward(request, response);
				
				break;
				
			case "INSERT":
				String name = request.getParameter("name").toString();
				dto = new CategoryDTO (name);
				ans = service.insert(dto);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
				break;
				
			case "UPDATE":
				name = request.getParameter("name");
				id_cat = Integer.parseInt(request.getParameter("id_cat"));
				dto = new CategoryDTO (id_cat, name);
				ans = service.update(dto);
				updateList(request);
				getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
				break;
				
			case "DELETE":
				id_cat = Integer.parseInt(request.getParameter("id_cat"));
				ans = service.delete(id_cat);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
				break;
		}
	}
}
