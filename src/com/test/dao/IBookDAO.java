package com.test.dao;

import java.util.List;

import com.test.domain.Book;

public interface IBookDAO {

	/**
	 * 列出所有的图书
	 * */
	List<Book> listAll();
	
	/**
	 * 根据类别查询图书
	 * @param category
	 * */
	List<Book> listByCategroy(String category);
	
	/**
	 * 根据书名查询图书
	 * @param bookName
	 * */
	List<Book> searchByName(String bookName);
	
	/**
	 * 根据作者查询图书
	 * @param author
	 * */
	List<Book> searchByAuthor(String author);
	
	/**
	 * 根据ID查询图书
	 * **/
	Book searchByID(int id);
	
	/**
	 * 根据价格由高到低进行排列
	 * @param method
	 * */
	List<Book> sequenceByPrice(String method);
	
	/**
	 * 添加一本图书
	 * @param book
	 * */
	boolean addBook(Book book);
	
	/**
	 * 删除一本图书
	 * */
	boolean deletebook(int id);
	
	/**
	 * 更新某本图书的信息
	 * */
	boolean updateBook(Book book);
	
	/**
	 * 列出图书的所有分类
	 * **/
	List<String> showCategory();
}
