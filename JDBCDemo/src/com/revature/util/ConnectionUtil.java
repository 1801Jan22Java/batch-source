package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	//We need to provide credentials and a host name
	//THIS IS BAD
	//You cannot change it, and everyone can see your password
	//Credentials are HARDCODED in your source code
	//Tightly coupled and not secure.
	public static Connection getConnection() throws SQLException {
		String url = "";	//To your endpoint. Host name with stuff at the end.
		String username = "";
		String password = "";
		return DriverManager.getConnection(url, username, password);
	}
	
	//Better way
	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);	//Pass in your InputStream object
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		return DriverManager.getConnection(url, username, password);
	}
}































