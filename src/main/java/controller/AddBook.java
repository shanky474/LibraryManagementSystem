package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoImpl;
import model.Book;
import model.User;

public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = new Book();
		User user = new User();
		DaoImpl daoImpl = new DaoImpl();
		HttpSession session = request.getSession(false);
		user = (User) session.getAttribute("user");
		book = daoImpl.select(Integer.parseInt(request.getParameter("bookid")));
		if (user.getRole().equalsIgnoreCase("user")) {
			request.getRequestDispatcher("/mainpages/userlogin.jsp").include(request, response);
		} else if (user.getRole().equalsIgnoreCase("admin")) {
			request.getRequestDispatcher("/mainpages/adminlogin.jsp").include(request, response);
		}
	}

}
