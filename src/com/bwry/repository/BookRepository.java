package com.bwry.repository;

import java.util.List;

import com.bwry.entity.Book;
import com.bwry.entity.LendBook;

public interface BookRepository {
	//图书查看
	public List<Book> getBook(String type,String name,int count);
	//添加图书
	public int addBook(Book book);
	//修改
	public int changeBook(Book books);
		//修改取值
			public List<Book> updateBook(Book books);
	//删除
	public int delBook(int did);
//	//����
//	public int lend(LendBook lend);
	public Book Borrow(String name);
	
}
