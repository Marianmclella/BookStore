package com.test.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.dao.impl.BookDAOImpl;
import com.test.domain.Book;

public class BookInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BookDAOImpl bookDAO = new BookDAOImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			int id =Integer.parseInt(request.getParameter("id"));
			Book book = bookDAO.searchByID(id);
			List<String> categorys = bookDAO.showCategory();
			request.setAttribute("categorys",categorys);
			request.setAttribute("book", book);
			request.getRequestDispatcher("bookInfo.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = new Book();
		book.setId(Integer.parseInt(request.getParameter("no")));
		book.setName(request.getParameter("name"));
		book.setAuthor(request.getParameter("author"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));
		book.setCategrory(request.getParameter("category"));
		book.setStock(Integer.parseInt(request.getParameter("stock")));
//		book.setPicUrl(request.getParameter("picUrl"));
		book.setIntroduce(request.getParameter("introduce"));
		int status = 0;
		if(bookDAO.updateBook(book)){
			status = 200;
			request.setAttribute("status",status);
			request.getRequestDispatcher("bookInfo?id="+book.getId()).forward(request, response);
		}
	}
}
