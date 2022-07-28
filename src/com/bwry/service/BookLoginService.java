package com.bwry.service;

import java.util.List;

import com.bwry.entity.Book;
import com.bwry.entity.LendBook;

public interface BookLoginService {
//查看
public List<Book> bookLook(String type, String name,int count);
//添加
public int bookAdd(Book book);
//修改
public int bookChange(Book books);
	//修改取值ֵ
		public List<Book> bookUpdate(Book books);
//删除
public int bookDel(int did);
}
