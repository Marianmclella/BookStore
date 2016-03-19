package com.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.impl.BookDAOImpl;
import com.test.domain.Book;

public class AddBookServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BookDAOImpl bookDAO = new BookDAOImpl();
		Book book = new Book();
		book.setId(Integer.parseInt(request.getParameter("no")));
		book.setName(request.getParameter("name"));
		book.setAuthor(request.getParameter("author"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));
		book.setCategrory(request.getParameter("category"));
		book.setStock(Integer.parseInt(request.getParameter("amount")));
//		book.setPicUrl(request.getParameter("picUrl"));
		book.setIntroduce(request.getParameter("introduce"));
		if(bookDAO.addBook(book)){
			request.setAttribute("status", 1);
			request.getRequestDispatcher("addBook.jsp").forward(request, response);
		}
		
	}

}
