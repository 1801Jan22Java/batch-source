package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	public static final String PROPERTIES_FILE = "Connection.properties";
	
	public static Connection connectToDatabase(String fileName) throws IOException, SQLException {
		
		//Ensure JDBC driver is seen
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream(fileName));
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("user");
		String password = prop.getProperty("pw");
		
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void disconnect(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
