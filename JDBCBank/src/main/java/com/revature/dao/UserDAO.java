package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDAO {
	
	public List<User> viewAllUsers(User superUser);
	public void createNewUser(User u);
	public void updateUserById(int id);
	public void deleteAllUsers();
	
}
