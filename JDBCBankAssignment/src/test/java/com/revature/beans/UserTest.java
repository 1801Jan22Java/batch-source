package com.revature.beans;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	User user;
	
	@Test
	public void testCreateUser() {
		user = new User(0, "testuser", "pass", false);
		assertNotNull(user);
		assertTrue(user.getId() == 0);
	}

	@Test
	public void testCreateUserID() {
		user = new User(0, "testuser", "pass", false);
		assertTrue(user.getId() == 0);
	}
	
	@Test
	public void testCreateUserName() {
		user = new User(0, "testuser", "pass", false);
		assertTrue(user.getUsername() == "testuser");
	}
	
	@Test
	public void testCreateUserPass() {
		user = new User(0, "testuser", "pass", false);
		assertTrue(user.getPassword() == "pass");
	}
	
}
