package com.bwry.service.impl;

import java.util.List;

import com.bwry.entity.Book;
import com.bwry.entity.LendBook;
import com.bwry.repository.BookRepository;
import com.bwry.repository.impl.BookRepositoryImpl;
import com.bwry.service.BookLoginService;

@SuppressWarnings("unused")
public class BookLoginServiceImpl implements BookLoginService{
	private BookRepository BookRepository = new BookRepositoryImpl();

	@Override
	/* 查看图书 */
	public List<Book> bookLook(String type, String name, int count) {
		// TODO Auto-generated method stub
		return BookRepository.getBook(type, name, count);
	}
	@Override
	/* 添加图书 */
	public int bookAdd(Book book) {
		// TODO Auto-generated method stub
		return BookRepository.addBook(book);
	}
	@Override
	/* 修改图书 */
	public int bookChange(Book books) {
		// TODO Auto-generated method stub
		return BookRepository.changeBook(books);
	}
			@Override
			/* 修改取字段值 */
			public List<Book> bookUpdate(Book books) {
				// TODO Auto-generated method stub
				return BookRepository.updateBook(books);
			}
	@Override
	/* 删除图书 */
	public int bookDel(int did) {
		// TODO Auto-generated method stub
		return BookRepository.delBook(did);
	}
//	//锟斤拷锟斤拷
//	@Override
//	public int lend(LendBook lend) {
//		// TODO Auto-generated method stub
//		return BookRepository.lend(lend);
//	}
	
	
	
}
