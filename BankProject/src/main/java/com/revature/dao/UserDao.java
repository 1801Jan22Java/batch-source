package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDao {

	public List<User> getUsers();
	
	public User getUserById(int id);
	
	public void insertNewUser(String username, String password);
	
}
