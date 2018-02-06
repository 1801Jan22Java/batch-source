package com.revature.jdbcbacnk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/*
public class BankConnection {
	//String filename = "connection.properties";
	
	//Scanner kb = new Scanner(System.in);
	
	//System.out.println("Welcome to JDBC Bank Account!");

	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	System.out.println("Enter your username ");
	String username = kb.next();
	System.out.println("Enter your password ");
	String password = kb.next();
	String url = "jdbc:microsoft:sqlserver://localhost:1433"+";databaseName=JDBC Bank Assignment";
	Connection con = DriverManager.getConnection(url, username, password);
	Statement s1 = con.createStatement();
	ResultSet rs = s1.executeQuery("SELECT * FROM USERS");
	while(rs.next()) {
		int id = rs.getInt("USER_ID");
		String name = rs.getString("USERNAME");
		String password1 = rs.getString("PASSWORD");	
	}
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
}
*/	

