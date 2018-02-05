package com.revature.driver;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.InvalidInputException;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String response = "";
		User currentUser;
		Account currentAccount;
		UserDaoImpl udi = new UserDaoImpl(); 
		AccountDaoImpl adi = new AccountDaoImpl();
		
		//Log in or create account
		System.out.println("Hello! Would you like to CREATE a new user account or LOGIN?");
		while(!response.equals("CREATE") && !response.equals("LOGIN")) {
			try {
				response = sc.nextLine();
				response = response.toUpperCase();
				if(!response.equals("CREATE") && !response.equals("LOGIN"))
					throw new InvalidInputException("Hello, that's not a valid option! Would you like to CREATE a new user account or LOGIN?");

			} catch (InvalidInputException i) {
				System.err.println(i);
			}
		}
		//If user wants to create a new user account
		if(response.equals("CREATE")) {
			currentUser = udi.createUser(sc);
		}
		else {
			currentUser = udi.logIn(sc);
		}
		
		do {
			sc = new Scanner(System.in);
			System.out.println();
			System.out.println("Hello, " + currentUser.getFirstName() + "! How can I help you?");
			System.out.println("Would you like to:");
			System.out.println("CREATE a new bank account");
			System.out.println("VIEW your existing accounts");
			if(currentUser.isSuperUser()) {
				System.out.println("ADMIN menu");
			}
			System.out.println("LOGOUT");
			
			response = sc.nextLine();
			
			response = response.toUpperCase();
			try {
				switch (response) {
				case "CREATE"	:	adi.createAccount(currentUser);
									break;
				case  "VIEW" 	:	adi.viewAccount(currentUser);
									break;
				case "ADMIN"	:	if(currentUser.isSuperUser())
										udi.adminMenu(currentUser);
									break;
				case "LOGOUT"	:	break;
				default		 	:	throw new InvalidInputException("Please enter an appropriate command.");
				}
			} catch (InvalidInputException i) {
				System.err.println(i);
			}
			
		} while(!response.equals("LOGOUT"));
		
		System.out.println("Logging you out now. Goodbye!");
	}

}
