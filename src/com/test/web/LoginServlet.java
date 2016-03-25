package com.test.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.dao.impl.BookDAOImpl;
import com.test.dao.impl.UserDAOImpl;
import com.test.domain.Book;

public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static UserDAOImpl userDAO = new UserDAOImpl(); 

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		BookDAOImpl bookDAO = new BookDAOImpl();
		List<Book> books = bookDAO.listAll();
		session.setAttribute("books", books);
		if(userDAO.login(account, password)){
			session.setAttribute("account", account);
			session.setAttribute("password", password);
			response.sendRedirect("dashboard.jsp");
		}else{
			request.getRequestDispatcher("listAll?method='all'").forward(request, response);
		}
	}


}
