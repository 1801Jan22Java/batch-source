package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {

		
		//needed for inputs and outputs
		Scanner sc = new Scanner(System.in);
		userLogin(sc);
		/*
		Connection con = null;
		
		try {
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			System.out.println(con.getMetaData().getDriverName());
		} catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		
		
		

	}
	
	
	public static void userLogin(Scanner scan)
	{
		
		Scanner sc = scan;
		String userAccount;
		String userPassword;
		String userFName;
		String userLName;
		boolean userType;
		
		boolean userLoggedIn = false;
		
		while (!userLoggedIn)
		{
			System.out.println("Welcome to Max Rev Bank!");
			System.out.println("Please enter your account name or type 'new' to create a new account.");
			userAccount = sc.nextLine();
			userAccount.toLowerCase();
			if (userAccount.equals("new"))
			{
				System.out.println("Please enter an account name with a minimum length of 5 characters.");
				userAccount = sc.nextLine();
				userAccount.toLowerCase();
				//if ()
			}
		}
	}
	


}
