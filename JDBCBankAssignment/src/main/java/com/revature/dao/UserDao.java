package com.revature.dao;

import com.revature.beans.User;

public interface UserDao {
	public User login(String username, String password);
	public User register(String username, String password);
}
