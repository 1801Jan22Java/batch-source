package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.util.*;
import com.revature.beans.*;
import com.revature.dao.*;

public class Driver {

	//Not much in main
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		userLogin(sc);
			
	}
	
	//User can either login with valid username and password or create a new account
	public static void userLogin(Scanner scan)
	{
		
		Scanner sc = scan;
		String userAccount;
		String userPassword;
		String userFName;
		String userLName;
		int userType;
		Users user = new Users();
		UsersDao ud = new UsersDaoImpl();
		AccountsNav accNav = new AccountsNav();
		
		
		boolean userLoggedIn = false;
		
		while (!userLoggedIn)
		{
			System.out.println("Welcome to Max Rev Bank!");
			System.out.println("Please enter your account name or type 'new' to create a new account.");
			String tempUserAccount = sc.nextLine();
			//New user account creation
			if (tempUserAccount.equals("new"))
			{
				userAccount = accountCreation(sc, tempUserAccount);
				if (userAccount != null)
				{
					userPassword = passwordCreation(scan);
					if (userPassword != null)
					{
						user = userInfoCreation(sc, userAccount, userPassword);
						if (user != null)
						{
							System.out.println("Account created and logged in.");
							userLoggedIn = true;
						}
						else
							System.out.println("No account created.");
					}
					else
						System.out.println("No account created.");
				}
				else
					System.out.println("No account created.");
			}
			//If not a new user account login
			else 
			{
				user = ud.getUserByAccount(tempUserAccount);
				if (user != null)
				{
					System.out.println("Please enter your account password or type 'back' to go back.");
					userPassword = sc.nextLine();
					if ((ud.checkPassword(userPassword)!= null)&&ud.checkPassword(userPassword).equals(tempUserAccount))
					{
						System.out.println("Logged into account " + tempUserAccount);
						userLoggedIn = true;
					}
					else 
					{
						System.out.println("Sorry the password did not match the account.  Please try again.");
						user = null;
					}
				}
				else 
				{
					System.out.println("Sorry the account does not exist.  Please try again.");
				}
			}
			
		}
		accNav.menuing(user, sc);
		
	}
	
	//Allows the user to start creating an account if available
	public static String accountCreation(Scanner scan, String userAcc)
	{
		boolean userBack = false;
		Scanner sc = scan;
		String userAccount = userAcc;
		Users users;
		UsersDao ud = new UsersDaoImpl();
	
		System.out.println("Please enter an account name with a minimum length of 5 characters or type 'back' to go back.");
		
			while (!userBack)
			{
				userAccount = sc.nextLine();
				userAccount.toLowerCase(); 
				if (userAccount.equals("back"))
				{
					userBack = true;
					userAccount = null;
					break;
				}
				else if (userAccount.length() < 5)
				{
					System.out.println("Sorry this account name is too short.  Please try again or type 'back' to go back.");	
				}
				else
				{
					users = ud.getUserByAccount(userAccount);
					
					if (users != null)
					{
						System.out.println("Sorry this account name already exists.  Please try again or type 'back' to go back.");				
					}
					else
					{
						return userAccount;
					}
				}
				
			}
			
			
	
		return userAccount;
	}
	
	//Allows the user to create a password for a new account
	public static String passwordCreation(Scanner scan)
	{
		boolean userBack = false;
		Scanner sc = scan;
		String userPassword;

		System.out.println("This account name is available.");
		System.out.println("Please enter an account password with a minimum length of 5 characters or type 'back' to go back.");
		
		while (!userBack)
		{
			userPassword = sc.nextLine();
			userPassword.toLowerCase(); 
			if (userPassword.equals("back"))
			{
				userBack = true;
				userPassword = null;
				break;
			}
			else if (userPassword.length() < 5)
			{
				System.out.println("Sorry this account password is too short.  Please try again or type 'back' to go back.");	
			}
			else
			{
				return userPassword;
			}
			
		}
		
		
		return null;
	}
	
	//Used to finish the account creation process
	public static Users userInfoCreation(Scanner scan, String uA, String uP)
	{
		Scanner sc = scan;
		String userFName;
		String userLName;
	
		UsersDao ud = new UsersDaoImpl();
		
		System.out.println("Type in your first name or type 'back' to cancel account creation.");
		
		
		userFName = sc.nextLine();
		if (userFName.equals("back")||userFName.length()<1)
		{
			return null;
		}

		else
		{
			System.out.println("Type in your last name or type 'back' to cancel account creation.");
			userLName = sc.nextLine();
			{
				if (userLName.equals("back")||userLName.length()<1)
				{
					return null;
				}
				else 
				{
					int userType = 2;
					ud.createUser(uA, userFName, userLName, uP, userType);
					Users user = ud.getUserByAccount(uA);
					return user;
				}
			}
		}
			
	}


}
