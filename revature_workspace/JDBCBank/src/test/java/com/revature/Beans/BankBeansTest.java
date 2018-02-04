package com.revature.Beans;

import static org.junit.Assert.*;

import org.junit.Test;
import Beans.Account;
import Beans.CheckingAccount;
import Beans.SavingsAccount;
import Beans.User;


import com.revature.Exceptions.OverdraftException;

public class BankBeansTest {

	@Test 
	public final void returnsUser()
	{
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
	public final void openSavingsAccount()
	{
		float initBal= 300.0f;
		int userID= 1002;
		SavingsAccount savingsAccount = new SavingsAccount(initBal,userID);
		assert(savingsAccount instanceof Account);	
	}
	
	@Test(expected=com.revature.Exceptions.ZeroBalanceException.class) 
	public final void lessThanZeroThrowsException()
	{
		float initBal= -40.0f;
		int userID= 1002;
		CheckingAccount checking = new CheckingAccount(initBal,userID);
	}
	
	@Test
	public final void openCheckingAccount()
	{
		float initBal= 300.0f;
		int userID= 1002;
		CheckingAccount checking = new CheckingAccount(initBal,userID);
		assert(checking instanceof Account);
	}
	
	@Test
	public final void accountIsChecking(){
		float initBal= 40.0f;
		int userID= 1002;
		CheckingAccount checking = new CheckingAccount(initBal,userID);
		assert(checking.getAccountType().getAccountType().equals("Checking"));
	}
	
	
	@Test
	public final void accountIsSavings(){
		float initBal= 300.0f;
		int userID= 1002;
		SavingsAccount savings = new SavingsAccount(initBal,userID);
		assert(savings.getAccountType().getAccountType().equals("Savings"));
	}
}
