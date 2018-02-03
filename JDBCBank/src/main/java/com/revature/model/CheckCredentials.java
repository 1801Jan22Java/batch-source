package com.revature.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CheckCredentials {
	
	public static boolean checkSuperCredentials(String userUsername, String userPassword) throws FileNotFoundException {
		boolean isSuper = false;
		Properties prop = new Properties();
		InputStream in = new FileInputStream("connection.properties");
		try {
			prop.load(in);
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			if(username.equals(userUsername) && password.equals(password)) {
				isSuper = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isSuper;
	}
}
