package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties prop = new Properties();
		try(InputStream inStream = loader.getResourceAsStream(filename))
		{
			prop.load(inStream);
		}
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		return DriverManager.getConnection(url, username, password);
	}
}
