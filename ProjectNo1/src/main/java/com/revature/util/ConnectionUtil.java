package com.revature.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionUtil {
	
	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException {
		try {
            // Use Reflection to view resource forcing resource to be loaded into memory, available for Other resources in memory 
            // Maven dependencies only maps available resources, but doesn't load them automatically
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            //oracle.jdbc.driver.OracleDriver could not be loaded into memory.
            e.printStackTrace();
        }
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,  username,  password);
	}

}
