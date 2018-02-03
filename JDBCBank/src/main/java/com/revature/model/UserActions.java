package com.revature.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.BankAccountDAO;
import com.revature.dao.BankAccountDAOImpl;
import com.revature.dao.SuperUserDAO;
import com.revature.dao.SuperUserDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;

public class UserActions {
	
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
						SuperUserDAO superUser = new SuperUserDAOImpl();
						User currentUser = superUser.getUserByUsername(username);
						superLoggedIn(sc, currentUser);
						System.out.println("logged in super user");
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
					// TODO Auto-generated catch block
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
    	while(keepGoing) {
    		System.out.println("What would you like to do?");
    		System.out.println("1. View Bank Account");
    		System.out.println("2. Withdraw Money");
    		System.out.println("3. Deposit Money");
    		System.out.println("4. View Transactions");
    		System.out.println("5. Delete Account");
    		System.out.println("6. Logout");
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
    			System.out.println("Logging out");
    			keepGoing = false;
    			break;
    		default:
    			System.out.println("Please enter correct option");
    			break;
    		}
    	}
	}
	
	public static void superLoggedIn(Scanner sc, User user) {
    	boolean keepGoing = true;
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
    			break;
    		case 7: 
    			System.out.println("Creating new User");
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
