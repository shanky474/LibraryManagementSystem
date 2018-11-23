package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoImpl;
import model.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DaoImpl daoImpl = new DaoImpl();
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		try {
			User granted = daoImpl.authenticate(user);
			if (granted.getRole().equalsIgnoreCase("user")) {
				HttpSession session = request.getSession();
				session.setAttribute("user", granted);
				request.getRequestDispatcher("/mainpages/userlogin.jsp").include(request, response);
			} else if (granted.getRole().equalsIgnoreCase("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("admin", granted);
				request.getRequestDispatcher("/mainpages/adminlogin.jsp").include(request, response);
			}
		} catch (Exception e) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("index.jsp").include(request, response);
			out.println("Wrong credentials!");
		}
	}
}
