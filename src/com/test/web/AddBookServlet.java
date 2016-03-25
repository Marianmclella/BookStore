package com.test.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.impl.BookDAOImpl;
import com.test.domain.Book;
import com.test.utils.FileUpload;

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
		String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
		String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
		HashMap<String,String> result = FileUpload.fileUpload(savePath,tempPath, request, response);
		BookDAOImpl bookDAO = new BookDAOImpl();
		Book book = new Book();
		book.setId(Integer.parseInt(result.get("no")));
		book.setName(result.get("name"));
		book.setAuthor(result.get("author"));
		book.setPrice(Double.parseDouble(result.get("price")));
		book.setCategrory(result.get("category"));
		book.setStock(Integer.parseInt(result.get("amount")));
		book.setPicUrl(result.get("path"));
		book.setIntroduce(result.get("introduce"));
		System.out.println(result.get("path"));
		if(bookDAO.addBook(book)){
			request.setAttribute("status", 200);
			request.getRequestDispatcher("addBook.jsp").forward(request, response);
		}
		
	}

}
