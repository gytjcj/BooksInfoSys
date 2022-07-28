package com.bwry.entity;

public class BroBooks {
	private int id;
	private String userName;
	private String bookName;
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public BroBooks(int id, String userName, String bookName) {
		super();
		this.id = id;
		this.userName = userName;
		this.bookName = bookName;
	}
	public BroBooks() {
		super();
	}
	
}
