package com.revature.dao;

import com.revature.beans.User;
import com.revature.exceptions.IncorrectCredentialsException;
import com.revature.exceptions.UserTakenException;

public interface UserDAO {
	
	public boolean checkCredentials(String username, String password) throws IncorrectCredentialsException;
	public User getUserById(int id);
	public User getUserByUsername(String username);
	public void createNewUser(User u) throws UserTakenException;
	
}
