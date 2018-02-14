package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	// Connect to database in AWS via connection.properties file.
	public static Connection getConnectionFromFile(String filename) throws SQLException,IOException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		if(in.equals(null)) {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
		    in = loader.getResourceAsStream("/connection.properties");
		}
		// Load the connection.properties file into prop
		prop.load(in);
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		return DriverManager.getConnection(url, username, password);
	}
}
