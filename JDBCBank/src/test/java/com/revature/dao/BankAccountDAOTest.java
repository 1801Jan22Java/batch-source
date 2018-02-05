package com.revature.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.beans.User;
import com.revature.exceptions.OverdraftException;

public class BankAccountDAOTest {
	// Tests break in between because values are no longer the same

	BankAccountDAO bankAccount = new BankAccountDAOImpl();
	
	@Test
	public void testViewBankAccounts() {
		
		bankAccount.viewBankAccounts(new User());
	}
	
	@Test
	public void testViewBankAccountByID() {
		User user = new User(7, "cchan16", "password");
		assertNotNull(bankAccount.viewBankAccountByID(3, user));
	}
	
	@Test
	public void testCreateAccount() {
		bankAccount.createAccount("checking", new User(7, "cchan16", "password"));
		assertNotNull(bankAccount.viewBankAccountByID(4, new User(7, "cchan16", "password")));
	}
	
	@Test
	public void testDepositMoneyToAccount() {
		bankAccount.depositMoneyToAccount(4, 1000, new User(7, "cchan16", "password"));
		assertEquals(1000, bankAccount.viewBankAccountByID(4, new User(7, "cchan16", "password")).getbalance(), 0);
	}
	
	@Test
	public void testWithdrawMoneyFromAccount() {
		try {
			bankAccount.withdrawMoneyFromAccount(4, 200, new User(7, "cchan16", "password"));
		} catch (OverdraftException e) {
			e.printStackTrace();
		}
		assertEquals(1600, bankAccount.viewBankAccountByID(4, new User(7, "cchan16", "password")).getbalance(), 0);
	}

}
