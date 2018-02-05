package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	public static Connection connection;
	
	public static void connectToDatabase(String fileName) throws IOException, SQLException {
		
		Properties prop = new Properties();
		InputStream in = new FileInputStream(fileName);
		prop.load(in);
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("user");
		String password = prop.getProperty("pw");
		
		connection = DriverManager.getConnection(url, username, password);
	}
	
	public static void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
