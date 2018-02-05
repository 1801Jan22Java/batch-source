package com.revature.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.beans.User;
import com.revature.exceptions.IncorrectCredentialsException;
import com.revature.exceptions.UserTakenException;

public class UserDAOTest {
	
	UserDAO user = new UserDAOImpl();

	@Test
	public void testCheckCredentials() {
		boolean notValid = false;
		try {
			notValid = user.checkCredentials("cchan16", "password");
		} catch (IncorrectCredentialsException e) {
			e.printStackTrace();
		}
		assertTrue(notValid);
	}
	
	@Test
	public void testGetUserById() {
		User user1 = user.getUserById(7);
		assertNotNull(user1);		
	}
	
	@Test
	public void testGetUserByUsername() {
		User user1 = user.getUserByUsername("cchan16");
		assertNotNull(user1);
	}
	
	@Test
	public void testCreateUser() {
		User user1 = new User();
		user1.setPassword("testPassword");
		user1.setUsername("testcase");
		try {
			user.createNewUser(user1);
		} catch (UserTakenException e) {
			e.printStackTrace();
		}
		assertNotNull(user.getUserByUsername("testcase"));
	}

}
