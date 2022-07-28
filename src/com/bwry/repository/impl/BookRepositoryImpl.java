package com.bwry.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bwry.entity.Book;
import com.bwry.entity.LendBook;
import com.bwry.repository.BookRepository;
import com.bwry.utils.JDBCTools;

public class BookRepositoryImpl implements BookRepository {

	@Override
	//查看
	public List<Book> getBook(String type, String name, int count) {
		
		// TODO Auto-generated method stub
		List<Book> list = new ArrayList<Book>();
		Connection connection = JDBCTools.getConnection(); 
		String sql = "select * from books ";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Book book = null;
		try {
			statement = connection.prepareStatement(sql);
//			statement.setString(1, type);
//			statement.setString(2, name);
//			statement.setInt(3, count);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4));
//				System.out.println(book.toString());
				list.add(book);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTools.release(connection, statement, resultSet);
		}

		return list;
	}
	
	@Override
	//添加
	public int addBook(Book book) {
		// TODO Auto-generated method stub
		Connection connection = JDBCTools.getConnection();
		String sql = "insert into books values(0,?,?,?) ";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int resultCUD = -1;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, book.getType());
			statement.setString(2, book.getName());
			statement.setInt(3, book.getCount());
			resultCUD = statement.executeUpdate();
			if(resultCUD>0) {
				return resultCUD;
//				System.out.println(book.toString());
				
			}else{
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTools.release(connection, statement, resultSet);
		}
		return resultCUD;

	}
	

	@Override
	//修改
	public int changeBook(Book books) {
		// TODO Auto-generated method stub
		Connection connection = JDBCTools.getConnection();
		String sql = "update books set type=?,name=?,count=? where id=?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int resultCUD = -1;
		try {
			statement = connection.prepareStatement(sql);
//			System.out.println(books.getId());
//			System.out.println(books.getType());
//			System.out.println(books.getName());
//			System.out.println(books.getCount());
			statement.setString(1, books.getType());
			statement.setString(2, books.getName());
			statement.setInt(3, books.getCount());
			statement.setInt(4, books.getId());
			
			resultCUD = statement.executeUpdate();
			if(resultCUD>0) {
				return resultCUD;
			}else{
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTools.release(connection, statement, resultSet);
		}
		return resultCUD;
	}
	//修改取值ֵ
	@Override
	public List<Book> updateBook(Book books) {
		// TODO Auto-generated method stub
		List<Book> Blist = new ArrayList<Book>();
		Connection connection = JDBCTools.getConnection();
		String sql = "select * from books where id=? ";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Book book1 = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, books.getId());
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				book1 = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4));
//				System.out.println(books.toString());
				Blist.add(book1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTools.release(connection, statement, resultSet);
		}

		return Blist;
	}

	@Override
	//下架
	public int delBook(int did) {
		// TODO Auto-generated method stub
		Connection connection = JDBCTools.getConnection();
		String sql = "delete from books where id=? ";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int resultCUD = -1;

		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, did);
			resultCUD = statement.executeUpdate();
			if(resultCUD>0) {
				return resultCUD;
//				System.out.println(book.toString());
				
			}else{
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTools.release(connection, statement, resultSet);
		}
		return resultCUD;
	}
//	//����
//	@Override
//	public int lend(LendBook lend) {
//		// TODO Auto-generated method stub
//		Connection connection = JDBCTools.getConnection();
//		String sql = "insert into lend values(0,?,?) ";
//		PreparedStatement statement = null;
//		ResultSet resultSet = null;
//		int resultCUD = -1;
//
//		try {
//			statement = connection.prepareStatement(sql);
//			statement.setString(1, lend.getUname());
//			statement.setString(2, lend.getBname());
//			resultCUD = statement.executeUpdate();
//			if(resultCUD>0) {
//				return resultCUD;
////				System.out.println(book.toString());
//				
//			}else{
//				return 0;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			JDBCTools.release(connection, statement, resultSet);
//		}
//		return resultCUD;
//	}

	@Override
	public Book Borrow(String bookname) {
		// TODO Auto-generated method stub
		Connection connection = JDBCTools.getConnection(); 
		String sql = "select * from books where name=?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Book book = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, bookname);
//			System.out.println(bookname);
			resultSet=statement.executeQuery();
		//???
			while (resultSet.next()) {
				book=new Book(resultSet.getInt(1) ,resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
				System.out.println(book.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTools.release(connection, statement, resultSet);
		}
		return book;
	}

}
