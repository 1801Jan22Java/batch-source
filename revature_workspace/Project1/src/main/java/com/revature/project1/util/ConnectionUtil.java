package com.revature.project1.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionUtil {
	private static String filename="connection.properties";

	public static Connection getConnection() throws SQLException
	{
		String url="";
		String username="";
		String password = "";
		return DriverManager.getConnection(url,username,password);
	}
	
	public static Connection getConnectionFromFile() throws IOException, SQLException
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream(filename));
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password=  prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
		
	}

}
