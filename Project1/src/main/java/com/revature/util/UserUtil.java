package com.revature.util;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserOracle;

public class UserUtil {
	private UserDAO ud = new UserOracle();

	public boolean login(String username, String password) {
		User user = ud.getUser(username, password);
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}

	public User getUser(String username, String password) {
		User user = ud.getUser(username, password);
		return user;
	}
}
