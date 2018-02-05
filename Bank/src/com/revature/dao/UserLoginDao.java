package com.revature.dao;

import java.util.List;

import com.revature.beans.UserLogin;
import com.revature.util.IncorrectPasswordException;
import com.revature.util.InvalidUsernameException;

public interface UserLoginDao {
	public List<UserLogin> getUserLogins();
	public UserLogin getUserLoginById(int id);
	public int addLogin(UserLogin login);
	public boolean contains(String username) throws InvalidUsernameException;
	public int login(UserLogin login) throws IncorrectPasswordException;
}
