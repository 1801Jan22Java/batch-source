package com.revature.beans;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	
	@Test
	public void testGettersAndSetters() {
		Account acct = new Account();
		
		acct.setBalance(100);
		acct.setName("checking");
		acct.setId(1);
		
		assertEquals(100, acct.getBalance());
		assertEquals("checking", acct.getName());
		assertEquals(1, acct.getId());
	}
	
	@Test
	public void testFullConstructor() {
		Account acct = new Account(1, "checking", 100);
		
		assertEquals(100, acct.getBalance());
		assertEquals("checking", acct.getName());
		assertEquals(1, acct.getId());
	}
	
	@Test
	public void testNoIdConstructor() {
		Account acct = new Account("checking", 100);
		
		assertEquals(100, acct.getBalance());
		assertEquals("checking", acct.getName());
		assertEquals(0, acct.getId());
	}
}
