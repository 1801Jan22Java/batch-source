package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDAO {

	public User createUser(User user);

	public List<User> getUsers();

	public User getUserById(int userId);

	public void deleteUser(User user);

	public User signIn(String userName, String password);

	public void updateUser(User user);

	public User getUserByUsername(String username);

}
