package com.revature.ccutil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection getConnection(String fileName) throws SQLException, IOException{
		Properties prop = new Properties();
		FileInputStream fIN = new FileInputStream(fileName);
		prop.load(fIN);
		String database = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(database, username, password);
	}
}
