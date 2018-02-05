package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil 
{	
	public static Connection getConnection() throws SQLException
	{
		String hostname = ""; //hostname follows the format: jdbc:oracle:thin:@<yourHostName>:1521:ORCL
		String username = "";
		String password = "";
		return DriverManager.getConnection(hostname, username, password);
	}
	
	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException
	{
		Properties property = new Properties();
		InputStream in = new FileInputStream(filename);
		property.load(in);
		String hostname = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		Connection conn = DriverManager.getConnection(hostname, username, password);
		return conn;
	}
}
