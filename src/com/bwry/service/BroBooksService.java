package com.bwry.service;

import com.bwry.entity.BroBooks;

import java.util.List;

public interface BroBooksService {
	public List<BroBooks> BroBooks(int id,String userName,String bookName);

	/* 借书 */
	public void BroBooks(String userName,String bookName);
	/*还书*/
	public void ReturnBooks(String userName,String bookName);
	/*用户借阅信息查看*/
	public List<BroBooks> UBroBooks(int id, String userName, String bookName);

	/* 还书 */
	public int returnBooks(int id);
}
