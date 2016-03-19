package com.test.junit;

import java.util.List;

import org.junit.Test;

import com.test.dao.impl.BookDAOImpl;
import com.test.domain.Book;

public class TestBookDAOImpl {

	static BookDAOImpl bookDAO = new BookDAOImpl();

	@Test
	public void testSearchByName() {
		List<Book> books = bookDAO.searchByName("test");
		for (Book b : books) {
			System.out.println(b.getCategrory());
			System.out.println(b.getName());
			System.out.println(b.getPicUrl());
			System.out.println(b.getPrice());
			System.out.println(b.getStock());
			System.out.println(books.size());
		}
	}
	
	@Test
	public void testAddBook(){
		Book book = new Book();
		book.setId(1101);
		book.setName("test");
		book.setAuthor("test");
		book.setPrice(23);
		book.setCategrory("keji");
		book.setIntroduce("12");
		book.setStock(100);
		book.setPicUrl("asd");
		System.out.println(bookDAO.addBook(book));
	}
	
	@Test
	public void testListBook(){
		List<Book> books = bookDAO.listAll();
		for (Book b : books) {
			System.out.print(b.getName()+"\t");
			System.out.print(b.getCategrory()+"\t");
			System.out.print(b.getPicUrl()+"\t");
			System.out.print(b.getPrice()+"\t");
			System.out.print(b.getStock()+"\t");
			System.out.print(books.size()+"\t");
			System.out.println("");
		}
	}
	
	@Test
	public void testDeleteBook(){
		System.out.println(bookDAO.deletebook(1101));
	}
}
