package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection getConnectionFromFile(String filename) throws SQLException, IOException {

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties prop = new Properties();
		InputStream resourceStream = loader.getResourceAsStream(filename);
		try  {
			prop.load(resourceStream);
		}catch(Exception e) {
			e.printStackTrace();
		}
			
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			return DriverManager.getConnection(url, username, password);

		

	}
}
