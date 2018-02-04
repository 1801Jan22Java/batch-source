package com.revature.beans;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UserTest {
	
	@Test
	public void testGettersAndSetters() {
		User user = new User();
		
		user.setFirstName("Joe");
		user.setLastName("Schmoe");
		user.setPassword("password");
		user.setSuperUser(false);
		user.setUserName("jmoe");
		user.setId(1);
		
		List<Account> accts = new ArrayList<>();
		
		user.setAccounts(accts);
		
		assertEquals("Joe", user.getFirstName());
		assertEquals("Schmoe", user.getLastName());
		assertEquals("password", user.getPassword());
		assertEquals(1, user.getId());
		assertFalse(user.isSuperUser());
		assertEquals("jmoe", user.getUserName());
		assertEquals(accts, user.getAccounts());
	}
	
	@Test
	public void testFullConstructor() {
		List<Account> accts = new ArrayList<>();
		User user = new User(1, "Joe", "Schmoe", "jmoe", "password", false, accts);
		
		assertEquals("Joe", user.getFirstName());
		assertEquals("Schmoe", user.getLastName());
		assertEquals("password", user.getPassword());
		assertEquals(1, user.getId());
		assertFalse(user.isSuperUser());
		assertEquals("jmoe", user.getUserName());
		assertEquals(accts, user.getAccounts());
	}
	
	@Test
	public void testNoIdConstructor() {
		List<Account> accts = new ArrayList<>();
		User user = new User("Joe", "Schmoe", "jmoe", "password", false, accts);
		
		assertEquals("Joe", user.getFirstName());
		assertEquals("Schmoe", user.getLastName());
		assertEquals("password", user.getPassword());
		assertEquals(0, user.getId());
		assertFalse(user.isSuperUser());
		assertEquals("jmoe", user.getUserName());
		assertEquals(accts, user.getAccounts());
	}
	
}
