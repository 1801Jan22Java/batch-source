package com.revature.bmain;

import java.util.Scanner;

import com.revature.bbeans.*;
import com.revature.bbeans.BankAccount.AccountType;
import com.revature.butil.*;
import com.revature.bdao.*;

public class Driver {

	static Scanner scnrin = new Scanner(System.in);
	
	public static void main(String[] args) {
		PlainConsoleFormatter.printMessage("Welcome to Bateman Bank!");
				
		for(;;) { 
			PlainConsoleFormatter.printMessage("Please login (1) or create account (2)" + 
			"\nType in -1 to quit your session.");
			
			int loginAction = scnrin.nextInt();
			scnrin.nextLine();
			switch(loginAction) {
				case 1:
					userLogin();
					break;
				case 2:
					createLogin();
					break;
				case -1:
					System.exit(1);
					break;
				default:
					PlainConsoleFormatter.printMessage("Input not recognized.");
			}
			
			scnrin.close();
			System.exit(1);
		}
		
	}
	
	private static void userLogin() {
		
		IBankUserDAO bUserDao = new OrclBankUserDAO();
		PlainConsoleFormatter.printMessage("Please enter your username.");
		String username = scnrin.nextLine();
		PlainConsoleFormatter.printMessage("Please enter your password.");
		String password = scnrin.nextLine();
		
		BankUser bUser = bUserDao.userInDatabase(username, password);
		if(bUser.equals(new Object())) {
			PlainConsoleFormatter.printMessage("Username or password is incorrect. (1) to try again, (2) to create"
					+ "new account, (-1) to exit.");
			int choice = scnrin.nextInt();
			scnrin.nextLine();
			switch(choice) {
				case 1:
					userLogin();
					break;
				case 2:
					createLogin();
					break;
				case -1:
					scnrin.close();
					System.exit(1);
				default:
					PlainConsoleFormatter.printMessage("Input not recognized, returning to entry.");
					return;
			}
			
		}else {
		    session(bUser);
		    return;
		}
		
	}
	
	private static void createLogin() {
		IBankUserDAO bUserDao = new OrclBankUserDAO();
		
		PlainConsoleFormatter.printMessage("Thank you for choosing Bateman Bank. To sign up, please complete"
				+ " the following steps.\n"
				+ "What is your first name?");
		String first = scnrin.nextLine();
		PlainConsoleFormatter.printMessage("What is your last name?");
		String last = scnrin.nextLine();
		PlainConsoleFormatter.printMessage("Please enter a username.");
		String username = scnrin.nextLine();
		PlainConsoleFormatter.printMessage("Please enter a password.");
		String password = scnrin.nextLine();
		
		session(bUserDao.addBankUser(first, last, username, password));
		
		return;
	}
	
	private static void session(BankUser bUser) {
		IBankAccountDAO bAccountDao = new OrclBankAccountDAO();
		
		printSessionHelp();
		
		for(;;) {
			PlainConsoleFormatter.printMessage("What would you like to do?");
			int command = 0;
			command = scnrin.nextInt();
			scnrin.nextLine();
			switch(command) {
				case 0:
					printSessionHelp();
					break;
				case 1:
					double iniDeposit = 0;
					String accountType = "";
					PlainConsoleFormatter.printMessage("How much will your initial deposit be?"
							+ "\nPlease enter it as a decimal number.");
					iniDeposit = scnrin.nextDouble();
					scnrin.nextLine();
					
					PlainConsoleFormatter.printMessage("What type of account? (Checking | Savings)");
					accountType = scnrin.nextLine();
					
					bAccountDao.createBankAccount(bUser.getUserID(), iniDeposit, AccountType.valueOf(accountType));
					break;
				case 2:
					bAccountDao.viewAllBankAccounts(bUser.getUserID());
					break;
				case 3:
					PlainConsoleFormatter.printMessage("What account type would you like to view? (Checking | Savings");
					String accountTypeView = scnrin.nextLine();
					bAccountDao.viewBankAccountType(bUser.getUserID(), AccountType.valueOf(accountTypeView));
					break;
				case 4:
					PlainConsoleFormatter.printMessage("How much would you like to withdraw? Please insert a decimal number.");
					double withdrawal = scnrin.nextDouble();
					scnrin.nextLine();
					PlainConsoleFormatter.printMessage("What account would you like to withdraw from? (Checking | Savings)");
					String accountTypeWithdraw = scnrin.nextLine();
					bAccountDao.withdrawFunds(bUser.getUserID(), AccountType.valueOf(accountTypeWithdraw), withdrawal);
					break;
				case 5:
					PlainConsoleFormatter.printMessage("How much would you like to deposit? Please insert a decimal number.");
					double deposit = scnrin.nextDouble();
					scnrin.nextLine();
					PlainConsoleFormatter.printMessage("What account would you like to deposit to? (Checking | Savings)");
					String accountTypeDeposit = scnrin.nextLine();
					bAccountDao.depositFunds(bUser.getUserID(), AccountType.valueOf(accountTypeDeposit), deposit);
					break;
				case 6:
					PlainConsoleFormatter.printMessage("What account would you like to delete? (Checking | Savings)");
					String accountTypeDelete = scnrin.nextLine();
					bAccountDao.deleteBankAccount(bUser.getUserID(), AccountType.valueOf(accountTypeDelete));
					break;
				case 7:
					return;
				default:
					PlainConsoleFormatter.printMessage("Input not recognized.");
			}
			
		}
		
	}
	
	private static void printSessionHelp() {
		PlainConsoleFormatter.printMessage("Session Commands"
				+ "\n(0)Help"
				+ "\n(1)Create Account"
				+ "\n(2)View Accounts"
				+ "\n(3)View Specific Account"
				+ "\n(4)Withdrawal"
				+ "\n(5)Deposit"
				+ "\n(6)Delete Account"
				+ "\n(7)Logout");
	}
}
