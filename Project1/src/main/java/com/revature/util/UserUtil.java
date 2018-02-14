package com.revature.util;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserOracle;

public class UserUtil {
	private UserDAO ud = new UserOracle();
	
	public boolean login(String username, String password) {
		User user = ud.getUser(username, password);
		if(user.getFirstname()==username && user.getPassword() == password) {
			return true;
		}
		
		return false;
	}
	
	
}
