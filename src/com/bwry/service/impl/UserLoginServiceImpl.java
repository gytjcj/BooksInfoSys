package com.bwry.service.impl;

import java.util.List;

import com.bwry.entity.Users;
import com.bwry.repository.UsersRepository;
import com.bwry.repository.impl.UsersRepositoryImpl;
import com.bwry.service.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService {
	private UsersRepository UsersRepository = new UsersRepositoryImpl();

	@Override
	//�û���¼
	public Users userLogin(String name, String password) {
		// TODO Auto-generated method stub
		return UsersRepository.getUsers(name, password);
	}

	@Override
	/* �鿴�û� */
	public List<Users> usersLook(String name, String sex, String phone) {
		// TODO Auto-generated method stub
		return UsersRepository.LookUsers(name, sex, phone);
	}

	@Override
	/* ����û� */
	public int usersAdd(Users user) {
		// TODO Auto-generated method stub
		return UsersRepository.addUsers(user);
	}

	@Override
	/* �޸��û� */
	public int usersChange(Users users) {
		// TODO Auto-generated method stub
		return UsersRepository.changeUsers(users);
	}
		@Override
		/* �޸��û�ȡֵ */
		public List<Users> usersUpdate(Users users) {
			// TODO Auto-generated method stub
			return UsersRepository.updateUsers(users);
		}

	@Override
	/* ɾ���û� */
	public int usersDel(int did) {
		// TODO Auto-generated method stub
		return UsersRepository.delUsers(did);
	}

	
	

}
