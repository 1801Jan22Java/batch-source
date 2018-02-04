package com.revature.dao;

import java.util.List;

import com.revature.beans.User;
import com.revature.util.UsernameTakenException;

public interface UserDao {
	public User login(String username, String password);
	public void updateUser(User user, String username, String password);
	public void deleteUser(User user);
	public boolean isUsernameTaken(String name) throws UsernameTakenException;
	public User register(String username, String password);
	public List<User> getAllUsers();
}
