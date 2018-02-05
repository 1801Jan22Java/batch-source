package com.revature.main;

import java.util.ArrayList;

import com.revature.beans.BankAccount;
import com.revature.beans.User;
import com.revature.beans.UserType;

public class GeneralUser extends User
{
	ArrayList<BankAccount> accounts;

	public GeneralUser(){}

	public GeneralUser(String firstName, String lastName, String username, String password, UserType type, ArrayList<BankAccount> accounts)
	{
		super(firstName, lastName, username, password, type);
		this.accounts = accounts;
	}

	public GeneralUser(int id, String firstName, String lastName, String username, String password, UserType type, ArrayList<BankAccount> accounts)
	{
		super(id, firstName, lastName, username, password, type);
		this.accounts = accounts;
	}
	
	public ArrayList<BankAccount> getAccounts() 
	{
		return accounts;
	}

	public void setAccount(ArrayList<BankAccount> accounts) 
	{
		this.accounts = accounts;
	}
	
	public String toString()
	{
		return super.toString() + "\n\tAccounts: " + accounts;
	}
}
