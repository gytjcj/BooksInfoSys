package com.bwry.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bwry.entity.Book;
import com.bwry.entity.User;
import com.bwry.repository.UserRepository;
import com.bwry.utils.JDBCTools;

public class UserRepositoryImpl implements UserRepository {
	// 与数据库交互
	//管理员
	@Override
	public User getUser(String name, String password) {
		
		// TODO Auto-generated method stub
		Connection connection = JDBCTools.getConnection();
		String sql = "select * from manages where name = ? and password= ?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTools.release(connection, statement, resultSet);
		}

		return user;
	}

	@Override
	//用户查看图书
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
	

}
