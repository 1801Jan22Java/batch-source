package com.revature.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.exceptions.InvalidAccountIDException;
import com.revature.exceptions.InvalidInputException;
import com.revature.exceptions.InvalidPasswordException;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao{
	
	public UserDaoImpl() {
		
	}
	
	/*
	 * Create a standard user account
	 */
	public User createUser(Scanner sc) {
		User user = null;
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			
			System.out.println();
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
			
			rs.next();
			if(rs.getInt("IS_SUPERUSER") == 1)
				isSuperUser = true;
			user = new User(username, firstName, lastName, rs.getInt("USER_ID"), isSuperUser);
			
			conn.close();

			System.out.println();
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
	public User logIn(Scanner sc) {
		User u = null;
		
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String username, password;
			
			System.out.println();
			System.out.println("Enter your username");
			username = sc.nextLine();
			System.out.println("Enter your password");
			password = sc.nextLine();
			
			boolean goodLogIn = false;
			
			
			while(!goodLogIn) {

				Properties prop = new Properties();
				InputStream in = new FileInputStream("super.properties");
				while(username.equals("super")) {
					try {
						prop.load(in);
						if(!password.equals(prop.getProperty("password"))) {
							System.out.println(prop.getProperty("password"));
							throw new InvalidPasswordException("That's not the super password!");
						}
						else {
							u  = new User(username, "Master", "Splinter", 9001, true);
							return u;
						}
					} catch (InvalidPasswordException i) {
						System.err.println(i);
						System.out.println();
						System.out.println("Enter your password");
						password = sc.nextLine();
					}
				}
				
				pstmt = conn.prepareStatement("SELECT * FROM REGISTERED_USERS WHERE USERNAME=?");
				pstmt.setString(1,username);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					try {
						if(username.equals(rs.getString("USERNAME")) && password.equals(rs.getString("PASS"))) {
							
							goodLogIn = true;
							boolean isSuperUser = false;
							if(rs.getInt("IS_SUPERUSER") == 1)
								isSuperUser = true;
							u = new User(username, rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getInt("USER_ID"), isSuperUser);
							return u;
						}
						else
							throw new InvalidPasswordException("Invalid credentials. Please try again.");
					} catch (InvalidPasswordException ipe) {
						System.err.println(ipe);
					}
				}
				System.out.println();
				System.out.println("Enter your username");
				username = sc.nextLine();
				System.out.println("Enter your password");
				password = sc.nextLine();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return u;
	}

	/*
	 * ADMIN MENU (for SUPER users)
	 */
	
	public void adminMenu(User u) {
		String response;
		Scanner sc = new Scanner(System.in);
		AccountDaoImpl adi = new AccountDaoImpl();
		UserDaoImpl udi = new UserDaoImpl();
		System.out.println("Hello Super user! Please enter the appropriate command.");
		System.out.println("VIEW - View user information");
		System.out.println("CREATE - Create new user");
		System.out.println("UPDATE - Update existing user");
		System.out.println("DELETE - Delete an existing user");
		
		try {
			
			response = sc.nextLine();
			response = response.toUpperCase();
			
			switch (response) {
			case "VIEW"		:	udi.superView(sc);
								break;
			case "CREATE"	:	udi.createUser(sc);
								break;
			case "UPDATE"	:	udi.superUpdate(sc);
								break;
			case "DELETE"	:	udi.superDelete(sc);
								break;
			default			:	throw new InvalidInputException("Please enter an appropriate command.");
			}
		} catch (InvalidInputException i) {
			System.err.println(i);
		}
	}
	
	
	/*
	 * SUPER METHODS
	 */
	
	public boolean superView(Scanner sc){
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				System.out.println("Enter the first name of the user you'd like to view.");
				String firstName = sc.nextLine();
				
				pstmt = conn.prepareStatement("SELECT * FROM REGISTERED_USERS WHERE FIRSTNAME=?");
				pstmt.setString(1,firstName);
				rs = pstmt.executeQuery();
				
				System.out.println();
				System.out.println("Matching users: ");
				
				boolean userExists = false;
				while(rs.next()) {
					userExists = true;
					System.out.println();
					System.out.println("User ID : " + rs.getInt("USER_ID"));
					System.out.println("Username: " + rs.getString("USERNAME"));
					System.out.println("Password: " + rs.getString("PASS"));
					System.out.println("Name	: " + rs.getString("LASTNAME") + ", " + rs.getString("FIRSTNAME"));
				}
				
				if(!userExists) {
					throw new InvalidInputException("No users by that name!");
				}
				
				System.out.println();
				
				try {
					System.out.println("Enter the ID of the user whose accounts you want to view.");
					int userID = sc.nextInt();
					sc.nextLine();
					
					pstmt = conn.prepareStatement("SELECT * FROM ACCOUNTS WHERE USER_ID=?");
					pstmt.setInt(1,userID);
					rs = pstmt.executeQuery();
					
					boolean accsExist = false;
					
					System.out.println("Accounts belonging to " + firstName);
					while(rs.next()) {
						accsExist = true;
						System.out.println();
						System.out.println("Bank Account ID: " + rs.getInt("BANK_ACCOUNT_ID"));
						System.out.println("Balance		   : $" + rs.getDouble("BALANCE"));
					}
					
					if(!accsExist) {
						throw new InvalidAccountIDException("User with that ID has no accounts!");
					}
					return accsExist;
				} catch (InvalidAccountIDException i) {
					System.err.println(i);
					return false;
				}
			} catch (InvalidInputException i) {
				System.err.println(i);
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}
	
	public User superUpdate(Scanner sc) {
		User u = new User("","","",-1,false);
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				System.out.println("Enter the first name of the user you'd like to view.");
				String firstName = sc.nextLine();
				
				pstmt = conn.prepareStatement("SELECT * FROM REGISTERED_USERS WHERE FIRSTNAME=?");
				pstmt.setString(1,firstName);
				rs = pstmt.executeQuery();
				
				System.out.println();
				System.out.println("Matching users: ");
				
				boolean userExists = false;
				while(rs.next()) {
					userExists = true;
					System.out.println();
					System.out.println("User ID : " + rs.getInt("USER_ID"));
					System.out.println("Username: " + rs.getString("USERNAME"));
					System.out.println("Password: " + rs.getString("PASS"));
					System.out.println("Name	: " + rs.getString("LASTNAME") + ", " + rs.getString("FIRSTNAME"));
				}
				
				if(!userExists) {
					throw new InvalidInputException("No users by that name!");
				}
				
				System.out.println();
				
				try {
					System.out.println("Enter the ID of the user you want to update.");
					int userID = sc.nextInt();
					sc.nextLine();
					
					pstmt = conn.prepareStatement("SELECT * FROM REGISTERED_USERS WHERE USER_ID=?");
					pstmt.setInt(1,userID);
					rs = pstmt.executeQuery();
					
					if(!rs.next()) {
						throw new InvalidAccountIDException("No user exists with that ID!");
					}
					
					try {
						System.out.println("What would you like to update? (PASS, FIRSTNAME or LASTNAME)");
						String response = sc.nextLine();
						response = response.toUpperCase();
						response = response.replaceAll("\\s", "");
						
						if(!response.equals("PASS") && !response.equals("FIRSTNAME") && !response.equals("LASTNAME")) {
							throw new InvalidInputException("This isn't a valid option! Be sure to enter the appropriate input.");
						}
						
						System.out.println("Enter the new value: ");
						String newValue = sc.nextLine();
						
						pstmt = conn.prepareStatement("UPDATE REGISTERED_USERS SET " + response + "=? WHERE USER_ID=?");
						pstmt.setString(1, newValue);
						pstmt.setInt(2, userID);
						pstmt.executeUpdate();
						
						pstmt = conn.prepareStatement("SELECT * FROM REGISTERED_USERS WHERE USER_ID=?");
						pstmt.setInt(1, userID);
						rs = pstmt.executeQuery();
						rs.next();
						
						boolean isSuper;
						if( rs.getInt("IS_SUPERUSER") == 1)
							isSuper = true;
						else
							isSuper = false;
						u = new User(rs.getString("USERNAME"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getInt("USER_ID"), isSuper);
						
						System.out.println("User successfully updated!");
					} catch (InvalidInputException i) {
						System.err.println(i);
					}
					
				} catch (InvalidAccountIDException i) {
					System.err.println(i);
					u.setUserId(-2);
				}
			} catch (InvalidInputException i) {
				System.err.println(i);
				u.setUserId(-3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	public int superDelete(Scanner sc) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				System.out.println("Enter the first name of the user you'd like to delete.");
				String firstName = sc.nextLine();
				
				pstmt = conn.prepareStatement("SELECT * FROM REGISTERED_USERS WHERE FIRSTNAME=?");
				pstmt.setString(1,firstName);
				rs = pstmt.executeQuery();
				
				System.out.println();
				System.out.println("Matching users: ");
				
				boolean userExists = false;
				while(rs.next()) {
					userExists = true;
					System.out.println();
					System.out.println("User ID : " + rs.getInt("USER_ID"));
					System.out.println("Username: " + rs.getString("USERNAME"));
					System.out.println("Password: " + rs.getString("PASS"));
					System.out.println("Name	: " + rs.getString("LASTNAME") + ", " + rs.getString("FIRSTNAME"));
				}
				
				if(!userExists) {
					throw new InvalidInputException("No users by that name!");
				}
				
				System.out.println();
				
				System.out.println("Enter the ID of the user you want to delete.");
				int userID = sc.nextInt();
				sc.nextLine();
				
				pstmt = conn.prepareStatement("SELECT * FROM ACCOUNTS WHERE USER_ID=?");
				pstmt.setInt(1,userID);
				rs = pstmt.executeQuery();
				
				int currBankAccID;
				
				boolean accsExist = false;;
				
				System.out.println("Accounts belonging to " + firstName + ": ");
				while(rs.next()) {
					accsExist = true;
					System.out.println();
					System.out.println("Bank Account ID: " + rs.getInt("BANK_ACCOUNT_ID"));
					currBankAccID = rs.getInt("BANK_ACCOUNT_ID");
					System.out.println("Balance		   : $" + rs.getDouble("BALANCE"));
					
					pstmt = conn.prepareStatement("DELETE FROM ACCOUNTS WHERE BANK_ACCOUNT_ID=?");
					pstmt.setInt(1, currBankAccID);
					pstmt.executeUpdate();
				}
				
				if(!accsExist) {
					throw new InvalidAccountIDException("No user exists with that ID!");
				}
				
				pstmt = conn.prepareStatement("DELETE FROM REGISTERED_USERS WHERE USER_ID=?");
				pstmt.setInt(1, userID);
				pstmt.executeUpdate();
				
				System.out.println("User " + firstName + " with ID " + userID + " successfully deleted!");
				System.out.println("All accounts belonging to " + firstName + " were also deleted.");
				
				return userID;
					
			} catch (InvalidInputException i) {
				System.err.println(i);
				return -1;
			} catch (InvalidAccountIDException e) {
				// TODO Auto-generated catch block
				System.err.println(e);
				return -2;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return -2;
	}
}
