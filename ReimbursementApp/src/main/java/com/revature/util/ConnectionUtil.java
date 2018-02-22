package com.revature.util;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException {
/*			It does not work. why??? 
 			Properties prop = new Properties();		// it uses connection.properties?
			
			InputStream in = new FileInputStream(filename);
			// how to load properties?
			prop.load(in);		// it loads properties
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
*/		
			String url = "jdbc:oracle:thin:@revature.crtn9o8i9z8x.us-east-1.rds.amazonaws.com:1521:ORCL";
			String username = "ginyandrew";
			String password = "MomoKiki2014";
			return DriverManager.getConnection(url, username, password);
	}
	
}
