package com.shine.dsst.service;

import java.util.ArrayList;

import com.shine.dsst.bean.User;

public interface UserService {
	   public User login(String idcard,String name);
	   public User adminLogin(String username, String password);
	   public User userLOgin(String userName,String password);
	   public boolean userRegister(User user);
	   public boolean AddUser(User user);
	   public boolean removeUser(int uid);
	   public User queryUserByuid(int uid);
	   public boolean updateUser(int uid,User user);
	   public ArrayList<User> queryAll(); 
	   public ArrayList<User> queryUser(String username);
	   public User queryUserByUserNameAndPassword(String username,String password);
	

}
