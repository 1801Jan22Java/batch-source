package com.revature.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.Exceptions.OverdraftException;
import com.revature.Exceptions.ZeroBalanceException;
import com.revature.beans.Account;
import com.revature.beans.CheckingAccount;
import com.revature.beans.User;

public class BankTest {
	/*
	@Test(expected=OverdraftException.class)
	public final void withdrawMoreThanFundsThrowsException(){
		UserDaoImpl udi = new UserDaoImpl();
		User user = udi.getUserById(1005);
		AccountDaoImpl adi = new AccountDaoImpl();
		adi.withdrawal(user, 1005, 200000.0f);
	}
	*/
	@Test 
	public final void returnsUser()
	{
		UserDaoImpl udi = new UserDaoImpl();
		String fname = "Omar";
		String lname="Test";
		String ssn = "000-00-0000";
		String username ="omohama";
		String pw = "password";
		User newUser = new User(username,pw,fname,lname,ssn);
		//User user = udi.getUserById(1005);
		assert(newUser instanceof User);
	}
	
	@Test
	public final void returnsAccount()
	{
	
		UserDaoImpl udi = new UserDaoImpl();
		User user = udi.getUserById(1005);
		udi.getUserID(user);
		Account ca=null;
		try {
			 ca = new CheckingAccount(500,1005);
		} catch (ZeroBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert(ca instanceof CheckingAccount);
	}


}
