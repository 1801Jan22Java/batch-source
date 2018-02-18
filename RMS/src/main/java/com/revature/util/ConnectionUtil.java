package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection getConnection() throws Exception{
	Properties prop = new Properties();
    	try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
    	} catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
    	ClassLoader loader = Thread.currentThread().getContextClassLoader();

    	prop.load(loader.getResourceAsStream("connection.properties"));

    	String url = prop.getProperty("url");
    	String username = prop.getProperty("username");
    	String password = prop.getProperty("password");
    	return DriverManager.getConnection(url, username, password);
	}
}
