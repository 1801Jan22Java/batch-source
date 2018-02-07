package com.revature.dao;
import org.junit.Test;

import com.revature.util.OverdraftException;

import static org.junit.Assert.*;
public class DaoTestAggregation {
	
	@Test(expected = OverdraftException.class)
	public void TDITests() {
		TransactionDaoImplTest TDIT = new TransactionDaoImplTest();
		try {
			TDIT.overdraftTransactionTest();
		} catch (OverdraftException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TDIT.getTransactionByIdTest();
		TDIT.getTransactionsTest();
		
	}
	
	@Test (expected = OverdraftException.class)
	public void UDITests() {
		UserDaoImplTest UDIT = new UserDaoImplTest();
		UDIT.getByUsernameTest();
		UDIT.getUsernamesTest();
		UDIT.usersNotEmptyTest();
		UDIT.containsUsernameTest();
	}
	
	@Test
	public void ADITests() {
		AccountDaoImplTest ADIT = new AccountDaoImplTest();
		ADIT.getAccountsTest();
		ADIT.getCurrentUserTest();
		ADIT.InvalidAccountIdTest();
		ADIT.OddAccountIdTest();
		ADIT.PassNullUserTest();
		
	}

}
