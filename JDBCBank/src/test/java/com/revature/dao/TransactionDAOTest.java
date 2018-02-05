package com.revature.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.beans.BankAccount;
import com.revature.beans.TransactionType;
import com.revature.beans.User;

public class TransactionDAOTest {
	
	User user = new User(6, "cchan16", "password");
	

	@Test
	public void testViewAllTransactions() {
		TransactionDAO transactions = new TransactionDAOImpl();
		assertNotNull(transactions.viewAllTransactions(user, 3));
	}
	
	@Test
	public void testAddTransaction() {
		TransactionDAO transactions = new TransactionDAOImpl();
		BankAccount account = new BankAccount();
		account.setAccountType("savings");
		account.setId(3);
		account.setUser(user);
		account.setbalance(100);
		TransactionType type = new TransactionType();
		type.setType("withdraw");
		transactions.addTransaction(user, account, type, 50);
		System.out.println(transactions.viewAllTransactions(user, 3));
	}

}
