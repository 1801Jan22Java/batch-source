package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDao {
	public List<User> getUsers();
	public User getUserById(int id);
	public void addUser(int id);
	public void deleteUser(int id);
	public void editUser(int id);
	
}
