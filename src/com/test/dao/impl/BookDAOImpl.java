package com.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.IBookDAO;
import com.test.db.DBUtils;
import com.test.domain.Book;

public class BookDAOImpl implements IBookDAO {

	public boolean addBook(Book book) {
		Connection conn = null;
		PreparedStatement preparStatement = null;
		try{
			conn = DBUtils.getConnection();
			String sql ="insert into store.book (no,name,author,price,category,stock,introduce,picUrl)" +
					"values(?,?,?,?,?,?,?,?)";
			preparStatement = conn.prepareStatement(sql);
			preparStatement.setInt(1, book.getId());
			preparStatement.setString(2, book.getName());
			preparStatement.setString(3,book.getAuthor());
			preparStatement.setDouble(4, book.getPrice());
			preparStatement.setString(5, book.getCategrory());
			preparStatement.setInt(6, book.getStock());
			preparStatement.setString(7, book.getIntroduce());
			preparStatement.setString(8, book.getPicUrl());
			preparStatement.executeUpdate();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.release();
		}
		return false;
	}

	public boolean deletebook(int id) {
		Connection conn = null;
		PreparedStatement preparStatement = null;
		try{
			conn = DBUtils.getConnection();
			String sql ="delete from store.book where no=?";
			preparStatement = conn.prepareStatement(sql);
			preparStatement.setInt(1, id);
			preparStatement.executeUpdate();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.release();
		}
		return false;
	}

	public List<Book> listAll() {
		Connection conn =null;
		Statement statement = null;
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();
		try{
			conn = DBUtils.getConnection();
			statement = conn.createStatement();
			String sql = "select * from store.book";
			rs = statement.executeQuery(sql);
			while(rs.next()){
				Book book = new Book();
				book.setId(rs.getInt("no"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setPicUrl(rs.getString("picUrl"));
				book.setIntroduce(rs.getString("introduce"));
				book.setCategrory(rs.getString("category"));
				book.setStock(rs.getInt("stock"));
				books.add(book);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.release();
		}
		return books;
	}

	public List<Book> listByCategroy(String category) {
		Connection conn =null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();
		try{
			conn = DBUtils.getConnection();
			String sql = "select * from store.book where category=?";
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setPicUrl(rs.getString("picUrl"));
				book.setIntroduce(rs.getString("introduce"));
				book.setCategrory(rs.getString("category"));
				book.setStock(rs.getInt("stock"));
				books.add(book);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.release();
		}
		return books;
	}

	public List<Book> searchByName(String bookName) {
		Connection conn =null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();
		try{
			conn = DBUtils.getConnection();
			String sql = "select * from store.book where name=?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, bookName);
			rs = preparedStatement.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setPicUrl(rs.getString("picUrl"));
				book.setIntroduce(rs.getString("introduce"));
				book.setCategrory(rs.getString("category"));
				book.setStock(rs.getInt("stock"));
				books.add(book);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.release();
		}
		return books;
	}

	public List<Book> sequenceByPrice(String method) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Book> searchByAuthor(String author) {
		Connection conn =null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();
		try{
			conn = DBUtils.getConnection();
			String sql = "select * from store.book where author=?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, author);
			rs = preparedStatement.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setPicUrl(rs.getString("picUrl"));
				book.setIntroduce(rs.getString("introduce"));
				book.setCategrory(rs.getString("category"));
				book.setStock(rs.getInt("stock"));
				books.add(book);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.release();
		}
		return books;
	}

}
