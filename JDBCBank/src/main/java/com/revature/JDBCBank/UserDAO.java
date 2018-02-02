package com.revature.JDBCBank;

public interface UserDAO {
	public Integer login(String username, String password);
	
	// Create new user
	public void newUser(String username, String password);
}
