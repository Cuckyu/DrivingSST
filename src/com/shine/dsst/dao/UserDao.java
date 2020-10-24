package com.shine.dsst.dao;

import java.util.ArrayList;

import com.shine.dsst.bean.User;

public interface UserDao {
	
	public User login(String idcard,String name);

	public User adminLogin(String username, String password);
	   public boolean AddUser(User user);
	   public boolean deleteUser(int uid);
	   public User selectUserByuid(int uid);
	   public boolean modifyUser(int uid,User user);
	   public ArrayList<User> selectAll(); 
	   public ArrayList<User> selectUser(String username);
	   public User selectUserByUserNameAndPassword(String username,String password);
	

}
