package com.revature.dao;

import com.revature.beans.User;

public interface UserDAO {
	
	public boolean checkCredentials(String username, String password);
	public User getUserById(int id);
	public User getUserByUsername(String username);
	
}
