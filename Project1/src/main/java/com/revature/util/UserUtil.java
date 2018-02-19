package com.revature.util;

import java.util.List;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserOracle;

public class UserUtil {
	private UserDAO ud = new UserOracle();

	public boolean login(String username, String password) {
		User user = ud.getUser(username);
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}

	public User getUser(String username) {
		User user = ud.getUser(username);
		return user;
	}

	public boolean updateUser(int user_id, String firstname, String lastname, String password) {
		return ud.editInfo(user_id, firstname, lastname, password);
	}
	
	public List<User> getAllUsers(){
		return ud.getAllEmployees();
	}
}
