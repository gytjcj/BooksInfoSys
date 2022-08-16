package com.bwry.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bwry.entity.BroBooks;
import com.bwry.repository.BroBooksRepository;
import com.bwry.utils.JDBCTools;

public class BroBooksRepositoryImpl implements BroBooksRepository{
	/* 用户查看借阅情况 */
public List<BroBooks> getBroBooks(int id,String userName,String bookName) {
		
		// TODO Auto-generated method stub
		List<BroBooks> list = new ArrayList<BroBooks>();
		Connection connection = JDBCTools.getConnection(); 
		String sql = "select * from brobooks ";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		BroBooks book1 = null;
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				book1 = new BroBooks(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
				list.add(book1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTools.release(connection, statement, resultSet);
		}

		return list;
	}

	/* 借书 */
@Override
public void addBroBooks(String userName, String bookName) {
	Connection connection = JDBCTools.getConnection(); 
	String sql = "insert into brobooks values(0,?,?)";
	PreparedStatement statement = null;		
	ResultSet resultSet = null;
	try {
		statement = connection.prepareStatement(sql);
		statement.setString(1, userName);
		statement.setString(2, bookName);
		statement.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		JDBCTools.release(connection, statement, resultSet);
	}
}

/* 还书 */
@Override
public int returnBroBooks(int id) {
	Connection connection = JDBCTools.getConnection(); 
	String sql = "delete from brobooks where id=?";
	PreparedStatement statement = null;		
	ResultSet resultSet = null;
	 int resultCUD = -1;
	try {
		statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		statement.executeUpdate();
		if(resultCUD>0) {
			return resultCUD;
//			System.out.println(book.toString());
			
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

/* 用户借阅信息查看 */
@Override
public List<BroBooks> uBroBook(int id, String userName, String bookName) {
	// TODO Auto-generated method stub
	List<BroBooks> blist = new ArrayList<BroBooks>();
	Connection connection = JDBCTools.getConnection(); 
	String sql = "select * from brobooks where userName=? ";
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	BroBooks book = null;
	try {
		statement = connection.prepareStatement(sql);
		statement.setString(1, userName);
		resultSet = statement.executeQuery();
		while(resultSet.next()) {
			book = new BroBooks(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
			blist.add(book);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		JDBCTools.release(connection, statement, resultSet);
	}

	return blist;
}
	
}

