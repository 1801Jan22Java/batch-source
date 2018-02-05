package com.revature.dao;

import com.revature.beans.User;

public interface SuperUserDao extends UserDao {
	public void viewUsers (User user) throws Exception;
	public void updateUser (User user, int userId, String username, String password) throws Exception;
	public void deleteUser (User user, int userId) throws Exception;
}
