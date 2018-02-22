package com.revature.dao;

import java.util.List;

import com.revature.domain.User;

public interface UserDao {

	public List<User> getUsers();
	
	public User login(String username, String password);

	public User getUserById(int id);

	public int createUser(User u);

	public int updateUser(User u);

	public int deleteUser(User u);

}
