package com.auto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.bo.Corporation;
import com.auto.dao.IAccountDao;
import com.auto.domain.User;
import com.auto.service.IAccountService;
@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountDao accountDao;

	@Override
	public boolean validate(String account, String password) {
	 
		return accountDao.validate(account, password);
	}

	@Override
	public boolean addUser(User user) {
		 
		return accountDao.addUser(user);
	}

	@Override
	public User getUser(long userId) {
		 
		return accountDao.getUser(userId);
	}

	@Override
	public List<User> getUserList() {
		
		return accountDao.getUserList();
	}

	@Override
	public List<User> getUserList(int teamId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changePassword(String account, String oldPassword,
			String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getUserId(String account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void changeProfile(long userId, String profileProperty,
			String profileValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateProfile(long userId, String name, String email,
			String password, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void _updatePassword(String account, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Corporation> getCorporationList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Corporation> getCorporationListWithPager(long userId,
			int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

 

}
