package com.revature.main;

import java.io.*;
import java.util.*;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.exceptions.NegativeAmountException;
import com.revature.exceptions.OverdraftException;
import com.revature.exceptions.WrongUsernameOrPasswordException;

public class Bank {

	private Scanner scan;
	private PrintWriter wtr;
	private User currentUser;
	private BankDTO bdto;

	public Bank(Reader rdr, Writer output, BankDTO bdto) {
		scan = new Scanner(rdr);
		wtr = new PrintWriter(output);
		currentUser = null;
		this.bdto = bdto;
	}

	/*
	 * Holds the main controlling loop for the entire app
	 */
	public void startBank() {

		String input = "";

		welcome();
		// if they do not want to sign in
		if (currentUser != null) {
			do {
				// Checking to see if the user that signed in is a super user
				if (!currentUser.isSuperUser()) {
					printMainOptionSeclect();
					do {
						input = scan.nextLine().toLowerCase();
					} while (input.isEmpty());
					parseInputNormalUser(input);
				} else {
					printSuperUserSelect();
					do {
						input = scan.nextLine().toLowerCase();
					} while (input.isEmpty());
					parseInputSuperUser(input);
				}

			} while (!input.equals("7") && currentUser != null);
		}
		exit();

	}

	/*
	 * Responsible for figuring out what the super user typed in
	 */
	private void parseInputSuperUser(String input) {

		switch (input) {
		case "1":// view users
			getUsers();
			break;
		case "2":// create user
			createUser();
			break;
		case "3":// delete user
			deleteUser();
			break;
		case "4":// update user
			updateUser();
			break;
		case "5":// logout
			// Sign currentUser out
			currentUser = null;
			welcome();
			break;
		case "6":// quit
			break;
		default:
			wtr.println("Unsupported Command\n");
			wtr.flush();
			break;
		}

	}

	/*
	 * Can change the first name, last name, and password of a given user's id
	 */
	private void updateUser() {

		int userId;
		String fName;
		String lName;
		String password;

		wtr.println("Enter id of user to update.");
		wtr.flush();
		userId = scan.nextInt();
		wtr.println("Enter new first name");
		wtr.flush();
		fName = scan.nextLine();
		wtr.println("Enter new last name");
		wtr.flush();
		lName = scan.nextLine();
		wtr.println("Enter new password");
		wtr.flush();
		password = scan.nextLine();

		User user = new User(userId, fName, lName, null, password, false, null);

		bdto.updateUser(user);
		wtr.println("User updated\n");
		wtr.flush();

	}

	/*
	 * Given an id deletes the user
	 */
	private void deleteUser() {
		int userId;

		wtr.println("Enter id of user to delete.");
		wtr.flush();
		userId = scan.nextInt();
		bdto.deleteUser(userId);
		wtr.println("User deleted\n");
		wtr.flush();
	}

	/*
	 * Gets and prints all the users that are in the bank including super users
	 */
	private void getUsers() {
		List<User> users = bdto.getUsers();

		wtr.println("Current Users\n" + "(id / First Name / Last Name / Username / Password)");
		wtr.flush();
		for (User user : users) {
			wtr.println(user.toString());
			wtr.flush();
		}

	}

	/*
	 * prints the menu a super user has to select from
	 */
	private void printSuperUserSelect() {
		wtr.println("Please select an option\n" + "1. View Users\n" + "2. Create user\n" + "3. Delete user\n"
				+ "4. Update user\n" + "5. Logout\n" + "6. Quit\n");
		wtr.flush();

	}

	/*
	 * Parses the input given by a normal user
	 */
	private void parseInputNormalUser(String input) {

		switch (input) {
		case "1":// view
			displayAccounts();
			break;
		case "2":// create
			createAccount();
			break;
		case "3":// delete
			deleteAccount();
			break;
		case "4":// deposit
			depositAmount();
			break;
		case "5":// withdraw
			withdrawAmount();
			break;
		case "6":// logout
			// Sign currentUser out
			currentUser = null;
			welcome();
			break;
		case "7":// quit
			break;
		default:
			wtr.println("Unsupported Command\n");
			wtr.flush();
			break;
		}

	}

	/*
	 * Asks for an account id and an amount to withdraw from that account
	 */
	private void withdrawAmount() {

		int acctId;
		int amt;

		do {
			wtr.println("Please provide an account number.");
			wtr.flush();
			acctId = scan.nextInt();
			wtr.println("Please provide an amount to withdraw.");
			wtr.flush();
			amt = scan.nextInt();
		} while (!checkAccount(acctId));
		try {
			bdto.withdrawAmount(acctId, amt);
			wtr.println("Withdrew " + amt + " from account " + acctId);
			wtr.flush();
		} catch (NegativeAmountException e) {
			wtr.println(e.getMessage());
			wtr.flush();
		} catch (OverdraftException e) {
			wtr.println(e.getMessage());
			wtr.flush();
		}
		currentUser = bdto.getUser(currentUser.getId());

	}

	/*
	 * Asks for an account id and an amount to deposit in that account
	 */
	private void depositAmount() {
		int acctId;
		int amt;

		do {
			wtr.println("Please provide an account number.");
			wtr.flush();
			acctId = scan.nextInt();
			wtr.println("Please provide an amount to deposit.");
			wtr.flush();
			amt = scan.nextInt();
		} while (!checkAccount(acctId));
		try {
			bdto.depositAmount(acctId, amt);
			wtr.println("Deposited " + amt + " into account " + acctId);
			wtr.flush();
		} catch (NegativeAmountException e) {
			wtr.println(e.getMessage());
			wtr.flush();
		}
		currentUser = bdto.getUser(currentUser.getId());
	}

	/*
	 * Checks to see if the current user owns the given account
	 */
	private boolean checkAccount(int acctId) {

		for (Account acct : currentUser.getAccounts()) {

			if (acct.getId() == acctId) {
				return true;
			}

		}
		return false;
	}

	/*
	 * Gets the number to an account the user owns and deletes it
	 */
	private void deleteAccount() {
		int acctId = 0;
		do {
			wtr.println("Please provide the Account Number you wish to delete.");
			wtr.flush();
			acctId = scan.nextInt();
		} while (!checkAccount(acctId));

		bdto.deleteAccount(acctId);
		currentUser = bdto.getUser(currentUser.getId());
		wtr.println("Account Deleted\n");
		wtr.flush();

	}

	/*
	 * Gets a name for the account and starting amount from the user to create an
	 * account
	 */
	private void createAccount() {
		String acctName = "";
		int startBalance = 0;
		Account acct;

		wtr.println("Please provide an account name.");
		wtr.flush();
		acctName = scan.nextLine();
		wtr.println("Please provide a beginning balance.");
		wtr.flush();
		startBalance = scan.nextInt();

		acct = new Account(acctName, startBalance);

		bdto.createAccount(acct, currentUser.getId());
		currentUser = bdto.getUser(currentUser.getId());
		wtr.println("Account created\n");
		wtr.flush();

	}

	/*
	 * Displays all the accounts of the current user
	 */
	private void displayAccounts() {
		wtr.println("Here are your accounts:\n" + "   (Number / Name / Balance)");
		wtr.flush();
		for (Account acct : currentUser.getAccounts()) {
			wtr.println("    " + acct.toString());
			wtr.flush();
		}
		wtr.println();
		wtr.flush();
	}

	/*
	 * prints the welcoming message and obtains from the user whether or not they
	 * want to log in
	 */
	private void welcome() {

		wtr.println("Welcome to the JDBC Banking App");
		wtr.flush();
		String input = "";

		do {
			wtr.println("Please either 'Login' or 'Register' new account");
			wtr.flush();
			input = scan.nextLine().toLowerCase();
		} while (!input.equals("login") && !input.equals("register") && !input.equals("quit") && !input.equals("q"));

		if (input.equals("register")) {
			createUser();
		} else if (input.equals("login")) {
			// Login the user
			signIn();
		}

	}

	/*
	 * Gets a first name, last name, username, and password from the user
	 */
	private void createUser() {
		String firstName;
		String lastName;
		String userName;
		String password;

		wtr.println("Enter first name");
		wtr.flush();
		firstName = scan.nextLine();
		wtr.println("Enter last name");
		wtr.flush();
		lastName = scan.nextLine();
		wtr.println("Enter user name");
		wtr.flush();
		userName = scan.nextLine();
		while (!bdto.checkUsername(userName)) {
			wtr.println("That username is taken, enter another one.");
			wtr.flush();
			userName = scan.nextLine();
		}
		wtr.println("Enter password");
		wtr.flush();
		password = scan.nextLine();

		User user = new User(firstName, lastName, userName, password, false, new ArrayList<Account>());
		if (currentUser != null && currentUser.isSuperUser()) {
			bdto.createUser(user);
			wtr.println("User Created\n");
			wtr.flush();
		} else {
			currentUser = bdto.createUser(user);
		}

	}

	/*
	 * prints farewell message
	 */
	private void exit() {
		wtr.println("Good Bye\n");
		wtr.flush();

	}

	/*
	 * gets a user name and password from the user and attempts to sign in
	 */
	private void signIn() {
		String userName = "";
		String pswrd = "";
		boolean signedIn = false;
		do {
			wtr.println("Please enter user name");
			wtr.flush();
			userName = scan.nextLine();
			wtr.println("Please enter password");
			wtr.flush();
			pswrd = scan.nextLine();

			try {
				currentUser = bdto.signIn(userName, pswrd);
			} catch (WrongUsernameOrPasswordException e) {
				wtr.println(e.getMessage());
				wtr.flush();
				currentUser = null;
			}

			if (currentUser != null) {
				signedIn = true;
			}

		} while (!signedIn);

	}

	/*
	 * Prints out the optins for a normal user
	 */
	private void printMainOptionSeclect() {
		wtr.println("Please select an option\n" + "1. View accounts and balances.\n" + "2. Create an account.\n"
				+ "3. Delete an account\n" + "4. Deposit amount into account\n" + "5. Withdraw amount from account\n"
				+ "6. Logout\n" + "7. Quit");
		wtr.flush();
		scan.reset();

	}

}
