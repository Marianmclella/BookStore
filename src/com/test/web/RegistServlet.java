package com.test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.dao.impl.UserDAOImpl;
import com.test.domain.User;

public class RegistServlet extends HttpServlet {

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
		User user = null;
		HttpSession session = request.getSession();
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phones = request.getParameter("phone");
		int phone = Integer.parseInt(phones);
		String sexs = request.getParameter("gender");
		int sex= 1;
		String account = request.getParameter("account");
		String passwd = request.getParameter("password");
		String repasswd = request.getParameter("repassword");
		if(!passwd.equals(repasswd)){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			user = new User(account,passwd,firstName,lastName,sex,phone,email);
			if(userDAO.regist(user)){
				session.setAttribute("account", account);
				session.setAttribute("password", passwd);
				response.sendRedirect("index.jsp");
			}
		}
	}

	
}
