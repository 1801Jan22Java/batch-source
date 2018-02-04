package com.revature.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.revature.beans.TransactionType;
import com.revature.beans.User;
import com.revature.dao.BankAccountDAO;
import com.revature.dao.BankAccountDAOImpl;
import com.revature.dao.SuperUserDAO;
import com.revature.dao.SuperUserDAOImpl;
import com.revature.dao.TransactionDAO;
import com.revature.dao.TransactionDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;

public class UserActions {
	
	// The first menu that pops up when application is launched.
	// It will continuously bring back the menu as long as the app has not exited.
	// If user is trying to log in, it will first check whether or not the user is the admin(credentials in properties)
	// If so, bring up the ADMIN menu. Otherwise, normal user menu shows up.
	
	public static void mainMenu(Scanner sc) {
		boolean keepPrinting = true;
		while(keepPrinting) {
			System.out.println("Welcome to the JDBC Bank. What would you like to do today?\n 1.Login \n 2.New User \n 3.Exit.");
	    	int selectedAction = sc.nextInt();
	    	switch(selectedAction) {
	    	case 1: 
	    		System.out.println("Please Enter Your Credentials");
	    		System.out.println("Username:");
	    		String username = sc.next();
	    		System.out.println("Password:");
	    		String password = sc.next();
	    		
	    		try {
					if(CheckCredentials.checkSuperCredentials(username, password)) {
						User superUser = new User();
						System.out.println("logged in super user");
						superLoggedIn(sc, superUser);
						
					} else {
						UserDAO user = new UserDAOImpl();
						if(user.checkCredentials(username, password)) {
							User currentUser = user.getUserByUsername(username);
							System.out.println("logged into normal user");
							loggedIn(sc, currentUser);
						} else {
							System.out.println("Incorrect Credentials");
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	    		
	    		break;
	    	case 2:
	    		System.out.println("New User");
	    		break;
	    	case 3:
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
    		int optionSelected = sc.nextInt();
    		switch(optionSelected) {
    		case 1:
    			System.out.println("Viewing Bank Account");
    			System.out.println(bankAccount.viewBankAccounts(user));
    			break;
    		case 2:
    			// MAKE AN EXCEPTION IF NOT ENOUGH MONEY IN THE BANK ACCOUNT
    			System.out.println("Which account do you want to withdraw from?");
    			System.out.println(bankAccount.viewBankAccounts(user));
    			accountID = sc.nextInt();
    			System.out.println("How much money do you want to withdraw?");
    			money = sc.nextDouble();
    			bankAccount.withdrawMoneyFromAccount(accountID, money, user);
    			// When a transaction is made, store it in the table
    			transactionType.setType("withdraw");
    			newTransaction.addTransaction(user, bankAccount.viewBankAccountByID(accountID, user), transactionType, money);
    			break;
    		case 3: 
    			// Try making a custom exception for not being the right user if putting into wrong account
    			System.out.println("Which account do you want to put money into?");
    			System.out.println(bankAccount.viewBankAccounts(user));
    			accountID = sc.nextInt();
    			System.out.println("How much money do you want to deposit?");
    			money = sc.nextDouble();
    			bankAccount.depositMoneyToAccount(accountID, money, user);
    			transactionType.setType("deposit");
    			newTransaction.addTransaction(user, bankAccount.viewBankAccountByID(accountID, user), transactionType, money);
    			break;
    		case 4:
    			System.out.println("Which Account do you want to look at?");
    			System.out.println(bankAccount.viewBankAccounts(user));
    			accountID = sc.nextInt();
    			System.out.println(newTransaction.viewAllTransactions(user, accountID));
    			break;
    		case 5:
    			System.out.println("Creating an account");
    			// NEED TO MAKE IT SO THAT THEY CAN CREATE SAVINGS OR CHECKING ACCOUNT!!!!!!!!!!!!!!!!!!!!!!!!!!
    			bankAccount.createAccount("savings", user);
    			break;    			
    		case 6:
    			System.out.println("Enter the ID of the Account Being Deleted");
    			accountID = sc.nextInt();
    			bankAccount.deleteAccountById(accountID, user);
    			break;
    		case 7:
    			System.out.println("Logging out");
    			keepGoing = false;
    			break;
    		default:
    			System.out.println("Please enter correct option");
    			break;
    		}
    	}
	}
	
	// Implement superUserDAO here to perform various Admin actions.
	public static void superLoggedIn(Scanner sc, User user) {
    	boolean keepGoing = true;
    	SuperUserDAO superUser = new SuperUserDAOImpl();
    	while(keepGoing) {
    		System.out.println("Welcome Admin, what would you like to do?");
    		System.out.println("1. View Bank Account");
    		System.out.println("2. Withdraw Money");
    		System.out.println("3. Deposit Money");
    		System.out.println("4. View Transactions");
    		System.out.println("5. Delete Account");
    		System.out.println("6. View All Users");
    		System.out.println("7. Create New User");
    		System.out.println("8. Update User");
    		System.out.println("9. Delete all Users");
    		System.out.println("10. Logout");
    		int optionSelected = sc.nextInt();
    		switch(optionSelected) {
    		case 1:
    			System.out.println("Viewing Bank Account");
    			BankAccountDAO bankAccount = new BankAccountDAOImpl();
    			bankAccount.viewBankAccounts(user);
    			break;
    		case 2:
    			System.out.println("Withdraw Money");
    			break;
    		case 3: 
    			System.out.println("Deposit Money");
    			break;
    		case 4:
    			System.out.println("Viewing transactions");
    			break;
    		case 5:
    			System.out.println("Deleting Account");
    			break;
    		case 6:
    			System.out.println("Viewing all Users");
    			System.out.println(superUser.viewAllUsers());
    			break;
    		case 7: 
    			System.out.println("Creating new User");
    			superUser.createNewUser(user);
    			break;
    		case 8:
    			System.out.println("Updating user");
    			break;
    		case 9:
    			System.out.println("Deleting all Users");
    			break;
    		case 10:
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
