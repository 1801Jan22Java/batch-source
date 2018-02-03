package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	
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
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}
	
	
	

}
