package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletConfig;

public class ConnectionUtil {
	
	private static String filename = "connection.properties";
	

	
	//THIS IS BAD
	//not secure, tightly coupled. credentials in source code is not good.
	public static Connection getConnection() throws SQLException {
		String url = "";
		String username = "";
		String password = "";
		return DriverManager.getConnection(url,username,password);
	}
	
	//better way
	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException {
		Properties prop = new Properties();
		// Make sure driver is being seen by maven
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream(filename));
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}
}
