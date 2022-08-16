package com.bwry.service.impl;

import java.util.List;

import com.bwry.entity.Users;
import com.bwry.repository.UsersRepository;
import com.bwry.repository.impl.UsersRepositoryImpl;
import com.bwry.service.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService {
	private UsersRepository UsersRepository = new UsersRepositoryImpl();

	@Override
	//用户登录
	public Users userLogin(String name, String password) {
		// TODO Auto-generated method stub
		return UsersRepository.getUsers(name, password);
	}

	@Override
	/* 查看用户 */
	public List<Users> usersLook(String name, String sex, String phone) {
		// TODO Auto-generated method stub
		return UsersRepository.LookUsers(name, sex, phone);
	}

	@Override
	/* 添加用户 */
	public int usersAdd(Users user) {
		// TODO Auto-generated method stub
		return UsersRepository.addUsers(user);
	}

	@Override
	/* 修改用户 */
	public int usersChange(Users users) {
		// TODO Auto-generated method stub
		return UsersRepository.changeUsers(users);
	}
		@Override
		/* 修改用户取值 */
		public List<Users> usersUpdate(Users users) {
			// TODO Auto-generated method stub
			return UsersRepository.updateUsers(users);
		}

	@Override
	/* 删除用户 */
	public int usersDel(int did) {
		// TODO Auto-generated method stub
		return UsersRepository.delUsers(did);
	}

	
	

}
