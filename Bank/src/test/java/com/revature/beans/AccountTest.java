package com.revature.beans;
import org.junit.Test;

import com.revature.beans.Account;
import com.revature.dao.AccountDaoImpl;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class AccountTest {
	@Test
	public final void testAssertions() {
		AccountDaoImpl ad = new AccountDaoImpl();
		User thisUser = new User(100, "admin", "SUPERUSER", "John", "Doe", LocalDate.now());
		thisUser.getUsers().add(new User(101, "customer", "USER", "John", "Doe", LocalDate.now()));
		thisUser.getUsers().get(0).getAccounts().add(new Account(200, "CHECKING", "My Money", 100f, LocalDate.now()));
		
		User simpleUser = new User(102, "simplecustomer", "USER", "Jane", "Doe", LocalDate.now());
		simpleUser.getAccounts().add(new Account(201, "SAVINGS", "Your Money", 200f, LocalDate.now()));
		
		// Returns 200 from constructed object
		assertEquals(simpleUser.getAccounts().get(0).getAccountid(), 201);
		
		// Returns "CHECKING" from constructed object
		assertEquals(simpleUser.getAccounts().get(0).getAccountType(), "SAVINGS");
		
		// Deprecated - unusable
		//assertEquals(simpleUser.getAccounts().get(0).getBalance(), 200f);
		
		// Returns null from constructed object
		assertNull(simpleUser.getAccounts().get(0).getCreation_date());
		
		// Returns String object
		assertNotNull(simpleUser.getAccounts().get(0).toString());
		
		// Returns "My Money" from constructed object
		assertEquals(simpleUser.getAccounts().get(0).getName(), "Your Money");
		
	}
}
