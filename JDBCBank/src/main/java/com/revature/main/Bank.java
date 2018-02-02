package com.revature.main;

import java.io.*;
import java.util.*;

import com.revature.beans.User;

public class Bank {
	
	private Scanner scan;
	private PrintWriter wtr;
	private User currentUser;

	public Bank(Reader rdr, Writer output) {
		scan = new Scanner(rdr);
		wtr = new PrintWriter(output);
		currentUser = null;
	}
	
	public void startBank() {

		String input = "";

		welcome();
		do {

			printMainOptionSeclect();
			input = scan.nextLine().toLowerCase();
			parseInput(input);

		} while (!input.equals("7"));

	}

	private void parseInput(String input) {

		switch (input) {
		case "1"://view
			displayAccounts();
			break;
		case "2"://create
			break;
		case "3"://delete
			break;
		case "4"://deposit
			break;
		case "5"://withdraw
			break;
		case "6"://logout
			//Sign currentUser out
			currentUser = null;
			welcome();
			break;
		case "7"://quit
			break;
		default:
			wtr.println("Unsupported Command");
			break;
		}

	}

	private void displayAccounts() {
		
		
		
	}

	private void welcome() {

		wtr.println("Welcome to the JDBC Banking App");
		String input = "";

		do {
			wtr.println("Please either 'Login' or 'Register' new account");
			input = scan.next().toLowerCase();
		} while (!input.equals("login") || !input.equals("register"));

		if (input.equals("register")) {
			// Create a user from input
		} else {
			// Login the user
			signIn();
		}
		
	}

	private void signIn() {
		String userName = "";
		String pswrd = "";
		boolean signedIn = false;
		do {
			wtr.println("Please enter user name");
			userName = scan.nextLine();
			wtr.println("Please enter password");
			pswrd = scan.nextLine();

			currentUser = new User(userName, pswrd);
			signedIn = true;

		} while (!signedIn);

	}

	private void printMainOptionSeclect() {
		wtr.println("Please select an option\n"
				+ "1. View accounts and balances."
				+ "2. Create an account."
				+ "3. Delete an account"
				+ "4. Deposit amount into account"
				+ "5. Withdraw amount from account"
				+ "6. Logout"
				+ "7. Quit");
		
	}

}
