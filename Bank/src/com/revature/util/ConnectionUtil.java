package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException 
	{
		Properties prop = new Properties();									//create properties
		InputStream in = new FileInputStream(filename);						//create input stream
		prop.load(in);														//load the file
		String url = prop.getProperty("url");								//get url
		String username = prop.getProperty("username");						//get username
		String password = prop.getProperty("password");						//get password
		return DriverManager.getConnection(url,username,password);			//try to establish connection with database
	}
}
