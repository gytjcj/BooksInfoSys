package com.bwry.repository;

import java.util.List;

import com.bwry.entity.Users;

public interface UsersRepository {
	/* 用户登录 */
	public	Users getUsers(String name, String password);

	/* 查看用户 */
	public List<Users> LookUsers(String name,String sex,String phone);

	/* 添加用户 */
	public int addUsers(Users user);

	/* 修改用户 */
	public int changeUsers(Users users);

	/* 修改用户取值ֵ */
		public List<Users> updateUsers(Users users);

	/* 删除用户 */
	public int delUsers(int did);
}
