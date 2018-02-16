package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDAO {
	public User checkCredentials(String username, String password);
	public User getUserById(int id);
	public User getUserByUsername(String username);
	public List<User> viewAllUsers();
	public void updatePersonalInfo(User employee, String column, String value);
}
