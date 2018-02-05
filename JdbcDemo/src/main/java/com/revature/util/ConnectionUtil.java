package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	// BAD WAY = tightly coupled = insecure = hard coded credentials
	// USE root/connection.properties
	public static Connection getBadConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@milliron-demo.ck97ow9hq1o2.us-east-1.rds.amazonaws.com:1521:ORCL";
		String username = "admin";
		String password = "cangetin";
		return DriverManager.getConnection(url,username,password);
	}
	
	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException {
		Properties prop = new Properties(); // parses info from an input stream
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url, username, password);
	}
}
