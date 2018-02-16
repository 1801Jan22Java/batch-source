package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	// BAD WAY = tightly coupled = insecure = hard coded credentials
	// USE root/connection.properties
	public static Connection getBadConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@milliron-ers.ck97ow9hq1o2.us-east-1.rds.amazonaws.com:1521:ORCL";
		String username = "admin";
		String password = "cangetin";
		return DriverManager.getConnection(url,username,password);
	}
	// Input Stream cannot be recognized by a Dynamic Web Project
	public static Connection getConnectionFromStream(String filename) throws IOException, SQLException {
		Properties prop = new Properties(); // parses info from an input stream or resource
		// Load file from an input stream. Maven doesn't know to include it in the WAR
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url, username, password);
	}
	
	public static Connection getConnectionFromFile() throws IOException, SQLException {
		final String filename = "connection.properties";
		try {
			// Use Reflection to view resource forcing resource to be loaded into memory, available for Other resources in memory 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			//oracle.jdbc.driver.OracleDriver could not be loaded into memory.
			e.printStackTrace();
		}
		// parses info from an input stream or resource
		Properties prop = new Properties();
		
		// load file as a resource so that it is packaged by the WAR file to be used later
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream(filename));
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url, username, password);
	}
	
	
	
	
}
