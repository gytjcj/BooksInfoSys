package com.bwry.repository;

import java.util.List;

import com.bwry.entity.Users;

public interface UsersRepository {
//�û���¼
	public	Users getUsers(String name, String password);
//�鿴�û�
	public List<Users> LookUsers(String name,String sex,String phone);
//����û�
	public int addUsers(Users user);
//�޸��û�
	public int changeUsers(Users users);
	//�޸��û�ȡֵ
		public List<Users> updateUsers(Users users);
//ɾ���û�
	public int delUsers(int did);
}
