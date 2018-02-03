package com.revature.jdbcbank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import Beans.CheckingAccount;
import Beans.SavingsAccount;
import Beans.SuperUser;
import Beans.User;

import com.revature.dao.UserDaoImpl;
import com.revature.util.ConnectionUtil;

public class BankDriver {

	public static void main(String [] args)
	{
		
		String filename = "connection.properties";
		ConnectionUtil cu = new ConnectionUtil();
		User newUser = new User("testname","testpass","Kira","Nerys","987-65-4321");
		SuperUser newSupUser = new SuperUser("testname","testpass","Benjamin","Sisko","000-00-0000");
		System.out.println(newSupUser.getLastName());
		System.out.println(newSupUser.getPassword());
		System.out.println(newSupUser.getSSN());
		System.out.println();
		System.out.println(newSupUser.getSuperUser());
		try {
			Connection conn = cu.getConnectionFromFile(filename);
			System.out.println(conn.getMetaData().getDatabaseMajorVersion());
			System.out.println(conn.getMetaData().getDatabaseProductName());
			UserDaoImpl udi = new UserDaoImpl();
			//udi.addSuperUser(newSupUser);
			newSupUser.deleteUser(1007);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		/*
		User user = new User("Omar","Mohamad","123-45-6789","newuser","newpass");
		user.logIn("newuser", "newpass");
		user.logIn("fjkdla", "fkjdlafd");
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your username and password");
		System.out.println("Enter your username:	");
		String usernomme=scan.nextLine();
		System.out.println("Enter your password:	");
		String motdepasse = scan.nextLine();
		user.logIn(usernomme, motdepasse);
		while(!user.getLoginStatus()){
			System.out.println("You must log in to access your account information");
			System.out.println("Please enter your username and password");
			System.out.println("Enter your username:	");
			usernomme= scan.nextLine();
			System.out.println("Enter your password:	");
			motdepasse=scan.nextLine();
			user.logIn(usernomme, motdepasse);
		}
		CheckingAccount testca =user.createCheckingAccount(100);
		SavingsAccount testsa = user.createSavingsAccount(100);
		testca.deposit(30);
		testsa.deposit(20);
		testca.displayBalance();
		testsa.displayBalance();
		*/
	}

}
