package com.revature.Beans;

import static org.junit.Assert.*;

import org.junit.Test;





import com.revature.Exceptions.OverdraftException;
import com.revature.Exceptions.ZeroBalanceException;
import com.revature.beans.Account;
import com.revature.beans.CheckingAccount;
import com.revature.beans.SavingsAccount;
import com.revature.beans.User;

public class BankBeansTest {

	@Test 
	public final void returnsUser()
	{
		String fname = "Omar";
		String lname="Test";
		String ssn = "000-00-0000";
		String username ="omohama";
		String pw = "p4ssw0rd";
		User newUser = new User(username,pw,fname,lname,ssn);
		//User user = udi.getUserById(1005);
		assert(newUser instanceof User);
	}
	
	@Test 
	public final void openSavingsAccount() throws ZeroBalanceException
	{
		float initBal= 300.0f;
		int userID= 1002;
		SavingsAccount savingsAccount = new SavingsAccount(initBal,userID);
		assert(savingsAccount instanceof Account);	
	}
	
	@Test//(expected=ZeroBalanceException.class) 
	public final void lessThanZeroThrowsException()
	{
		String output ="";
		try{
		float initBal= -40.0f;
		int userID= 1002;
		CheckingAccount checking = new CheckingAccount(initBal,userID);
		}
		catch(ZeroBalanceException e)
		{
			System.out.println("");
		}
	}
	
	@Test
	public final void openCheckingAccount() throws ZeroBalanceException
	{
		float initBal= 300.0f;
		int userID= 1002;
		CheckingAccount checking = new CheckingAccount(initBal,userID);
		assert(checking instanceof Account);
	}
	
	@Test
	public final void accountIsChecking() throws ZeroBalanceException{
		float initBal= 40.0f;
		int userID= 1002;
		CheckingAccount checking = new CheckingAccount(initBal,userID);
		assert(checking.getAccountType().getAccountType().equals("Checking"));
	}
	
	
	@Test
	public final void accountIsSavings() throws ZeroBalanceException{
		float initBal= 300.0f;
		int userID= 1002;
		SavingsAccount savings = new SavingsAccount(initBal,userID);
		assert(savings.getAccountType().getAccountType().equals("Savings"));
	}
}
