package com.revature.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.util.IllegalAmountException;
import com.revature.util.IllegalDeleteException;
import com.revature.util.IllegalPasswordException;
import com.revature.util.IllegalUsernameException;
import com.revature.util.IllegalWithdrawException;
import com.revature.util.IncorrectCredentialsException;

public class BankManager {
	
	User user;
	User chosenUser;
	Account acc;
	UserDaoImpl udi;
	AccountDaoImpl adi;
	boolean superUser;
	Scanner sc;
	
	private static String filename = "connection.properties";
	
	public BankManager() {
		this.user = null;
		this.chosenUser = null;
		this.acc = null;
		this.udi = new UserDaoImpl();
		this.adi = new AccountDaoImpl();
		this.superUser = false;
	}
	
	public void init() {
		sc = new Scanner(System.in);
		
		this.welcomeMessage();
		
		this.commenceBusiness();
		
		sc.close();
	}
	
	private void welcomeMessage() {
		System.out.println();
		System.out.println("Welcome to Revature Bank!");
		System.out.println();
	}
	
	private void displayStartMenu() {
		System.out.println();
		System.out.println("Please type a number corresponding to what you  would like to do:");
		System.out.println("1- Login to your user account.");
		System.out.println("2- Create a new user account.");
		System.out.println("3- Exit app.");
		System.out.println();
	}
	
	private void commenceBusiness() {
		while (true) {
			this.displayStartMenu();
			
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					this.loginProcess();
					break;
				case 2:
					this.createUser();
					System.out.println("Login with an account? Y/N");
					String choice2 = sc.next().toLowerCase();
					if (!choice2.equals("y")) {
						goodByeMessage();
						System.exit(0);
					}
					this.loginProcess();
					break;
				case 3:
					goodByeMessage();
					System.exit(0);
				default:
					System.out.println("Invalid choice!");
					break;
			}
		}
	}
	
	private void loginProcess() {
		this.login();
		if (superUser) {
			superUserMainMenu();
		} else {
			regularUserMenu();
		}
	}
	
	private void login() {
		boolean success = false;
		
		while(!success) {
			System.out.println();
			System.out.println("Type username:");
			String username = sc.next();
			System.out.println("Type password: ");
			String password = sc.next();
			System.out.println();
			
			try {
				user = udi.login(username, password);
				Properties prop = new Properties();
				InputStream in = new FileInputStream(filename);
				prop.load(in);
				String supername = prop.getProperty("superusername");
				if (supername.equals(user.getUsername())) {
					superUser = true;
				}
				success = true;
			} catch (IncorrectCredentialsException e) {
				System.out.println("Incorrect username or password!");
				System.out.println("Would you like to try again? Y/N");
				String choice = sc.next().toLowerCase();
				if (!choice.equals("y")) {
					goodByeMessage();
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println();
		System.out.println("Welcome, " + user.getFirstName() + " " + user.getLastName());
		System.out.println();
	}
	
	private void regularUserMenu() {
		while (true) {
			System.out.println();
			System.out.println("Please choose an action: ");
			System.out.println();
			this.commonChoices();
			System.out.println("3- Log out.");
			System.out.println();
			
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					checkAccounts();
					break;
				case 2:
					createAccount();
					break;
				case 3:
					this.goodByeMessage();
					System.exit(0);
				default:
					System.out.println("Invalid choice!");
			}
		}
	}
	
	private void superUserMainMenu() {
		while (true) {
			System.out.println();
			System.out.println("As the super user, choose an action: ");
			System.out.println();
			this.commonChoices();
			System.out.println("3- View all users.");
			System.out.println("4- Create a user.");
			System.out.println("5- Log out.");
			System.out.println();
			
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					checkAccounts();
					break;
				case 2:
					createAccount();
					break;
				case 3:
					checkUsers();
					break;
				case 4:
					createUser();
					break;
				case 5:
					this.goodByeMessage();
					System.exit(0);
				default:
					System.out.println("Invalid choice!");
			}
		}
	}
	
	private void checkUsers() {
		while (true) {
			List<User> users = udi.superGetUsers();
			
			System.out.println();
			System.out.println("Here are all users: ");
			System.out.println();
			for (User u : users) {
				System.out.println();
				System.out.println("View this user? \"" + u.getFirstName() + " " + u.getLastName() + "\" Y/N");
				System.out.println();
				String choice = sc.next().toLowerCase();
				if (choice.equals("y")) {
					this.chosenUser = u;
					break;
				}
			}
			
			if (this.chosenUser == null) {
				System.out.println();
				System.out.println("No user chosen. Go to previous menu? Y/N");
				System.out.println();
				String choice = sc.next().toLowerCase();
				if (choice.equals("y")) {
					return;
				}
			} else {
				userOptions();
			}
		}
	}
	
	private void userOptions() {
		while (true) {
			System.out.println();
			System.out.println("Examining " + this.chosenUser.getFirstName() + " " + this.chosenUser.getLastName() + ".");
			System.out.println("Please choose an option: ");
			System.out.println("1- Edit user.");
			System.out.println("2- Delete user.");
			System.out.println("3- Log out");
			System.out.println("4- Back to previous menu.");
			System.out.println();
			
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					this.editUser();
					break;
				case 2:
					this.deleteUser();
					return;
				case 3:
					this.goodByeMessage();
					break;
				case 4:
					this.chosenUser = null;
					return;
				default:
					System.out.println("Invalid option!");
					
			}
		}
	}
	
	private void editUser() {
		if (this.chosenUser.equals(this.user)) {
			System.out.println("Cannot edit super user!");
			return;
		}
		
		System.out.println();
		System.out.println("Type username");
		String username = sc.next();
		System.out.println("Type password (Must be at least 8 characters long)");
		String password = sc.next();
		System.out.println("Type first name");
		String fname = sc.next();
		System.out.println("Type last name");
		String lname = sc.next();
		System.out.println();
		
		try {
			System.out.println();
			User newUser = new User(this.chosenUser.getuserId(), username, password, fname, lname);
			udi.superChangeUser(newUser);
			this.chosenUser = newUser;
			System.out.println("User updated.");
			System.out.println();
		} catch (IllegalUsernameException e) {
			System.out.println();
			System.out.println("Username aleady exists!");
			System.out.println();
		} catch (IllegalPasswordException e) {
			System.out.println();
			System.out.println("Invalid password!");
			System.out.println();
		}
	}
	
	private void deleteUser() {

		if (this.chosenUser.equals(this.user)) {
			System.out.println("Cannot delete super user!");
			this.chosenUser = null;
			return;
		}
		
		System.out.println();
		System.out.println("Are you sure you want to delete this user? Y/N");
		String choice = sc.next().toLowerCase();
		
		if (choice.equals("y")) {
			for (Account a : udi.getAccountsById(chosenUser.getuserId())) {
				try {
					// Setting balance to zero
					adi.withdraw(a.getAccId(), a.getBalance());
				} catch (IllegalWithdrawException | IllegalAmountException e) {
					e.printStackTrace();
				}
				try {
					adi.delete(a.getAccId());
				} catch (IllegalDeleteException e) {
					e.printStackTrace();
				}
			}
			udi.superDeleteUser(chosenUser);
			this.chosenUser = null;
			System.out.println();
			System.out.println("User deleted.");
			System.out.println();
		}
		System.out.println();
	}

	private void createUser() {
		System.out.println();
		System.out.println("Type username");
		String username = sc.next();
		System.out.println("Type password (Must be at least 8 characters long)");
		String password = sc.next();
		System.out.println("Type first name");
		String fname = sc.next();
		System.out.println("Type last name");
		String lname = sc.next();
		System.out.println();
		
		try {
			System.out.println();
			User newUser = new User(username, password, fname, lname);
			udi.createUser(newUser);
			System.out.println("User created.");
			System.out.println();
		} catch (IllegalUsernameException e) {
			System.out.println();
			System.out.println("Username aleady exists!");
			System.out.println();
		} catch (IllegalPasswordException e) {
			System.out.println();
			System.out.println("Invalid password!");
			System.out.println();
		}
	}
	
	private void checkAccounts() {
		while (true) {
			List<Account> accounts = adi.getUserAccounts(user.getuserId());
			
			if (accounts.isEmpty()) {
				System.out.println();
				System.out.println("You do not have any accounts! Create one? Y/N");
				System.out.println();
				String choice = sc.next().toLowerCase();
				if (choice.equals("y")) {
					createAccount();
					continue;
				} else {
					return;
				}
			}
			

			System.out.println();
			System.out.println("Here are your accounts: ");
			System.out.println();
			for (Account a : accounts) {
				System.out.println();
				System.out.println("View this account? \"" + a.getAccName() + "\" Y/N");
				System.out.println();
				String choice = sc.next().toLowerCase();
				if (choice.equals("y")) {
					this.acc = a;
					break;
				}
			}
			
			if (this.acc == null) {
				System.out.println();
				System.out.println("No account chosen. Go to previous menu? Y/N");
				System.out.println();
				String choice = sc.next().toLowerCase();
				if (choice.equals("y")) {
					return;
				}
			} else {
				accountOptions();
			}
		}
	}
	
	private void createAccount() {
		System.out.println();
		System.out.println("Name your account");
		String accName = sc.next();
		System.out.println();
		adi.createAccount(new Account(user.getuserId(), 0.0, accName));
		System.out.println("Account created!");
		System.out.println();
	}
	
	private void accountOptions() {
		while (true) {
			System.out.println();
			System.out.println("You have $" + acc.getBalance() + " in you account.");
			System.out.println("Please choose an option: ");
			System.out.println("1- Deposit into account.");
			System.out.println("2- Withdraw from account.");
			System.out.println("3- Delete account. (Account must have $0.0 balance)");
			System.out.println("4- Log out");
			System.out.println("5- Back to previous menu.");
			System.out.println();
			
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					this.deposit();
					break;
				case 2:
					this.withdraw();
					break;
				case 3:
					this.deleteAccount();
					return;
				case 4:
					this.goodByeMessage();
					break;
				case 5:
					this.acc = null;
					return;
				default:
					System.out.println("Invalid option!");
					
			}
		}
	}
	
	private void deposit() {
		System.out.println("How much would you like to deposit?");
		
		double choice = sc.nextDouble();
		
		try {
			adi.deposit(acc.getAccId(), choice);
			acc = adi.getAccountById(acc.getAccId());
			System.out.println("Success!");
		} catch (IllegalAmountException e) {
			System.out.println("Cannot deposit a negative number!");
		}
	}
	
	private void withdraw() {
		System.out.println("How much would you like to withdraw?");
		
		double choice = sc.nextDouble();
		
		try {
			adi.withdraw(acc.getAccId(), choice);
			acc = adi.getAccountById(acc.getAccId());
			System.out.println("Success!");
		} catch (IllegalWithdrawException e) {
			System.out.println("Cannot withdraw more than the amount already in account.");
		} catch (IllegalAmountException e) {
			System.out.println("Cannot withdraw a negative number!");
		}
	}
	
	private void deleteAccount() {
		System.out.println();
		System.out.println("Are you sure you want to delete this account? Y/N");
		
		String choice = sc.next().toLowerCase();
		
		if (choice.equals("y")) {
			try {
				adi.delete(acc.getAccId());
				System.out.println();
				System.out.println("Account deleted.");
				acc = null;
				System.out.println();
			} catch (IllegalDeleteException e) {
				System.out.println();
				System.out.println("Error! Account not empty. Cannot delete.");
				System.out.println();
			}
		}
		System.out.println();
	}
	
	private void commonChoices() {
		System.out.println("1- Check one of your accounts.");
		System.out.println("2- Create a bank account.");
	}
	
	private void goodByeMessage() {
		System.out.println("Thank you for your business with Revature Bank.");
		System.out.println("Have a great day!");
	}
	
}
