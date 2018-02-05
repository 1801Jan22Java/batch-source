package com.revature.beans;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransactionTest {

	Transaction transaction;
	
	@Test
	public void testCreateTransaction() {
		transaction = new Transaction(0, 0, 0, 0, 0, null);
		assertNotNull(transaction);
	}

}
