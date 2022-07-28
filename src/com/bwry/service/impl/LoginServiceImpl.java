package com.bwry.service.impl;

import java.util.List;

import com.bwry.entity.Book;
import com.bwry.entity.User;
import com.bwry.repository.UserRepository;
import com.bwry.repository.impl.UserRepositoryImpl;
import com.bwry.service.LoginService;

public class LoginServiceImpl implements LoginService {
private UserRepository UserRepository = new UserRepositoryImpl();

	@Override
	public User login(String name, String password) {
		// TODO Auto-generated method stub
		return UserRepository.getUser(name, password);
	}

	@Override
	public List<Book> bookLook(String type, String name, int count) {
		// TODO Auto-generated method stub
		return UserRepository.getBook(type, name, count);
	}

}
