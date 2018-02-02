package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	// THIS IS BAD
	// Credentials are hard coded into source code wth
	// Insecure, tightly coupled
//	public static Connection getConnection() throws SQLException {
//		// We'll need credentials and host
//		String url = "jdbc:oracle:thin:@kudodemo.crokjrgwcsld.us-east-1.rds.amazonaws.com:1521:ORCL";
//		String username = "sungkwonkudo";
//		String password = "";
//
//		return DriverManager.getConnection(url, username, password);
//
//	}
	
	// Better way
	public static Connection getConnectionFromFile(String filename) throws SQLException,IOException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		
		// Load the connection.properties file into prop
		prop.load(in);
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		return DriverManager.getConnection(url, username, password);
	}
}
