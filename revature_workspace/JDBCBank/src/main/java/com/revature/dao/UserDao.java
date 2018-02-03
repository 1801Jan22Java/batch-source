package com.revature.dao;

import java.util.List;

import Beans.User;

public interface UserDao {
	
	public List<User> getUsers();
	public User getUserById(int id);
	public void addUser(User user); 
	public void validateCredentials(String username, String password);
	public void createUser(User user);

}
