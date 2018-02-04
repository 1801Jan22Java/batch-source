package com.revature.dao;

import java.util.List;

import Beans.User;

public interface UserDao {
	
	public List<User> getUsers();
	public User getUserById(int id);
	public User getUserByCredentials(String username,String password);
	public int getUserID(User user);
	public void addUser(User user); 
	public boolean validateCredentials(String username, String password);
	public User logout();
	public boolean validateSuperUser(User user);
	public void deleteUser(User user1,User User2);
	public User createUser();

}
