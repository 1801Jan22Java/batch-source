package com.revature.UserDaoTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.revature.beans.User;
import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.util.IllegalPasswordException;
import com.revature.util.IllegalUsernameException;
import com.revature.util.IncorrectCredentialsException;

public class UserDaoImplTest {

	AccountDao adi = new AccountDaoImpl();
	UserDao udi = new UserDaoImpl();

	@Test
	public final void createUserTest() {
		User user = new User("usr", "aaaaaaaa", "Test", "Case");
		try {
			user = udi.createUser(user);
		} catch (IllegalUsernameException | IllegalPasswordException e) {
			e.printStackTrace();
		}
		
		List<User> users = udi.superGetUsers();
		
		Assert.assertTrue(users.contains(user));
		
		boolean causedUsernameException = false;
		User user2 = new User("usr", "aaaaaaaab", "Testo", "Caseo");
		try {
			user2 = udi.createUser(user2);
		} catch (IllegalUsernameException e) {
			causedUsernameException = true;
		} catch (IllegalPasswordException e) {
			e.printStackTrace();
		}
		
		boolean causedPasswordException = false;
		User user3 = new User("user", "7777777", "Testo", "Caseo");
		try {
			user3 = udi.createUser(user3);
		} catch (IllegalUsernameException e) {
			e.printStackTrace();
		} catch (IllegalPasswordException e) {
			causedPasswordException = true;
		}
		
		udi.superDeleteUser(user);

		Assert.assertTrue(causedUsernameException);
		Assert.assertTrue(causedPasswordException);
	}
	
	@Test
	public final void testLogin() {
		User user = new User("usr", "aaaaaaaa", "Test", "Case");
		try {
			user = udi.createUser(user);
		} catch (IllegalUsernameException | IllegalPasswordException e) {
			e.printStackTrace();
		}
		User user2 = null;
		try {
			user2 = udi.login(user.getUsername(), user.getPassword());
		} catch (IncorrectCredentialsException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(user, user2);
		boolean causedException = false;
		
		try {
			user2 = udi.login("Oznot", "Arelman");
		} catch (IncorrectCredentialsException e) {
			causedException = true;
		}
		
		Assert.assertTrue(causedException);
		
		udi.superDeleteUser(user);
	}
	
	@Test
	public final void testGetAccountsById() {
		// Thoroughly tested in AccountDaoImplTest.java
	}
	
	@Test
	public final void testSuperGetUsers() {
		User user = new User("usr", "aaaaaaaa", "Test", "Case");
		User user2 = new User("usr2", "aaaaaaaa", "Test", "Case");
		User user3 = new User("usr3", "aaaaaaaa", "Test", "Case");
		try {
			user = udi.createUser(user);
			user2 = udi.createUser(user2);
			user3 = udi.createUser(user3);
		} catch (IllegalUsernameException | IllegalPasswordException e) {
			e.printStackTrace();
		}
		
		List<User> testUsers = new ArrayList<User>();
		testUsers.add(user);
		testUsers.add(user2);
		testUsers.add(user3);
		List<User> users = udi.superGetUsers();
		for (User u : testUsers) {
			Assert.assertTrue(users.contains(u));
			udi.superDeleteUser(u);
		}
		
	}
	
	
	public final void testGetUserById() {
		User user = new User("usr", "aaaaaaaa", "Test", "Case");
		try {
			user = udi.createUser(user);
		} catch (IllegalUsernameException | IllegalPasswordException e) {
			e.printStackTrace();
		}
		User user2 = udi.getUserById(user.getuserId());
		Assert.assertEquals(user, user2);
		udi.superDeleteUser(user);
	}
	
	@Test
	public final void testSuperChangeUser() {
		User user = new User("usr", "aaaaaaaa", "Test", "Case");
		try {
			user = udi.createUser(user);
		} catch (IllegalUsernameException | IllegalPasswordException e) {
			e.printStackTrace();
		}
		
		User user2 = new User("user", "aaaaaaaa", "Test", "Case");
		user2.setuserId(user.getuserId());
		try {
			udi.superChangeUser(user2);
		} catch (IllegalUsernameException | IllegalPasswordException e) {
			e.printStackTrace();
		}
		
		User user3 = udi.getUserById(user2.getuserId());
		Assert.assertEquals(user3, user2);
		Assert.assertNotEquals(user3, user);
		
		boolean causedUsernameException = false;
		User user4 = new User("imitateMe", "aaaaaaaab", "Testo", "Caseo");
		User user42 = new User("imitateMe", "aaaaaaaab", "Testo", "Caseo");
		try {
			user42 = udi.createUser(user42);
		} catch (IllegalUsernameException | IllegalPasswordException e1) {
			e1.printStackTrace();
		}
		user4.setuserId(user3.getuserId());
		try {
			udi.superChangeUser(user4);
		} catch (IllegalUsernameException e) {
			causedUsernameException = true;
		} catch (IllegalPasswordException e) {
			e.printStackTrace();
		}
		
		boolean causedPasswordException = false;
		User user5 = new User("user", "7777777", "Testo", "Caseo");
		user5.setuserId(user3.getuserId());
		try {
			udi.superChangeUser(user5);
		} catch (IllegalUsernameException e) {
			e.printStackTrace();
		} catch (IllegalPasswordException e) {
			causedPasswordException = true;
		}
		
		udi.superDeleteUser(user3);
		udi.superDeleteUser(user42);

		Assert.assertTrue(causedUsernameException);
		Assert.assertTrue(causedPasswordException);
	}
	
	@Test
	public final void testSuperDelete() {
		User user = new User("usr", "aaaaaaaa", "Test", "Case");
		try {
			user = udi.createUser(user);
		} catch (IllegalUsernameException | IllegalPasswordException e) {
			e.printStackTrace();
		}
		
		List<User> users = udi.superGetUsers();
		
		boolean existsInUsers = false;
		
		for (User u : users) {
			if (u.equals(user)) {
				existsInUsers = true;
			}
		}
		
		Assert.assertTrue(existsInUsers);
		
		udi.superDeleteUser(user);
		
		users = udi.superGetUsers();
		existsInUsers = false;
		
		for (User u : users) {
			if (u.equals(user)) {
				existsInUsers = true;
			}
		}
		
		Assert.assertFalse(existsInUsers);
	}
	
}
