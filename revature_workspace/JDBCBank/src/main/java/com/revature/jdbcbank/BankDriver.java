package com.revature.jdbcbank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import Beans.AccountType;
import Beans.CheckingAccount;
import Beans.SavingsAccount;
import Beans.SuperUser;
import Beans.User;

import com.revature.Exceptions.OverdraftException;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.util.ConnectionUtil;

public class BankDriver {

	public static void main(String [] args)
	{

		String filename = "connection.properties";
		ConnectionUtil cu = new ConnectionUtil();
		
		try {
			Connection conn = cu.getConnectionFromFile(filename);
			UserDaoImpl udi = new UserDaoImpl();
			System.out.println("Would you like to create an account?  Enter 1 to create a user account, otherwise press 2");
			Scanner sc = new Scanner(System.in);
			String response = sc.nextLine();
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
}