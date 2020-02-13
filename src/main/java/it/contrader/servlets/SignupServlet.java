package it.contrader.servlets;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
import it.contrader.service.UserService;

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignupServlet() {
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<UserDTO> service = new UserService();
		String mode = request.getParameter("mode");
		UserDTO dto;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "SIGNUP":
			String username = request.getParameter("username").toString();
			String password = request.getParameter("password").toString();
			String usertype = "USER";
			dto = new UserDTO (username,password,usertype);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);

			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			break;
			
		default:
			getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
			break;

		}
	}
}