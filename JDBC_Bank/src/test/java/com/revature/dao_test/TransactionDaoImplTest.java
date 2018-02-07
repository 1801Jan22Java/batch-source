package com.revature.dao;

import java.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.Test;
import com.revature.beans.Account;
import com.revature.beans.Transaction;
import com.revature.util.OverdraftException;

public class TransactionDaoImplTest {

	@Test
	public void getTransactionsTest() {
		Account a = new Account("type", 123.1, 1.1, LocalDate.now(), "name");
		try {
			a.transact(23.1);
		} catch (OverdraftException e) {
			//not doing anything to catch. If it fails, it fails
		}
		assertNotNull(a.getTransactions());
	}
	
	@Test(expected= OverdraftException.class)
	public void overdraftTransactionTest() throws OverdraftException {
		Account a = new Account("type", 123.1, 1.1, LocalDate.now(), "name");
		a.transact(12344667.8);
	}
	
	@Test
	public void getTransactionByIdTest() {
		Account a = new Account("type", 123.1, 1.1, LocalDate.now(), "name");
		Transaction t = new Transaction(LocalDate.now(), 23.1);
		TransactionDaoImpl TDI = new TransactionDaoImpl();
		TDI.addTransaction(t, a);
		int tid = t.getTransactionID();
		assert(TDI.getTransactionByID(tid)).equals(t);
		
	}

}
