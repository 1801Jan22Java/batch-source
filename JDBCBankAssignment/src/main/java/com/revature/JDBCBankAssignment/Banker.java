package com.revature.JDBCBankAssignment;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.TransactionDao;
import com.revature.dao.TransactionDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.util.BankOfDoge;
import com.revature.util.ConnectionUtil;
import com.revature.util.OverdraftException;
import com.revature.util.UsernameTakenException;

public class Banker {

	Scanner inputScan;
	
	public Banker() {
		//Init scanner to get user input
		inputScan = new Scanner(System.in);
	}
	
	public boolean init() {
		//Connect to database, do not continue with program if unable to do so
        try {
        	System.out.println("Connecting to banking server...");
			ConnectionUtil.connectToDatabase("Connection.Properties");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to connect to database!");
			return false;
		}
        
        System.out.println("Connection to bank servers success!");
        return true;
	}
	
	public void run() {
		
		userLoop();
		
		ConnectionUtil.disconnect();
	}
	
	//Root control of user input
	private void userLoop() {
		homeScreen();
	}
	
	//Here user can login, register, or exit
	private void homeScreen() {
		System.out.println("----------------------------------");
		BankOfDoge.getDoge();
		boolean exit = false;
		
		while(!exit) {
			switch(getUserChoice("Login[1], Register[2], Exit[3]", 1 , 3)){
			case 1:
				login();
				break;
			case 2:
				register();
				break;
			default:
			case 3:
				System.out.println("Exiting...");
				BankOfDoge.getDoge();
				exit = true;
				
			}
		}
	}
	
	//User is logging in
	private void login() {
		
		String username = getUserString("Enter username: ", 5, 20);
		String password = getUserString("Enter password: ", 5, 20);
		
		UserDao dao = new UserDaoImpl();
		User user = dao.login(username, password);
		
		if(user != null) {
			System.out.println("Success!");
			loggedIn(user);
		}
		else
			System.out.println("Invalid login credentials!");
	}
	
	private void loggedIn(User user) {
		
		boolean exit = false;
		
		while(!exit) {
			System.out.println("Retrieving accounts...");
			
			AccountDao dao = new AccountDaoImpl();
			List<Account> accounts = dao.getAccounts(user);
			
			System.out.println("Logged in as: " + user.getUsername());
			
			if(accounts.size() > 0) {
				String userPrompt = "Select an account:\n";
				for(int i = 0; i < accounts.size(); i++) {
					userPrompt += accounts.get(i).getAccountName() + "(" + accounts.get(i).getBalance() + " DOGE)[" + (i+1) + "]\n";
				}
				userPrompt += "New Account["+ (accounts.size()+1) + "]\n";
				userPrompt += "Exit["+ (accounts.size()+2) + "]\n";
				
				//Give user an additional option for super user menu if user is a super user
				if(user.isSuperUser())
					userPrompt += "Superuser Menu ["+ (accounts.size()+3) + "]";
				
				int selection = getUserChoice(userPrompt, 1, accounts.size()+(user.isSuperUser() ? 3 : 2));
				
				if(selection == accounts.size()+1 ) {
					createAccount(user);
				}
				else if(selection == accounts.size()+2)
					return;
				else if(user.isSuperUser() && selection == accounts.size()+3) {
					superMenu(user);
				}
				else {
					enterAccount(user, accounts.get(selection - 1));
				}
				
			}
			else{//No accounts exist
				String prompt = "No accounts exist choose action: Create Account[1] Logout[2]";
						
				//Give user an additional option for super user menu if user is a super user
				if(user.isSuperUser())
					prompt += " Superuser Menu [3]";
				
				switch(getUserChoice(prompt, 1, user.isSuperUser() ? 3 : 2)) {
				case 1:
					createAccount(user);
					break;
				case 3:
					superMenu(user);
					break;
					
					default:
					case 2:
						return;
				}
			}
			
		}
		
	}
	
	private void superMenu(User user) {
		//A superuser can view, create, update, and delete all users.

		boolean exit = false;
		
		while(!exit) {
			
			UserDao dao = new UserDaoImpl();
			List<User> users = dao.getAllUsers();
			
			String userPrompt = "Select a user: ";
			for(int i = 0; i < users.size(); i++) {
				userPrompt += users.get(i).getUsername() + "[" + (i+1) + "] ";
			}
			
			userPrompt += "Create User[" +  (users.size()+1) + "] ";
			userPrompt += "Exit[" +  (users.size()+2) + "]";
			
			int selection = getUserChoice(userPrompt, 1, users.size()+2);
			
			if(selection == users.size()+1) {
				register();
			}
			else if(selection == users.size()+2) {
				exit = true;
			}
			else {
				superMenuSelectedUser(users.get(selection - 1));
			}
			
		}
	}
	
	private void superMenuSelectedUser(User selected) {
		//A superuser can view, create, update, and delete all users.
		boolean exit = false;
		
		while(!exit) {
			switch(getUserChoice("Update[1] Delete[2] Back[3]", 1, 3)) {
			case 1:
				updateUser(selected);
				break;
				
			case 2:
				UserDao dao = new UserDaoImpl();
				dao.deleteUser(selected);
				default:
				case 3:
					exit = true;
			}
		}
		
	}
	
	private void updateUser(User user) {
		UserDao dao = new UserDaoImpl();
		String username;
		
		boolean usernameTaken = false;
		do {
			username = getUserString("Enter username: ", 5, 20);
			
			try {
				usernameTaken = dao.isUsernameTaken(username);
			} catch (UsernameTakenException e) {
				e.printStackTrace();
				System.out.println("Username is taken!");
			}
			if(usernameTaken)
				System.out.println("Username is taken!");
		}while(usernameTaken);
		
		String password = getUserString("Enter password: ", 5, 20);
		
		dao.updateUser(user, username, password);
	}
	
	private void enterAccount(User user, Account account) {
		boolean exit = false;
		
		while(!exit) {
			switch(getUserChoice("In account: " + account.getAccountName() + "(" + account.getBalance() + " DOGE) as "
					+ user.getUsername() + "\nDeposit[1] Withdraw[2] Transactions[3] Delete[4] Back[5]", 1, 4)) {
			case 1:
				deposit(user, account);
				break;
				
			case 2:
				withdraw(user, account);
				break;
				
			case 3:
				TransactionDao tdao = new TransactionDaoImpl();
				tdao.getAccountTransactions(account);
				break;
				
			case 4:
				if(account.getBalance() == 0) {
					AccountDao dao = new AccountDaoImpl();
					dao.deleteAccount(account);
					exit = true;
				}
				else
					System.out.println("Account balance must be 0 to delete the account!");
				break;
				
			default:
			case 5:
				exit = true;
				
			}
		}
	}
	
	private void deposit(User user, Account account) {
		float amount = getUserFloat("Account " + account.getAccountName() + " has a balance of " + account.getBalance() + "\nHow much would you like to deposit?",
				1, Float.MAX_VALUE);
		
		AccountDao dao = new AccountDaoImpl();
		dao.deposit(user,  account,  amount);
	}
	
	private void withdraw(User user, Account account) {
		
		float amount = getUserFloat("Account " + account.getAccountName() + " has a balance of " + account.getBalance() + "\nHow much would you like to withdraw?",
				0, account.getBalance());

		AccountDao dao = new AccountDaoImpl();
		
		try {
			dao.withdraw(user,  account,  amount);
		} catch (OverdraftException e) {
			System.out.println("Error:  Not enough funds in account!");
			e.printStackTrace();
		}
	}
	
	private void createAccount(User user) {
		String accountName = getUserString("Enter account name: ", 5, 20);
		
		AccountDao dao = new AccountDaoImpl();
		dao.createAccount(user, accountName);
	}
	
	//User is registering an account
	private void register() {
		
		UserDao dao = new UserDaoImpl();
		String username;
		
		boolean usernameTaken = false;
		do {
			username = getUserString("Enter username: ", 5, 20);
			
			try {
				usernameTaken = dao.isUsernameTaken(username);
			} catch (UsernameTakenException e) {
				e.printStackTrace();
				System.out.println("Username is taken!");
			}
			if(usernameTaken)
				System.out.println("Username is taken!");
		}while(usernameTaken);
		
		String password = getUserString("Enter password: ", 5, 20);
		
		dao.register(username, password);
	}
	
	//Propts users to select from a list of options
	private int getUserChoice(String prompt, int lowChoice, int highChoice) {
		
		int choice = -1;
		String input;
		
		//Input validation loops
		while(choice < lowChoice || choice > highChoice) {
			//Prompt user for input
			System.out.println(prompt);
			
			input = inputScan.nextLine();
			
			try {
			choice = Integer.parseInt(input);
			}catch(NumberFormatException e) {
				choice = -1;
			}
			
			if(choice < lowChoice || choice > highChoice) System.out.println("Invalid option!");
		}
		
		return choice;
	}
	
	private String getUserString(String prompt, int minLength, int maxLength) {
		
		String input = "";
		while(input.length() < minLength || input.length() > maxLength) {
			
			System.out.println(prompt);
			
			input = inputScan.nextLine();
			
			if(input.length() < minLength || input.length() > maxLength)
				System.out.println("Error: Must be between " + minLength + " and " +  maxLength + " characters!");
			else if(input.contains(" ")) {
				System.out.println("Error: Can not contain spaces!");
				input = "";
			}
		}
		
		return input;
	}
	
	private float getUserFloat(String prompt, float min, float max) {
		
		boolean valid = false;
		float val = 0;
		String input = "";
		
		do {
			System.out.println(prompt);
			
			input = inputScan.nextLine();
			
			try {
				val = Float.parseFloat(input);
				valid = true;
				}catch(NumberFormatException e) {
					val = -1;
					valid = false;
				}
			
			if(val < min ) {
				System.out.println("Input needs to be greater than " + min + "!");
				valid = false;
			}
			else if(val > max) {
				System.out.println("Input needs to be less than " + max + "!");
				valid = false;
			}
			
		}while(!valid);
		
		return val;
	}
}
