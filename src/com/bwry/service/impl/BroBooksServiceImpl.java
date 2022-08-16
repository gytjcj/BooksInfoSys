package com.bwry.service.impl;

import java.util.List;

import com.bwry.entity.Book;
import com.bwry.entity.BroBooks;
import com.bwry.repository.BookRepository;
import com.bwry.repository.BroBooksRepository;
import com.bwry.repository.impl.BookRepositoryImpl;
import com.bwry.repository.impl.BroBooksRepositoryImpl;
import com.bwry.service.BroBooksService;


public class BroBooksServiceImpl implements BroBooksService{
	BroBooksRepository broBooksRepository = new BroBooksRepositoryImpl();
	BookRepository bookRepository=new BookRepositoryImpl();
	
	/* 图书查看 */
	public List<BroBooks> BroBooks(int id,String userName,String bookName) {
		// TODO Auto-generated method stub
		return broBooksRepository.getBroBooks(id, userName, bookName);
	}

	
	/* 还书 */
	@Override
	public void ReturnBooks(String userName, String bookName) {
		Book book=bookRepository.Borrow(bookName);
//		System.out.println(book.getId());
//		System.out.println(book.getType());
//		System.out.println(book.getName());
//		System.out.println(book.getCount());
		if (book!=null) {
			broBooksRepository.addBroBooks(userName, bookName);
			book.setCount(book.getCount()+1);
			bookRepository.changeBook(book);
		}
	}

	/* 借书 */	
	@Override
	public void BroBooks(String userName, String bookName) {
		Book book=bookRepository.Borrow(bookName);
//		System.out.println(book.getId());
//		System.out.println(book.getType());
//		System.out.println(book.getName());
//		System.out.println(book.getCount());
		if (book!=null&&book.getCount()>0) {
			broBooksRepository.addBroBooks(userName, bookName);			
			book.setCount(book.getCount()-1);
			bookRepository.changeBook(book);
		}
		
	}

	/* 借阅信息查看 */
	@Override
	public List<com.bwry.entity.BroBooks> UBroBooks(int id, String userName, String bookName) {
		// TODO Auto-generated method stub
		return broBooksRepository.uBroBook(id, userName, bookName);
	}


	/* 还书id */
	@Override
	public int returnBooks(int id) {
		// TODO Auto-generated method stub
		return broBooksRepository.returnBroBooks(id);
	}
}
