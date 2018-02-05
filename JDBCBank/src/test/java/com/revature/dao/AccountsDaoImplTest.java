package com.revature.dao;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;

import com.revature.beans.Accounts;
import com.revature.main.NotEnoughFundsException;


public class AccountsDaoImplTest {

	

AccountsDaoImpl adi = new AccountsDaoImpl();
Accounts acc = new Accounts(13,3,222.22f);
	
	
	
	@Test
	public final void AccountTesting() {
		
		assertNotNull(adi.getAllUserAccounts(55));
		
		assertNotNull(adi.createAccount(17,33.2f));
		
		assertNotNull(adi.addFunds(acc, 41));
		
		assertNotNull(adi.getAllBankIDsPerUser(22));
		
		assertNotNull(adi.getAllUserAccounts(5));
		

	}
	
	
	@Test 
	public final void WithdrawTest() throws NotEnoughFundsException
	{
		assertNotNull(adi.removeFunds(acc, 23));
	}
	
	
}