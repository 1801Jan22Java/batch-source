package com.revature.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

import com.revature.beans.User;

public class ConnectionUtil {
	public static void getConnection(String filename, User user) throws Exception {
		// reads in connection details from bank.properties
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		// if user is superUser, sets flag for such in User class
		if ((user.getUsername() == username) || (user.getPassword() == password)) {
			user.setUserID(1);
		}
		// creates connection and sets to instance connection variable
		user.setConn(DriverManager.getConnection(url,username,password));
	}
}
