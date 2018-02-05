package com.revature.jdbcbank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.util.Scanner;

import com.revature.Exceptions.OverdraftException;
import com.revature.beans.AccountType;
import com.revature.beans.CheckingAccount;
import com.revature.beans.SavingsAccount;
import com.revature.beans.SuperUser;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDaoImpl;


public class BankDriver {

	/*
	 * The JDBC Bank program starts from the main method.
	 * Includes a scanner to accept user input and calls the User class, the UserDaoImpl class and the 
	 * AccountDaoImpl class.  There must be an SQL connection before the class can begin.
	 * 
	 * */
	public static void main(String [] args)
	{

		/*Grabbing the connection.properties file, 
		 * from which I get the username, password, and url for the
		 * sql connection
		 */
		String filename = "connection.properties";
		ConnectionUtil cu = new ConnectionUtil();
		//try here for connection
		try {
			Connection conn = cu.getConnectionFromFile(filename);
			UserDaoImpl udi = new UserDaoImpl();
			Scanner sc = new Scanner(System.in);
			
			//Presenting initial user options here 
			System.out.println("Would you like to create an account?\n"
					+ "Enter 1 to create a user account, otherwise press 2");
			String response = sc.nextLine();
			System.out.println(response.equals("1") ||response.equals("2"));

			//Attempting to validate user response
			while(!response.equals("1") ||!response.equals("2"))
			{
				System.out.println("That input was not recognized.");
				System.out.println("Would you like to create an account?\n"
						+ "Enter 1 to create a user account, otherwise press 2");
				response = sc.nextLine();
				if(response.equals("1"))
				{
					udi.createUser();
				}
				else if(response.equals("2")){
					System.out.println("Enter your username");
					String username =sc.nextLine();
					System.out.println("Enter your password");
					String password =sc.nextLine();
					boolean validated=udi.validateCredentials(username, password);
					while(!validated)
					{
						System.out.println("That username does not exist or the password entered is incorrect.  \nPlease try again.");
						System.out.println("Enter your username");
						username =sc.nextLine();
						System.out.println("Enter your password");
						password =sc.nextLine();
						validated=udi. validateCredentials(username, password);
					}
					AccountDaoImpl adi =new AccountDaoImpl();
					User user = udi.getUserByCredentials(username, password);
					adi.showMenu(user);
				}
			}
		}
		
		//Catches, in case something goes wrong while connected to database
		//SQLConnection not available
		catch (SQLRecoverableException e)
		{
			System.out.println("Could not connect to database!");
			e.printStackTrace();
		}
		//SQLException
		catch (SQLException e) {
			e.printStackTrace();
		}
		//General IOException
		catch (IOException e) {
			e.printStackTrace();
		}



	}
}