package com.bwry.repository;

import java.util.List;

import com.bwry.entity.Book;
import com.bwry.entity.User;

public interface UserRepository {

	public	User getUser(String name, String password);
	//�û��鿴ͼ��
	public List<Book> getBook(String type,String name,int count);
}
