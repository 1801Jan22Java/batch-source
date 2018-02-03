package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao{
	
	public UserDaoImpl() {
		
	}
	
	/*
	 * Create a standard user account
	 */
	public User createUser() {
		User user = null;
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("What username would you like to use?");
			String username = sc.nextLine();
			String password, firstName, lastName;
			
			PreparedStatement pstmt = conn.prepareStatement("SELECT USERNAME FROM REGISTERED_USERS WHERE USERNAME=?");
			pstmt.setString(1,username);
			ResultSet rs = pstmt.executeQuery();
			
			//If the ResultSet contains anything, the user already exists
			while(rs.next()) {
				System.out.println("Username already exists. Please try another.");
				username = sc.nextLine();
				
				pstmt = conn.prepareStatement("SELECT USERNAME FROM REGISTERED_USERS WHERE USERNAME=?");
				pstmt.setString(1,username);
				rs = pstmt.executeQuery();
			}
			
			//Unique username was chosen
			//Ask for a password, first name and last name
			
			System.out.println("Please enter your desired password.");
			password = sc.nextLine();
			
			System.out.println("What is your first name?");
			firstName = sc.nextLine();
			
			System.out.println("What is your last name?");
			lastName = sc.nextLine();
			
			//Call the Stored Procedure: CREATE_USER
			CallableStatement cs = null;
			String sql = "{call CREATE_USER(?,?,?,?)}";
			cs = conn.prepareCall(sql);
			cs.setString(1, username);
			cs.setString(2, password);
			cs.setString(3, firstName);
			cs.setString(4, lastName);
			cs.execute();
			
			//Create a User object and return it
			pstmt = conn.prepareStatement("SELECT * FROM REGISTERED_USERS WHERE USERNAME=?");
			pstmt.setString(1,username);
			rs = pstmt.executeQuery();
			boolean isSuperUser = false;
			if(rs.getInt("IS_SUPERUSER") == 1)
				isSuperUser = true;
			user = new User(username, firstName, lastName, rs.getInt("USER_ID"), isSuperUser);
			
			sc.close();
			conn.close();

			System.out.println("Account successfully created!");

			return user;
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/*
	 * Authenticate user login
	 */
	public User logIn() {
		Scanner sc = new Scanner(System.in);
		User u = null;
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String username, password;
			
			System.out.println("Enter your username");
			username = sc.nextLine();
			System.out.println("Enter your password");
			password = sc.nextLine();
			
			boolean goodLogIn = false;
			
			while(!goodLogIn) {
				pstmt = conn.prepareStatement("SELECT * FROM REGISTERED_USERS WHERE USERNAME=?");
				pstmt.setString(1,username);
				rs = pstmt.executeQuery();
				if(rs.next() && username.equals(rs.getString("USERNAME")) && password.equals(rs.getString("PASSWORD"))) {
					
					goodLogIn = true;
					boolean isSuperUser = false;
					if(rs.getInt("IS_SUPERUSER") == 1)
						isSuperUser = true;
					u = new User(username, rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getInt("USER_ID"), isSuperUser);
					return u;
				}
				System.out.println("Invalid credentials. Please try again.");
				
				System.out.println("Enter your username");
				username = sc.nextLine();
				System.out.println("Enter your password");
				password = sc.nextLine();
			}
			
			sc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	
}
