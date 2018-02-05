package com.revature.dao;

import static org.junit.Assert.assertNotNull;

import java.sql.Time;
import java.time.LocalDateTime;

import org.junit.Test;

import com.revature.beans.Transactions;

public class TransactionsDaoImplTest {

	@Test
	public final void TransactionsTesting() {
		
		LocalDateTime local = null;
		local = LocalDateTime.now();
		
		TransactionsDaoImpl td = new TransactionsDaoImpl();
		//Transactions tran = new Transactions(5, 1061, 77, local, 50f, 5);
		
		assertNotNull(td.getUserTransactions(1061));
		td.addTransaction(1061, 77, 55.55f);
		td.withTransaction(1061, 77, 33.33f);
		
	}
	
	
}
