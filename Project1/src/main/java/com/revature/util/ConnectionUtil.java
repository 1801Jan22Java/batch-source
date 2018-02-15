package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	// Connect to database in AWS via connection.properties file.
	public static Connection getConnectionFromFile(String filename) throws SQLException, IOException {
		Properties prop = new Properties();

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
		return DriverManager.getConnection(url, username, password);
		// Load the connection.properties file into prop

		// InputStream in = new FileInputStream(filename);
		// prop.load(in);
		//
		// String url = prop.getProperty("url");
		// String username = prop.getProperty("username");
		// String password = prop.getProperty("password");
		//
		// return DriverManager.getConnection(url, username, password);
	}
}
