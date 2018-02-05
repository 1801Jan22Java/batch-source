package com.revature.beans;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	Account account;
	
	@Test
	public void testCreateAccount() {
		account = new Account(0, "testAccount", 100.f);
		assertNotNull(account);
	}
	
	@Test
	public void testCreateAccountID() {
		account = new Account(0, "testAccount", 100.f);
		assertTrue(account.getAccountID() == 0);
	}
	
	@Test
	public void testCreateAccountName() {
		account = new Account(0, "testAccount", 100.f);
		assertTrue(account.getAccountName() == "testAccount");
	}
	
	@Test
	public void testCreateAccountBal() {
		account = new Account(0, "testAccount", 100.f);
		assertTrue(account.getBalance() == 100.f);
	}

}
