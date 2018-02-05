package com.revature.dao;

import com.revature.beans.BankUsers;

public interface UserDAO {
	// Login
	public BankUsers login(String username, String password);

	// Create new user
	public boolean newUser(String username, String password);

	// Delete user
	public boolean deleteUser(int userid);

	// Update user
	public boolean editUser(int userid, int roleid, String username, String password);
	
	public void showAllUsers();
}
