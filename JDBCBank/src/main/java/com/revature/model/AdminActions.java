package com.revature.model;

import java.util.Scanner;

import com.revature.beans.TransactionType;
import com.revature.beans.User;
import com.revature.dao.BankAccountDAO;
import com.revature.dao.BankAccountDAOImpl;
import com.revature.dao.SuperUserDAO;
import com.revature.dao.SuperUserDAOImpl;
import com.revature.dao.TransactionDAO;
import com.revature.dao.TransactionDAOImpl;
import com.revature.exceptions.OverdraftException;
import com.revature.exceptions.UserTakenException;

public class AdminActions {
	
	// Implement superUserDAO here to perform various Admin actions.
	// Menu is pretty long.
	public static void superLoggedIn(Scanner sc, User user) {
		boolean keepGoing = true;
		BankAccountDAO bankAccount = new BankAccountDAOImpl();
    	TransactionDAO newTransaction = new TransactionDAOImpl();
    	SuperUserDAO superUser = new SuperUserDAOImpl();
    	TransactionType transactionType = new TransactionType();
    	int accountID;
    	double money;
    	while(keepGoing) {
    		System.out.println("Welcome Admin, what would you like to do?");
    		System.out.println("1. View Bank Account");
    		System.out.println("2. Withdraw Money");
    		System.out.println("3. Deposit Money");
    		System.out.println("4. View Transactions");
    		System.out.println("5. Create An Account");
    		System.out.println("6. Delete Account");
    		System.out.println("7. View All Users");
    		System.out.println("8. Create New User");
    		System.out.println("9. Update User");
    		System.out.println("10. Delete all Users");
    		System.out.println("11. Logout");
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
					// TODO Auto-generated catch block
					e.printStackTrace();
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
    			// Delete an Account that has a 0 balance
    			System.out.println("Enter the ID of the Account Being Deleted");
    			accountID = sc.nextInt();
    			sc.nextLine();
				bankAccount.deleteAccountById(accountID, user);
    			break;
    		case "7":
    			// View the Users table
    			System.out.println("Viewing all Users");
    			System.out.println(superUser.viewAllUsers());
    			break;
    		case "8": 
    			// Creating a new user
    			System.out.println("Creating new User");
    			User newUser = new User();
    			System.out.println("Enter the username: ");
    			newUser.setUsername(sc.nextLine());
    			System.out.println("Enter the password: ");
    			newUser.setPassword(sc.nextLine());
    			try {
					superUser.createNewUser(newUser);
				} catch (UserTakenException e) {
					System.out.println(e.getMessage());
				}
    			break;
    		case "9":
    			// Update a user information
    			// Call another function that determines what column to update
    			System.out.println("Updating user");
    			updateExistingUser(sc);
    			break;
    		case "10":
    			System.out.println("Deleting all Users");
    			superUser.deleteAllUsers();
    			break;
    		case "11":
    			System.out.println("Logging out");
    			keepGoing = false;
    			break;
    		default:
    			System.out.println("Please enter correct option");
    			break;
    		}
    	}
	}
	
	public static void updateExistingUser(Scanner sc) {
		boolean keepGoing = true;
		SuperUserDAO superUser = new SuperUserDAOImpl();
		String value;
		while(keepGoing) {
			System.out.println("Which user would you like to update?");
			System.out.println(superUser.viewAllUsers());
			int updateUserId = sc.nextInt();
			sc.nextLine();
			System.out.println("What would you like to update?");
			System.out.println("1. Username");
			System.out.println("2. Password");
			System.out.println("3. Go back to Super User menu.");
			String optionSelected = sc.nextLine();
			switch(optionSelected) {
			case "1":
				System.out.println("Updating username for " + superUser.getUserById(updateUserId).getUsername());
				System.out.println("What would you like to change the username to?");
				value = sc.nextLine();
				superUser.updateUserById(updateUserId, "USERNAME", value);
				break;
			case "2":
				System.out.println("Updating password for " + superUser.getUserById(updateUserId).getUsername());
				System.out.println("What would you like to change the password to?");
				value = sc.nextLine();
				superUser.updateUserById(updateUserId, "PASSWORD", value);
				break;
			case "3":
				System.out.println("Going back to Admin menu");
				keepGoing = false;
				break;
			default:
				System.out.println("Please enter a correct option");
				break;
			}
		}
	}

}
