package com.bwry.service;

import java.util.List;

import com.bwry.entity.Book;
import com.bwry.entity.User;

public interface LoginService {
public User login(String name,String password);

/* �û��鼮��Ϣ�鿴 */	
public List<Book> bookLook(String type, String name,int count);
}
