package com.revature.dao;

import java.util.List;

import com.revature.beans.User;
import com.revature.beans.UserType;

public interface UserDao 
{
	List<User> getUsers();
	
	User getUserById(int id);
	
	void createUser(User user);
	
	void deleteUser(User user);
	
	void updateUser(User user, String firstName, String lastName, String username, String password, UserType userType);
}
