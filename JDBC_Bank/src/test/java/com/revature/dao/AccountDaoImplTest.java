package com.revature.dao;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.InvalidAccountIdException;

import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDate;

public class AccountDaoImplTest {
	
	@Test(expected=NullPointerException.class)
	public void PassNullUserTest() {
		AccountDaoImpl ADI = new AccountDaoImpl();
		User u = null;
		ADI.setCurrentUser(u);
		ADI.getAccounts();
		
	}
	
	@Test(expected = InvalidAccountIdException.class)
	public void OddAccountIdTest() {
		AccountDaoImpl ADI = new AccountDaoImpl();
		ADI.getAccountByID(5);
	}
	
	@Test(expected = InvalidAccountIdException.class)
	public void InvalidAccountIdTest() {
		AccountDaoImpl ADI = new AccountDaoImpl();
		ADI.getAccountByID(30);
	}
	
	@Test
	public void getAccountsTest() {
		AccountDaoImpl ADI = new AccountDaoImpl();
		Account a = new Account("IRA", 583473.0, 4.5, LocalDate.now(), "Test Account");
		ADI.addAccount(a);
		assertNotNull(ADI.getAccounts());
	}
	
	@Test 
	public void getCurrentUserTest() {
		AccountDaoImpl ADI = new AccountDaoImpl();
		User u = new User("John", "Doe", "John", "Doe", LocalDate.now(), "John@Doe.com", LocalDate.now(), 1);
		ADI.setCurrentUser(u);
		assertNotNull(ADI.getCurrentUser());
	}
	

}
