package com.bwry.service;

import java.util.List;

import com.bwry.entity.Users;

public interface UserLoginService {
/* �û���¼ */
public Users userLogin(String name,String password);

/* �鿴�û� */
public List<Users> usersLook(String name, String sex,String phone);

/* ����û� */
public int usersAdd(Users user);

/* �޸��û� */
public int usersChange(Users users);

/* �޸��û�ȡֵ */
	public List<Users> usersUpdate(Users users);

/* ɾ���û� */
public int usersDel(int did);

}
