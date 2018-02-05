package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface SuperUserDAO extends UserDAO{
	
	public List<User> viewAllUsers();
	public void updateUserById(int id, String column, String value);
	public void deleteAllUsers();

}
