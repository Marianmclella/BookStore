package com.test.domain;

public class Book {
	private int id;
	private String name;
	private String author;
	private double price;
	private String picUrl;
	private String category;
	private int stock;
	private String introduce;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getCategrory() {
		return category;
	}
	public void setCategrory(String categrory) {
		this.category = categrory;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String name, String author, double price,
			String picUrl, String categrory, int stock, String introduce) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.picUrl = picUrl;
		this.category = categrory;
		this.stock = stock;
		this.introduce = introduce;
	}
	
	
}
