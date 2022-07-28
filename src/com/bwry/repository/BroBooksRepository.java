package com.bwry.repository;

import java.util.List;

import com.bwry.entity.BroBooks;

public interface BroBooksRepository {
	public List<BroBooks> getBroBooks(int id, String userName, String bookName);
	//借
	public void addBroBooks(String userName,String bookName);
	//用户借阅信息查看
	public List<com.bwry.entity.BroBooks> uBroBook(int id, String userName, String bookName);
	//还
	public int returnBroBooks(int id);
}
