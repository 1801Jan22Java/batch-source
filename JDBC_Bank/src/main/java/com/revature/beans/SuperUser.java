package com.revature.beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class SuperUser extends AbstractUser {
	public SuperUser() {
		super();
		verified = false;
	}
	
	static boolean verified;
	public static final String filename = "connection.properties";
	public static boolean rootLogin(String username, String password) {
		Properties prop = new Properties();
		
		try {
			InputStream in;
			in = new FileInputStream(filename);
			prop.load(in);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String rootname = prop.getProperty("superusername");
		String rootpass = prop.getProperty("superuserpassword");
		if ((username.equals(rootname)) && (password.equals(rootpass))) {
			verified = true;
			return true;
		}
		return false;
	}
	
	public static void rootLogout() {
		verified = false;
	}
}
