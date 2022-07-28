package com.bwry.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.bwry.entity.Users;
import com.bwry.repository.UsersRepository;
import com.bwry.utils.JDBCTools;

public class UsersRepositoryImpl implements UsersRepository {

	@Override
//用户登录
	public Users getUsers(String name, String password) {
		// TODO Auto-generated method stub
		Connection connection = JDBCTools.getConnection();
		String sql = "select * from users where name = ? and password= ?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Users users = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				users = new Users(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTools.release(connection, statement, resultSet);
		}

		return users;
	}

	@Override
	//查看用户
	public List<Users> LookUsers(String name, String sex, String phone) {
		// TODO Auto-generated method stub
		List<Users> ulist = new ArrayList<Users>();
		Connection connection = JDBCTools.getConnection();
		String sql = "select * from users ";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Users users = null;
		try {
			statement = connection.prepareStatement(sql);
//			statement.setString(1, type);
//			statement.setString(2, name);
//			statement.setInt(3, count);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				users = new Users(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(4),resultSet.getString(5));
//				System.out.println(users.toString());
				ulist.add(users);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTools.release(connection, statement, resultSet);
		}

		return ulist;
	}

	@Override
	//添加用户
	public int addUsers(Users user) {
		// TODO Auto-generated method stub
		Connection connection = JDBCTools.getConnection();
		String sql = "insert into users values(0,?,?,?,?) ";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int resultCUD = -1;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getSex());
			statement.setString(4, user.getPhone());
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

	@Override
	//修改用户
	public int changeUsers(Users users) {
		// TODO Auto-generated method stub
		Connection connection = JDBCTools.getConnection();
		String sql = "update users set name=?,sex=?,phone=? where id=?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int resultCUD = -1;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, users.getName());
//			statement.setString(2, users.getPassword());
			statement.setString(2, users.getSex());
			statement.setString(3, users.getPhone());
			statement.setInt(4, users.getId());
			
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
	@Override
	//修改取值
	public List<Users> updateUsers(Users users) {
		// TODO Auto-generated method stub
		List<Users> uplist = new ArrayList<Users>();
		Connection connection = JDBCTools.getConnection();
		String sql = "select * from users where id=? ";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Users users1 = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, users.getId());
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				users1 = new Users(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(4),resultSet.getString(5));
//				System.out.println(users1.toString());
				uplist.add(users1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTools.release(connection, statement, resultSet);
		}

		return uplist;
	}

	@Override
	//删除用户
	public int delUsers(int did) {
		// TODO Auto-generated method stub
		Connection connection = JDBCTools.getConnection();
		String sql = "delete from users where id=? ";
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

	
}


