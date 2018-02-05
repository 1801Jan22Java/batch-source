package com.revature.Week2CodeChallenge;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Driver {
	public static void main(String[] args) {
		try {
		Properties prop = new Properties();
		InputStream in = new FileInputStream("connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		Connection conn = DriverManager.getConnection(url,username,password);
		EmpDao.getAvgSalary(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
