package com.bwry.entity;

public class Book {
	private  int id;
	private  String type;
	private  String name;
	private  int count;
	
	
	public Book(String type, String name, int count) {
		super();
		this.type = type;
		this.name = name;
		this.count = count;
	}
	public Book(int id, String type, String name, int count) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.count = count;
	}
	public  int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public  String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public  String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public  int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
//	@Override
//	public String toString() {
//		return "Book [id=" + id + ", type=" + type + ", name=" + name + ", count=" + count + "]";
//	}
	
	
}
