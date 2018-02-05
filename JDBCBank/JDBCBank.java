package com.revature.JDBCBank;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Properties;

class JDBCBank{
	
	static String loggedInUser;
	
    public static Connection getConnectionFromFile(String filename) throws IOException, SQLException {
      	 Properties prop = new Properties();
      	 InputStream in = new FileInputStream(filename);
      	 prop.load(in);   
      	 String url = prop.getProperty("url");
      	 String username = prop.getProperty("username");
      	 String password = prop.getProperty("password");      	 
      	 return DriverManager.getConnection(url, username, password);
       }
    
	void logIn(String username, String password) {
		if (loggedInUser != null) {
			System.out.println("Invalid command, other user currently logged in");
			return;
		}
		else if (! userIsRegistered(username)) {
			System.out.println("Username not currently registered");
		    System.out.println("Would you like to register this username (Y/N)");
		    Scanner sc = new Scanner(System.in);
		    while (true) {
		    	if (sc.hasNext("Y")) {
		    		registerUser(username, password);
		    		loggedInUser = username;
		    		System.out.println("Username" + username + "is now registered and logged in");
		    	}
		    	else if (sc.hasNext("N")) {
		    		System.out.println("Username" + username + "not registered. Goodbye.");
		    		return;
		    	}
		    	else {
		    		System.out.println("Invalid input, select 'Y' or 'N'");
		    		sc.reset();
		    	}
		    }
		}
	    else if ( invalidPassword(username, password)) {
	    	System.out.println("Invalid password entered");
	    	return;
		}
	    else 
	    // No user logged in, valid credentials were provided
	    	loggedInUser = username;
	}
	
	void logOut() {
		if (loggedInUser == null) {
			System.out.println("No user is currently logged in");
			return;
		}
		else
			loggedInUser = null;
	}
	
	boolean userIsRegistered(String username)
	boolean invalidPassword(String username, String password)
	boolen isSuperUser(String username)
	
	void registerUser(String username, String password)
	
	void createAccount()
	void deleteAccount() //check empty;
	void viewAccounts()
	void depositToAccount()
	void withdrawFromAccount();
	
	//super functions
	void viewUser();
	void createUser();
	void updateUser();
	void deleteUser();
}