package com.revature.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.beans.User;

public class SuperUserDAOTest {

	@Test
	public void testViewAllUsers() {
		SuperUserDAO superUser = new SuperUserDAOImpl();
		System.out.println(superUser.viewAllUsers());
		// Have to change as more entries are added to Database
		assertEquals(2, superUser.viewAllUsers().size());
	}
	
	@Test
	public void testUpdateUserById() {
		SuperUserDAO superUser = new SuperUserDAOImpl();
		superUser.updateUserById(5, "PASSWORD", "thisisnewpassword");
		User testUser = new User(5, "cchan16", "thisisnewpassword");
		assertEquals(testUser.toString(), superUser.getUserById(5).toString());
	}
	
//	@Test
//	//Should test this last
//	public void testDeleteAllUsers() {
//		SuperUserDAO superUser = new SuperUserDAOImpl();
//		superUser.deleteAllUsers();
//		assertEquals(0, superUser.viewAllUsers().size());
//	}
}
