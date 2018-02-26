package com.revature.main;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.Transaction;
import com.revature.beans.User;
import com.revature.beans.UserType;
import com.revature.dao.UserDaoImpl;

public class SuperUser extends User
{
	public SuperUser() {}
	
	public SuperUser(String firstName, String lastName, String username, String password, UserType type)
	{
		super(firstName, lastName, username, password, type);
	}
	
	public SuperUser(int id, String firstName, String lastName, String username, String password, UserType type)
	{
		super(id, firstName, lastName, username, password, type);
	}
	
	/*
	public List<User> getUsers()
	{
		return userDao.getUsers();
	}
	
	public User getUserById()
	{
		
	}
	
	public User createUser(String username, String password, String type)
	{
		if(type == UserType.GENERAL)
			return new GeneralUser(username, password, null, null);
		else
		{
			return new SuperUser(username, password);
		}
	}
	
	public void updateUser(User user, String username, String password, UserType userType, BankAccount account, ArrayList<Transaction> transactions)
	{
		if(user instanceof GeneralUser)
		{
			if(user.getUserType() != UserType.GENERAL && userType == UserType.GENERAL)
			{
				User temp = new GeneralUser(user.getUsername(), user.getPassword(), null, null);
				user = temp;
			}
			if(!username.equals(""))
				user.setUsername(username);
			if(!password.equals(""))
				user.setPassword(password);
			if(account != null)
				((GeneralUser) user).setAccount(account);
			if(transactions != null)
				((GeneralUser) user).setTransactions(transactions);
		}
		else
		{
			if(user.getUserType() != UserType.SUPER && userType == UserType.SUPER)
			{
				User temp = new SuperUser(user.getUsername(), user.getPassword());
				user = temp;
			}
			if(!username.equals(""))
				user.setUsername(username);
			if(!password.equals(""))
				user.setPassword(password);
		}
	}
	
	public User deleteUser(User user)
	{
		
	}
	*/
}
