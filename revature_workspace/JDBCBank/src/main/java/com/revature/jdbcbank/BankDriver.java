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
		User newUser = new User("testname2","testpass","Julian","Bashir","100-00-0000");
		SuperUser newSupUser = new SuperUser("testname","testpass","Benjamin","Sisko","000-00-0000");
		System.out.println(newSupUser.getLastName());
		System.out.println(newSupUser.getPassword());
		System.out.println(newSupUser.getSSN());
		System.out.println();
		System.out.println(newSupUser.getSuperUser());
		try {
			Connection conn = cu.getConnectionFromFile(filename);
			UserDaoImpl udi = new UserDaoImpl();
			Scanner sc = new Scanner(System.in);
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
			System.out.println("Please make a selection:\n 1: View balance \n2: Make deposit\n3: Make withdrawal\n4:Close account");
			int option = sc.nextInt();
			adi.selectAction(option, user);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
}