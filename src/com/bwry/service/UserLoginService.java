package com.bwry.service;

import java.util.List;

import com.bwry.entity.Users;

public interface UserLoginService {
/* 用户登录 */
public Users userLogin(String name,String password);

/* 查看用户 */
public List<Users> usersLook(String name, String sex,String phone);

/* 添加用户 */
public int usersAdd(Users user);

/* 修改用户 */
public int usersChange(Users users);

/* 修改用户取值 */
	public List<Users> usersUpdate(Users users);

/* 删除用户 */
public int usersDel(int did);

}
