package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDAO {
	// User DAO
	// Logins
	// Check username and password
	// Base who logged in based on position_id in database
	// -An Employee can login
	// -An Employee can logout
	// -A Manager can login
	// -A Manager can logout
	public User getUser(String username);
	
	// -An Employee can view their information
	// Can be done via returning User object in login. 
	// User object will contain all the information about the user.
	// public User seeInfo(int user_id);

	// -An Employee can view the Employee Homepage
	// Servlet
	// -A Manager can view the Manager Homepage
	// Servlet

	/*
	 * Employee
	 */

	// -An Employee can update their information
	public boolean editInfo(int user_id, String firstname, String lastname, String password);

	/*
	 * Manager
	 */
	// -A Manager can view all Employees
	public List<User> getAllEmployees();
}
// 9 requirements
