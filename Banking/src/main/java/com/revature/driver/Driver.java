package com.revature.driver;

import com.revature.beans.User;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDaoImpl;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String response;
		User currentUser;
		UserDaoImpl udi = new UserDaoImpl(); 
		AccountDaoImpl adi = new AccountDaoImpl();
		
		//Log in or create account
		System.out.println("Hello! Would you like to CREATE a new user account or LOGIN?");
		response = sc.nextLine();
		response.toUpperCase();
		while(!response.equals("CREATE") && !response.equals("LOGIN")) {
			System.out.println("Hello, that's not a valid option! Would you like to CREATE a new user account or LOGIN?");
			response = sc.nextLine();
		}
		//If user wants to create a new user account
		if(response.equals("CREATE")) {
			currentUser = udi.createUser();
		}
		else {
			currentUser = udi.logIn();
		}
		
		do {
			System.out.println();
			System.out.println("Hello, " + currentUser.getFirstName() + "! How can I help you?");
			System.out.println("Would you like to:");
			System.out.println("CREATE a new bank account");
			System.out.println("VIEW your existing accounts");
			System.out.println("DELETE an existing account");
			System.out.println("LOGOUT");
			
			response = sc.nextLine();
			
			switch (response) {
			case "CREATE":	
			}
			
		} while(!response.equals("LOGOUT"));
	}

}
