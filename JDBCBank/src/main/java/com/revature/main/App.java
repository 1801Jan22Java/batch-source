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
		
		boolean n = true;
		String username = null;
		String password = null;
		Customer currCustomer = null;
		
		do {
			Scanner input = new Scanner(System.in);
	
			System.out.println("Set your username: ");
			username = input.nextLine();
			System.out.println("Set your password: ");
			password = input.nextLine();
			
			currCustomer = new Customer(username, password);
			
			CustomerDAO custDao = new CustomerDAOImpl();
			
			AccountDAO custAccountDao = new AccountDAOImpl();
			
//			String checkCustomer = "";
			Customer tempCustomer = custDao.getCustByUsername(username);
//			checkCustomer += .getUsername();
			if(tempCustomer != null) { 
				System.out.println("This account already exist");
			}
			else {
				System.out.println("before add bank");
				// add bankAccount to DB.
				double amount = 0;
				System.out.println("Enter amount to start: ");
				amount = input.nextDouble();
				custAccountDao.addAccount(amount);
				System.out.println("passed add bank");
				// add user to DB.
				custDao.createNewCustomer(username, password);
				System.out.println("User created!");
				// get account info.
				
				// close the Scanner.
				input.close();
				n = false;
			}
		} while(n == true);
		
	}

	private static void login() {
		
		String username = null;
		String password = null;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter username: ");
		username = input.nextLine();
		System.out.println("Enter password: ");
		password = input.nextLine();
		
		CustomerDAO currCustomer = new CustomerDAOImpl();
		int custSuperStatus = currCustomer.getSuperStatus(username);
//		System.out.println(custSuperStatus);
		
		if(custSuperStatus == 1) { //check if user isSuper
//			superMenu();
		}
		else {
			String passInDB = currCustomer.validatePassword(username); //gets the password from DB to check if match
			if(!password.equals(passInDB)) {
				System.out.println("Password is incorrect!");
			}
			else {
				System.out.println("Logged in");
				normalMenu(username, password);
			}
		}

	}
	
	public static void normalMenu(String username, String password) {
		
		boolean m = true;
		do {
			System.out.println("Would you like to: \n" 
					+ " 1.) View your account \n"
					+ " 2.) Deposit \n"
					+ " 3.) Withdraw \n"
					+ " 4.) Delete your account \n"
					+ " 5.) exit \n");
			Scanner input = new Scanner(System.in);
			int n = input.nextInt();
			switch (n) {
			case 1:
				CustomerDAO currCustomerDAO = new CustomerDAOImpl();
				Customer currCustomer = currCustomerDAO.getCustByUsername(username);
				Account currAccount = new Account();
				currAccount = currCustomer.getAccount();
				System.out.println("User ID: " + currCustomer.getUserId() + " Account ID: " 
						+ currAccount.getAccountId() + " Balance: " + currAccount.getBalance());
				break;
			case 2:
				// depositMoney();
				break;
			case 3: 
				// withdrawMoney();
				break;
			case 4: 
				// deleteMyAccount();
				break;
			case 5:
				m = false;
				break;
			default:
				System.out.println("Error: invalid input");
				System.exit(1);
			}
		} while (m);
	}
	
	public static void superMenu() {
		System.out.println("Super user menu");
		//viewAccounts()
		//updateAccount()
		//deleteAllUsers()
	}
}
