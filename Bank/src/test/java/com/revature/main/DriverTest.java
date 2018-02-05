package com.revature.main;

import org.junit.Test;

import com.revature.beans.*;
import com.revature.main.*;
import com.revature.main.SQLProfileUpdateException;

import static org.junit.Assert.*;

import java.time.LocalDate;

public class DriverTest {
	@Test
	public final void testAssertions() {
		User thisUser = new User(100, "admin", "SUPERUSER", "John", "Doe", LocalDate.now());
		thisUser.getUsers().add(new User(200, "customer", "USER", "John", "Doe", LocalDate.now()));
		thisUser.getUsers().get(0).getAccounts().add(new Account(1, "CHECKING", "My Money", 100f, LocalDate.now()));
		
		// Choose option 1 to return 1
		assertEquals(Driver.getMainMenuOption(), 1);
		
		// Choose option 1 to return 1
		assertEquals(Driver.getSuperMenuOption(thisUser), 1);
		
		// Choose option 1 to return 1
		assertEquals(Driver.getNoAccountOption(thisUser.getUsers().get(0)), 1);
		
		// Choose option 1 to return 1
		assertEquals(Driver.getNewAccountOption(thisUser.getUsers().get(0)), 1);
		
		// Choose option 1 to return 1
		assertEquals(Driver.getAccountList(thisUser.getUsers().get(0)), 1);
		
		// Choose option 1 to return 1
		assertEquals(Driver.getUserList(thisUser), 1);
		
		// Choose option 1 to return 1
		assertEquals(Driver.getAccountAction(0, thisUser.getUsers().get(0)), 1);
		
		// Choose option 1 to return 1
		assertEquals(Driver.getUserAction(thisUser.getUsers().get(0)), 1);
		
		// Deprecated assertEquals(Double, Double) - Unusable
		// Type 10 in response to return 10
		//assertEquals(Driver.getWithdrawAmount(100), 10);
		
		// Deprecated assertEquals(Double, Double) - Unusable
		// Type 10 in response to  return 10
		//assertEquals(Driver.getDepositAmount(), 10);
		
		// Type 'n' in response to return FALSE
		assertFalse(Driver.tryAgain());
	}
	
}
