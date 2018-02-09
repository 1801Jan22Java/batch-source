package com.revature.util;

import java.util.Scanner;

import com.revature.beans.*;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.UserBankAccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.dao.UserLoginDaoImpl;

public class Menu {
	UserLoginDaoImpl login = new UserLoginDaoImpl();
	UserDaoImpl regUser = new UserDaoImpl();
	BankAccountDaoImpl acc = new BankAccountDaoImpl();
	UserBankAccountDaoImpl linker = new UserBankAccountDaoImpl();
	AccountType type = null;
	BankAccount account = null;
	User user = null;
	public Menu()
	{
		super();
		startMenu();
	}
	
	/*
	 * 
	 */
	private void startMenu()
	{
		String input = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the JDBC banking app");
		System.out.println("Are you a returning user?");
		System.out.println("Type 1 to log in, 2 if you need to create a username/password, or 0 to exit.");
		input = sc.nextLine();
		switch (input)
		{
			case "1": getLoginInfo(); break;
			case "2": createUserLogin();break;//create login break;
			case "0"://terminate program return;
				default: System.out.println("Sorry but that was not a valid input.");
		}
		
		
	}
	private void createUserLogin()
	{
		System.out.println("Sorry but we're not accpeting new users at this moment");
		System.out.println("Please try again later.");
	}
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	private int login(String username, String password)
	{
		boolean valid;
		try 
		{
			valid = login.contains(username);
			if (valid)
			{
				try {
					int userId = login.login(new UserLogin(username, password));
					if (userId>0)
					{
						//the user has provided valid login information now they can access their accounts
						return userId;
					}
				}
				catch (IncorrectPasswordException e)
				{
					//e.printStackTrace();
					System.out.println(e.getMessage());
					return -1;
				}
			}
			
			
		}//end of the first try
		catch (InvalidUsernameException e)
		{
			//e.printStackTrace();
			System.out.println(e.getMessage());
			return -2;
		}
		return -1;
		
	}
	
	/*
	 * 
	 */
	private void getLoginInfo()
	{
		String username = "";
		String password = "";
		int userid = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Please Enter your username:");
			username = sc.nextLine();
			System.out.println("Please enter your password:");
			password = sc.nextLine();
			userid = login(username, password);
			if (userid<0)
			{
				System.out.println("please try again");
			}
		} while(userid<0);
		
		regUserMenu(userid);
	}
	private void regUserMenu(int id)
	{
		Scanner sc = new Scanner(System.in);
		String input;
		user = regUser.getUserById(id);
		boolean valid = true;
		System.out.println("Welcome Back " + user.getFirstname() + " " + user.getLastname());
		do {
			
			System.out.println("What would you like to do?");
			System.out.println();
			System.out.println("To view your accounts and balances enter 1");
			System.out.println("To create another account enter 2");
			System.out.println("To make a deposit enter 3");
			System.out.println("To make a withdrawal enter 4");
			System.out.println("To logout enter 5");
			input = sc.nextLine();
			//input = input.toLowerCase();
			switch (input.toLowerCase())
			{
			case "1": viewAccountsAndBalances(); valid=true; break;
			case "2": createAccount(); 			valid=true; break;
			case "3": makeDeposit();			valid=true; break;
			case "4": withdraw();				valid=true; break;
			case "5": logout(); return;
				default: System.out.println("Sorry "+ user.getFirstname() + " that wasn't a valid choice");
				valid = false;
			}
		} while (!valid);
		
	}
	private void viewAccountsAndBalances()
	{
		int num = linker.numOfAccounts(user);
		String input;
		System.out.println("You have "+ num + " account(s)");
		if(num >= 1)
		{
			
			do {
				System.out.println("Which would you like to view? enter the account number");
				Scanner sc = new Scanner(System.in);
				String id = sc.nextLine();
				account = acc.getBankAccountById(Integer.parseInt(id));
				System.out.println(account);
				System.out.println("enter 1 if you would like view another or 0 if you would like to go back to menu");
				input = sc.nextLine();
				switch (input)
				{
				case "0": return;
				case "1": continue; 
				default: System.out.println("invalid input: returning to menu"); return;
				}
			} while (input.equals("1"));
		}
		
	}
	
	private void createAccount()
	{
		System.out.println("Please enter the starting balance ");
		Scanner sc = new Scanner(System.in);
		String startBal = getDouble();
		System.out.println("Please enter the type of account you would like to create");
		System.out.println("1 for checking, 2 for savings");
		String type = getInt();
		//2acc.addAccount(new BankAccount(startBal,type));
	}
	
	private void makeDeposit()
	{
		
	}
	
	private void withdraw()
	{
		
	}
	
	private void logout()
	{
		user = null;
		System.out.println("You have logged out.");
	}
	private String getInt()
	{
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		for(int i = 0; i<temp.length(); i++)
		{
			if(Character.isDigit(temp.charAt(i)))
			{
				continue;
			}
			else 
			{
				return "";
			}
		}
		return temp;
	}
	private String getDouble()
	{
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		for(int i = 0; i<temp.length(); i++)
		{
			if(Character.isDigit(temp.charAt(i))&& temp.charAt(i)=='.')
			{
				continue;
			}
			else 
			{
				return "";
			}
		}
		return temp;
	}
}
