package com.revature.dao;

import org.junit.Test;

import com.revature.beans.User;
import com.revature.main.SQLProfileUpdateException;

import static org.junit.Assert.*;

public class UserDaoImplTest {
	@Test
	public final void testAssertions() {
		UserDaoImpl ud = new UserDaoImpl();
		User adminUser = new User (1, "admin", "SUPERUSER");
		User unknownUser = new User (100, "unknown", "USER");
		
		// Returns FALSE if user already exists
		assertFalse(ud.isAvailable("admin"));
		
		// Returns NULL if user already exists
		assertNull(ud.addUser("admin", "password", "Root", "User"));
		
		// Returns NULL if wrong password is entered
		assertNull(ud.login("admin", "wrongPassword"));
		
		// Returns true after collecting fetching all users
		assertTrue(ud.getAllUsers(adminUser));
		
		// Returns false when user not found
		assertFalse(ud.disableUser(unknownUser));
		
	}
	
	// Throws exception when keyword not on approved list
	@Test (expected=SQLProfileUpdateException.class)
	public final void unknownKeywordThrowsCustomException() throws SQLProfileUpdateException{
		UserDaoImpl ud = new UserDaoImpl();
		User adminUser = new User (1, "admin", "SUPERUSER");
		assertFalse(ud.updateProfile("GENDER", "FEMALE", adminUser));
	}
}
