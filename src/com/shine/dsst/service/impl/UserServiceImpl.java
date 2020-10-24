package com.shine.dsst.service.impl;

import java.util.ArrayList;

import com.shine.dsst.bean.User;
import com.shine.dsst.dao.UserDao;
import com.shine.dsst.dao.impl.UserDaoImpl;
import com.shine.dsst.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserServiceImpl() {
		
	}
	private static UserServiceImpl userServiceImpl;
	public static UserServiceImpl getUserServiceInstance() {
		if(userServiceImpl==null) {
			userServiceImpl=new UserServiceImpl();
		}
		return userServiceImpl;
		
	}
	
	private UserDao userDao = UserDaoImpl.getInstance();
	
	@Override
	public User login(String idcard, String name) {
		return userDao.login(idcard, name);
	}

	@Override
	public User adminLogin(String username, String password) {
		return userDao.adminLogin(username,password);
	}

	@Override
	public User userLOgin(String userName, String password) {
		userDao.selectUserByUserNameAndPassword(userName, password);
		return null;
	}

	@Override
	public boolean userRegister(User user) {
		return false;
	}

	@Override
	public boolean AddUser(User user) {
		return userDao.AddUser(user);
	}

	@Override
	public boolean removeUser(int uid) {
		return userDao.deleteUser(uid);
	}

	@Override
	public User queryUserByuid(int uid) {
		// TODO Auto-generated method stub
		return userDao.selectUserByuid(uid);
	}

	@Override
	public boolean updateUser(int uid, User user) {
		return userDao.modifyUser(uid, user);
	}

	@Override
	public ArrayList<User> queryAll() {
		return userDao.selectAll();
	}

	@Override
	public ArrayList<User> queryUser(String username) {
		return userDao.selectUser(username);
	}

	@Override
	public User queryUserByUserNameAndPassword(String username, String password) {
		return userDao.selectUserByUserNameAndPassword(username, password);
	}


}
