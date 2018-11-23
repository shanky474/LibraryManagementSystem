package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoImpl;
import model.Fine;
import model.User;

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		Fine fine = new Fine();
		DaoImpl daoImpl = new DaoImpl();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setRole(request.getParameter("role"));
		user.setExpiry("");
		fine.setAmount(0);
		fine.setPaymentdate("");
		fine.setUser(user);
		user.setFine(fine);
		if (daoImpl.save(user)) {
			request.getRequestDispatcher("/index.jsp").include(request, response);
			out.println("<a style=\"color:blue;\">User added!</a>");
		} else {
			request.getRequestDispatcher("/mainpages/signup.jsp").include(request, response);
			out.println("<a style=\"color:blue;\">Error! Please try again</a>");
		}
	}

}
