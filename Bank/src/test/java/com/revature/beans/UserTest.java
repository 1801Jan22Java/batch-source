package com.revature.beans;
import org.junit.Test;

import com.revature.beans.Account;
import com.revature.dao.AccountDaoImpl;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserTest {
	
	@Test
	public final void testAssertions() {
		AccountDaoImpl ad = new AccountDaoImpl();
		User thisUser = new User(100, "admin", "SUPERUSER", "John", "Doe", LocalDate.now());
		thisUser.getUsers().add(new User(101, "customer", "USER", "John", "Doe", LocalDate.now()));
		thisUser.getUsers().get(0).getAccounts().add(new Account(200, "CHECKING", "My Money", 100f, LocalDate.now()));
		
		// Returns ArrayList of account objects
		assertNotNull(thisUser.getUsers().get(0).getAccounts());
		
		// Return ArrayList of user objects
		assertNotNull(thisUser.getUsers());
		
		// Returns 100 from constructed object
		assertEquals(thisUser.getUserid(), 100);
		
		// Returns "admin" from constructed object
		assertEquals(thisUser.getUsername(), "admin");

		// Returns "SUPERUSER" from constructed object
		assertEquals(thisUser.getUserType(), "SUPERUSER");
		
		// Returns "John" from constructed object
		assertEquals(thisUser.getFirstname(), "John");
		
		// Returns "Doe" from constructed object
		assertEquals(thisUser.getLastname(), "Doe");
		
		// Returns null from constructed object
		assertNull(thisUser.getCreationDate());
		
		// Returns String object
		assertNotNull(thisUser.toString());
		
		
	}
}
