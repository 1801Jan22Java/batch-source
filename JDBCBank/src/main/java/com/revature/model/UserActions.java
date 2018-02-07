package com.revature.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.revature.beans.TransactionType;
import com.revature.beans.User;
import com.revature.dao.BankAccountDAO;
import com.revature.dao.BankAccountDAOImpl;
import com.revature.dao.TransactionDAO;
import com.revature.dao.TransactionDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exceptions.IncorrectCredentialsException;
import com.revature.exceptions.OverdraftException;
import com.revature.exceptions.UserTakenException;


public class UserActions {
	
	// The first menu that pops up when application is launched.
	// It will continuously bring back the menu as long as the app has not exited.
	// If user is trying to log in, it will first check whether or not the user is the admin(credentials in properties)
	// If so, bring up the ADMIN menu. Otherwise, normal user menu shows up.
	
	public static void mainMenu(Scanner sc) {
		boolean keepPrinting = true;
		while(keepPrinting) {
			System.out.println("Welcome to the JDBC Bank. What would you like to do today?\n 1.Login \n 2.New User \n 3.Exit.");
	    	String selectedAction = sc.nextLine();
	    	switch(selectedAction) {
	    	case "1": 
	    		System.out.println("Please Enter Your Credentials");
	    		System.out.println("Username:");
	    		String username = sc.nextLine();
	    		System.out.println("Password:");
	    		String password = sc.nextLine();
	    		
	    		try {
					if(CheckCredentials.checkSuperCredentials(username, password)) {
						User superUser = new User();
						System.out.println("logged in super user");
						AdminActions.superLoggedIn(sc, superUser);
					} else {
						UserDAO user = new UserDAOImpl();
						try {
							if(user.checkCredentials(username, password)) {
								User currentUser = user.getUserByUsername(username);
								System.out.println("logged into normal user");
								loggedIn(sc, currentUser);
							} 
						} catch (IncorrectCredentialsException e) {
							System.out.println(e.getMessage());
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	    		
	    		break;
	    	case "2":
	    		System.out.println("Registering new User");
    			User newUser = new User();
    			System.out.println("Enter the username: ");
    			newUser.setUsername(sc.nextLine());
    			System.out.println("Enter the password: ");
    			newUser.setPassword(sc.nextLine());
    			UserDAO user = new UserDAOImpl();
    			try {
					user.createNewUser(newUser);
				} catch (UserTakenException e) {
					System.out.println(e.getMessage());
				}
    			break;
	    	case "3":
	    		System.out.println("Exiting");
	    		keepPrinting = false;
	    		break;
	    	default:
	    		System.out.println("Please enter a correct value");
	    		break;
	    	}
		}
		
	}

	public static void loggedIn(Scanner sc, User user) {
    	// Should implement Transaction and BankAccountDAO here.
    	boolean keepGoing = true;
    	BankAccountDAO bankAccount = new BankAccountDAOImpl();
    	TransactionDAO newTransaction = new TransactionDAOImpl();
    	TransactionType transactionType = new TransactionType();
    	int accountID;
    	double money;
    	while(keepGoing) {
    		System.out.println("What would you like to do?");
    		System.out.println("1. View Bank Accounts");
    		System.out.println("2. Withdraw Money");
    		System.out.println("3. Deposit Money");
    		System.out.println("4. View Transactions");
    		System.out.println("5. Create An Account");
    		System.out.println("6. Delete Account");
    		System.out.println("7. Logout");
    		String optionSelected = sc.nextLine();
    		switch(optionSelected) {
    		case "1":
    			System.out.println("Viewing Bank Account");
    			System.out.println(bankAccount.viewBankAccounts(user));
    			break;
    		case "2":
    			// MAKE AN EXCEPTION IF NOT ENOUGH MONEY IN THE BANK ACCOUNT
    			System.out.println("Which account do you want to withdraw from?");
    			System.out.println(bankAccount.viewBankAccounts(user));
    			accountID = sc.nextInt();
    			sc.nextLine();
    			System.out.println("How much money do you want to withdraw?");
    			money = sc.nextDouble();
    			sc.nextLine();
    			try {
    				bankAccount.withdrawMoneyFromAccount(accountID, money, user);
        			transactionType.setType("withdraw");
        			newTransaction.addTransaction(user, bankAccount.viewBankAccountByID(accountID, user), transactionType, money);
    			} catch (OverdraftException e) {
    				System.out.println(e.getMessage());
    			}
				
    			break;
    		case "3": 
    			// Try making a custom exception for not being the right user if putting into wrong account
    			System.out.println("Which account do you want to put money into?");
    			System.out.println(bankAccount.viewBankAccounts(user));
    			accountID = sc.nextInt();
    			sc.nextLine();
    			System.out.println("How much money do you want to deposit?");
    			money = sc.nextDouble();
    			sc.nextLine();
    			bankAccount.depositMoneyToAccount(accountID, money, user);
    			transactionType.setType("deposit");
    			newTransaction.addTransaction(user, bankAccount.viewBankAccountByID(accountID, user), transactionType, money);
    			break;
    		case "4":
    			System.out.println("Which Account do you want to look at?");
    			System.out.println(bankAccount.viewBankAccounts(user));
    			accountID = sc.nextInt();
    			sc.nextLine();
    			System.out.println(newTransaction.viewAllTransactions(user, accountID));
    			break;
    		case "5":
    			System.out.println("Would you like to create a Savings or Checking account?");
    			String accountType = sc.nextLine();   			
    			bankAccount.createAccount(accountType, user);
    			break;    			
    		case "6":
    			System.out.println("Enter the ID of the Account Being Deleted");
    			accountID = sc.nextInt();
    			sc.nextLine();
    			bankAccount.deleteAccountById(accountID, user);
    			break;
    		case "7":
    			System.out.println("Logging out");
    			keepGoing = false;
    			break;
    		default:
    			System.out.println("Please enter correct option");
    			break;
    		}
    	}
	}
}
