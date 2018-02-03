package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDao {

	public List<User> getUsers();
	public User getUserByID(int id);
	public void addUser(User u);
	public void updateUser(User u, User t);
	public void deleteUser(User u);
	
}
