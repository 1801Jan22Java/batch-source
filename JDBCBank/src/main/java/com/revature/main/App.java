package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.beans.Account;
import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDAOImpl;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.util.ConnectionUtil;

public class App {

	public static void main(String[] args) {
		
		AccountDAO each = new AccountDAOImpl();
		Account currentAccount = each.getByAccountId(14);
		System.out.println("account #:" + currentAccount.getAccountId() + " Balance: " + currentAccount.getBalance());
		 
		do {
			System.out.println("Would you like to: \n" 
					+ " 1.) Create an account \n"
					+ " 2.) Login \n"
					+ " 3.) Exit \n");
			Scanner input = new Scanner(System.in);
			int n = input.nextInt();
			switch (n) {
			case 1:
				createAccount();
				break;
			case 2:
				login();
				break;
			case 3:
				System.exit(1);
				break;
			default:
				System.out.println("Error: invalid input");
				System.exit(1);
			}
		} while (true);
		

	}

	private static void createAccount() {
		
		String username;
		String password;
		Scanner input = new Scanner(System.in);

		System.out.println("Set your username: ");
		username = input.nextLine();
		System.out.println("Set your password: ");
		password = input.nextLine();
		
		Customer currCustomer = new Customer(username, password);
		CustomerDAO custDao = new CustomerDAOImpl();
//		if() { // check if user exist
//			System.out.println("This account already exist");
//		}
//		else {
//			// add user to DB.
//		}
//		
//		/*System.out.println("Your username:" + username + "your password: " + password 
//				+ "keep it somewhere safe! \n");*/
	}

	private static void login() {
//		
//		String username;
//		String password;
//		
//		if() { //check if user isSuper
//			//go to superMenu()
//		}
//		else {
//			//go to normalMenu()
//		}
//
	}
}
