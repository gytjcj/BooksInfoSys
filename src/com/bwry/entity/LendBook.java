package com.bwry.entity;

public class LendBook {
	private  int id;
	private  String uname;
	private  String bname;
	@Override
	public String toString() {
		return "LendBook [id=" + id + ", uname=" + uname + ", bname=" + bname + "]";
	}
	public LendBook(int id, String uname, String bname) {
		super();
		this.id = id;
		this.uname = uname;
		this.bname = bname;
	}
	public LendBook() {
		super();
	}
	public LendBook(String uname, String bname) {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	
}
