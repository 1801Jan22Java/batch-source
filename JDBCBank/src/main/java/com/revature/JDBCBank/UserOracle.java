package com.revature.JDBCBank;

// Abstract out user operations
public class UserOracle implements UserDAO {
	public Integer login(String username, String password) {
		Integer userid = 0;
		return userid;
	}
	
	// Create new user
	public void newUser(String username, String password) {
		
	}
}
