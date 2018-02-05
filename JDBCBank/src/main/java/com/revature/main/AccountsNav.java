package com.revature.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.beans.Accounts;
import com.revature.beans.Transactions;
import com.revature.beans.Users;
import com.revature.dao.AccountsDao;
import com.revature.dao.AccountsDaoImpl;
import com.revature.dao.TransactionsDao;
import com.revature.dao.TransactionsDaoImpl;
import com.revature.dao.UserAccountsDao;
import com.revature.dao.UserAccountsDaoImpl;
import com.revature.dao.UsersDao;
import com.revature.dao.UsersDaoImpl;

public class AccountsNav {

	//Used for general menu tasks right after login
	public void menuing(Users user, Scanner sc)
	{
		
		
		while(true)
		{
			String nextPlace;
			if (user.getUserType()==1)
			{
				System.out.println("Welcome glorious, master, overlord "+ user.getUserFName() + " "+ user.getUserLName() +"!");
				System.out.println("To control the fate of the univer- users type 'user'");
			}
			else
			{
				System.out.println("Welcome valued customer "+ user.getUserFName() + " "+ user.getUserLName());
			}
			System.out.println("To look at available accounts type 'acc'");
			System.out.println("To create a new account type 'create'");
			System.out.println("To look at transactions type 'tran'");
			System.out.println("To logout type 'log'");
			nextPlace = sc.nextLine();
			
			//Our menu choices above explain the functionality for each case below pretty well
			switch(nextPlace)
			{
			case "acc":
				accountManaging(user, sc);
				break;
			case "create":
				accountCreation(user, sc);
				break;
			case "tran":
				TransactionsDao td = new TransactionsDaoImpl();
				ArrayList<Transactions> allTrans = new ArrayList<Transactions>();
				allTrans = td.getUserTransactions(user.getUserID());
				System.out.println("Your transaction history is listed below: ");
				for (Transactions i : allTrans)
				{
					System.out.println(i.toString());
				}
				break;
			case "log":
				Driver.main(null);
				break;
			case "user":
				if (user.getUserType()==1)
				{
					usersManipulation(user, sc);
				}
				else
				{
					System.out.println("Wrong command.  Please try again.");
				}
				break;
			default:
				System.out.println("Wrong command.  Please try again.");
				break;
		}
		
		}
		
	}
	
	//Look at available accounts for a particular user, they can access one if available
	public void accountManaging(Users user, Scanner sc)
	{
		AccountsDao ad = new AccountsDaoImpl();
		ArrayList<Accounts> myAccs = new ArrayList<Accounts>();
		myAccs = ad.getAllUserAccounts(user.getUserID());
		if (myAccs.isEmpty())
		{
			System.out.println("You have no accounts at the moment.");
		}
		else
		{
			for (Accounts i: myAccs)
			{
				System.out.println("Here are your available accounts:");
				System.out.println(i.toString());
			}
			System.out.println("If you would like to access an account type the bankAccountID value or type 0 to cancel");
			try
			{
			int accID = sc.nextInt();
			for (Accounts i: myAccs)
			{
				if (i.getBankAccountID()== accID)
				{
					AccountsNav acn = new AccountsNav();
					acn.accNav(user, sc, i);
				}
			}
			}catch (InputMismatchException e)
			{
				System.out.println("Sorry you entered an invalid amount.");
			}
		}
		
		
	}
	
	//Creates a new bank account for a particular user
	public void accountCreation(Users user, Scanner sc)
	{
		String userChoices;
		int accountType;
		System.out.println("Would you like a Savings or Checking account type 's' for Savings and 'c' for Checking.");
		userChoices = sc.nextLine();
		if (userChoices.charAt(0)=='s'||userChoices.charAt(0)=='S')
		{
			accountType = 4;
			System.out.println("Savings account selected.");
		}
		else
		{
			accountType = 3;
			System.out.println("Checking account selected.");
		}
		UserAccountsDao uad = new UserAccountsDaoImpl();
		AccountsDao ad = new AccountsDaoImpl();
		int newAccnt = ad.createAccount(accountType, 0.00f);
		uad.createUserAccount(user.getUserID(), newAccnt);
		System.out.println("Your new Account has been created. Go to available accounts to add funds.");
	}
	
	
	//Allows a user to add funds, remove funds, and delete an empty account
	public void accNav(Users user, Scanner sc, Accounts acc)
	{
		boolean backYet = false;
		
		while (backYet == false)
		{
			System.out.println("Welcome to the account manager!");
			System.out.format("Your current balance is: $ %.2f%n" , acc.getCurrencyAmount());
			System.out.println("If you would like to add funds type 'add'");
			System.out.println("If you would like to withdraw funds type 'with'");
			System.out.println("If you would like to empty funds type 'emp'");
			System.out.println("If you would like to delete this account type 'del'. The account must be empty to do this.");
			System.out.println("Type 'back' to leave the account manager.");
			AccountsDao ad = new AccountsDaoImpl();
			UserAccountsDao uad = new UserAccountsDaoImpl();
			TransactionsDao td = new TransactionsDaoImpl();
			Float userAmnt;
			String userChoice = sc.nextLine();
			switch(userChoice)
			{
			case "add":
				System.out.println("Type the amount you would like to add with an amount between $0.01 and $999999.99");
				//Any try/catch block with an exception for input mismatch is to make sure the user does not type a string instead of a value
				try
				{
					userAmnt = (float) sc.nextDouble();
					if (userAmnt >= 0.01 && userAmnt <= 999999.99)
					{
						acc = ad.addFunds(acc, (float) (userAmnt));
						td.addTransaction(user.getUserID(), acc.getBankAccountID(), userAmnt);
						System.out.println("Funds added.");
					}
					else
					{
						System.out.println("Sorry you entered an invalid amount.");
					}
				}
				catch (InputMismatchException e)
				{
					System.out.println("Sorry you entered an invalid amount.");
				}
				
				break;
			case "with":
				System.out.format("Type the amount you would like to withdraw with an amount between $0.01 and $ %.2f%n" , acc.getCurrencyAmount());
				try
				{
					
				
					userAmnt = (float) sc.nextDouble();
					if (userAmnt >= 0.01 && userAmnt <= acc.getCurrencyAmount())
					{
						acc = ad.removeFunds(acc, (float) (userAmnt));
						td.withTransaction(user.getUserID(), acc.getBankAccountID(), userAmnt);
						System.out.println("Funds removed.");
					}
					else
					{
						System.out.println("Sorry you entered an invalid amount.");
					}
				}catch (NotEnoughFundsException e)
					{
						System.out.println("Sorry you entered an invalid amount.");
					}
				catch (InputMismatchException e)
				{
					System.out.println("Sorry you entered an invalid amount.");
				}
				break;
			case "emp":
				try {
					ad.removeFunds(acc, acc.getCurrencyAmount());
				} catch (NotEnoughFundsException e) {
					System.out.println("The funds could not be removed.");
					e.printStackTrace();
				}
				System.out.println("The account is now empty.");
				break;
			case "del":
				if (acc.getCurrencyAmount() < 0.01)
				{
					uad.removeAccount(user.getUserID(), acc.getBankAccountID());
					System.out.println("Account has been deleted.");
					backYet = true;
					break;
				}
				else
				{
					System.out.println("The account still has funds so removal is impossible at this time.");
					break;
				}
			case "back":
				backYet = true;
				break;
			default:
				System.out.println("Wrong command.  Please try again.");
				break;
		}
		}
	}
	
	//Allows the super user access to see all users or delete all users, they have more options in other menus
	public void usersManipulation(Users user, Scanner sc)
	{
		
		boolean backYet = false;
		
		while (backYet == false)
		{
			System.out.println("What evil bidding shall we do today my Lord?");
			System.out.println("Type 'see' to view all users.  Then do dastardly deeds if you so desire.");
			System.out.println("Type 'evil' to delete all other users.");
			System.out.println("Type 'back' to go back to non-user activities.");
			//AccountsDao ad = new AccountsDaoImpl();
			UsersDao ud = new UsersDaoImpl();
			String userChoice = sc.nextLine();
			switch(userChoice)
			{
			case "see":
				ArrayList<Users> users = new ArrayList<Users>();
				users = ud.getAllUsers();
				System.out.println("All your subjects are listed below my master.");
				for (Users i: users)
				{
					System.out.print(i.toString());
					System.out.println();
				}
				System.out.println("Type in the USER_ID value to select a specific user or type 0 ");
				try
				{
					int userModified = sc.nextInt();
					for (Users i: users)
					{
						
							if (i.getUserID()==userModified)
							{
								userEditing(user, sc, i);
								break;
							}
							
					}
					System.out.println("Sorry you entered an invalid amount.");
				} catch (InputMismatchException e)
				{
					System.out.println("Sorry you entered an invalid amount.");
				}
				
				break;
			case "evil":
				ud.delAllUsers();
				System.out.println("The rebels have been purged my lord.");
				break;
			case "back":
				backYet = true;
				break;
			default:
				System.out.println("The task you desire is too deep for us to comprehend master.  Please try again.");
				break;
			}
		}
	}
	
	//Allows the super user to modify a single user as they wish (they cannot promote them to a superuser though!)
	public void userEditing(Users user, Scanner sc, Users editedUser)
	{
		
		boolean backYet = false;
		
		while (backYet == false)
		{
			System.out.println("Let's begin the experiment.");
			System.out.println("The subject is: " + editedUser);
			System.out.println("Type 'acc'to change their account name.");
			System.out.println("Type 'first' to change their first name.");
			System.out.println("Type 'last' to change their last name.");
			System.out.println("Type 'pass' to change their password.");
			System.out.println("Type 'del' to dispose of the evidence.");
			System.out.println("Type 'back' to go back to non-user activities.");
			UsersDao ud = new UsersDaoImpl();
			String userChoice = sc.nextLine();
			String accField;
			switch(userChoice)
			{
			case "acc":
				System.out.println("Type their new account name, it must be at least 5 characters long.");
				accField = sc.nextLine();
				if (accField.length() > 4)
				{
					ud.modifyUserField("USER_ACCNAME", accField, editedUser);
					editedUser = ud.getUserByID(editedUser.getUserID());
					System.out.println("User account name has been changed.");
				}
				else
					System.out.println("Sorry the account name must be at least 5 characters long.");
				break;
			case "first":
				System.out.println("Type their new first name.");
				accField = sc.nextLine();
				ud.modifyUserField("USER_FNAME",accField, editedUser);
				editedUser = ud.getUserByID(editedUser.getUserID());
				System.out.println("User first name has been changed.");
				break;
			case "last":
				System.out.println("Type their new last name.");
				accField = sc.nextLine();
				ud.modifyUserField("USER_LNAME",accField, editedUser);
				editedUser = ud.getUserByID(editedUser.getUserID());
				System.out.println("User last name has been changed.");
				break;
			case "pass":
				System.out.println("Type their new account password, it must be at least 5 characters long.");
				accField = sc.nextLine();
				if (accField.length() > 4)
				{
					ud.modifyUserField("USER_PASSWORD", accField, editedUser);
					editedUser = ud.getUserByID(editedUser.getUserID());
					System.out.println("User account password has been changed.");
				}
				else
					System.out.println("Sorry the account password must be at least 5 characters long.");
				break;
			case "del":
				ud.modifyUserField("USER_PASSWORD", "DEL", editedUser);
				editedUser = ud.getUserByID(editedUser.getUserID());
				System.out.println("User account password has been changed.");
				break;
			case "back":
				backYet = true;
				break;
			default:
				System.out.println("The task you desire is too twisted master.  Please try again.");
				break;
			}
		}
	}
	
}
