package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil 
{	
	private static String filename = "connection.properties";
	
	public static Connection getConnection() throws SQLException
	{
		String hostname = ""; //hostname follows the format: jdbc:oracle:thin:@<yourHostName>:1521:ORCL
		String username = "";
		String password = "";
		return DriverManager.getConnection(hostname, username, password);
	}
	
	public static Connection getConnectionFromFile() throws IOException, SQLException
	{
		//If you are facing issues, check if your driver is seen by Maven
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		//Load connection credentials from file.
		Properties property = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		property.load(loader.getResourceAsStream(filename));
		
		String hostname = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		return DriverManager.getConnection(hostname, username, password);
		
	}
}
