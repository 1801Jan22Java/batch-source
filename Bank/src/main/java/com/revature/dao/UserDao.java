package com.revature.dao;

import com.revature.beans.User;
import com.revature.main.SQLProfileUpdateException;

public interface UserDao {
	public User addUser(String username, String password, String firstname, String lastname);
	public boolean isAvailable(String username);
	public User login(String username, String password);
	public boolean getAllUsers(User thisUser);
	public boolean disableUser(User thisUser);
	public boolean updateProfile(String keyword, String value, User thisUser) throws SQLProfileUpdateException;
}
