package com.bwry.service;

import com.bwry.entity.BroBooks;

import java.util.List;

public interface BroBooksService {
	public List<BroBooks> BroBooks(int id,String userName,String bookName);

	/* ���� */
	public void BroBooks(String userName,String bookName);
	/*����*/
	public void ReturnBooks(String userName,String bookName);
	/*�û�������Ϣ�鿴*/
	public List<BroBooks> UBroBooks(int id, String userName, String bookName);

	/* ���� */
	public int returnBooks(int id);
}
