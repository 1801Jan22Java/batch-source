package com.revature.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;



public class ConnectionUtil {
	
	private static String fileName = "connection.properties";

	public static Connection getConnectionFromFile() throws SQLException, IOException{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream(fileName));
		String url = prop.getProperty("url");
		String userName = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url, userName, password);
		
	}
	
	
}
