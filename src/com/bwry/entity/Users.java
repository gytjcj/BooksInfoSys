package com.bwry.entity;
//”√ªß
public class Users {
	private int id;
	private String name;
	private String password;
	private String sex;
	private String phone;
	
	public Users(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public Users(String name, String password, String sex, String phone) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.phone = phone;
	}



	public Users(int id, String name, String sex, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
	}



	public Users(int aid, String aname, String apassword, String asex, String aphone) {
		// TODO Auto-generated constructor stub
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
//	@Override
//	public String toString() {
//		return "Users [ id=" + id + ",name=" + name + ", password=" + password + ", sex=" + sex + ", phone=" + phone + "]";
//	}	
	

}
