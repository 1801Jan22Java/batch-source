package com.revature.dao;

import java.util.List;

import com.revature.beans.UserLogin;

public interface UserLoginDao {
	public List<UserLogin> getUserLogins();
	public UserLogin getUserLoginById(int id);
	public int addLogin(UserLogin login);
	public boolean contains(String username);
	public boolean login(String username, String password);
}
