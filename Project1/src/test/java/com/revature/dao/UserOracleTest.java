package com.revature.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.*;

import com.revature.beans.User;

public class UserOracleTest {

	// DAO is stateless, can be used multiple times without affecting methods
	private UserOracle uo = new UserOracle();

	

	/*
	 * Login tests
	 */
	@Test
	public void loginValidUser() {
		User user = uo.login("asdf", "asdf");
		// Assert that all fields are equal.
		User test = new User(1, "asdf", "asdf", "asdf", "asdf", 2);
		assertEquals(
				user.getUser_id() + user.getFirstname() + user.getLastname() + user.getPassword() + user.getUsername()
						+ user.getPosition_id(),
				test.getUser_id() + test.getFirstname() + test.getLastname() + test.getPassword() + test.getUsername()
						+ test.getPosition_id());
	}
	@Test
	public void loginInvalidPassword() {
		User user = uo.login("asdf", "null");
		// Assert that all fields are equal.
		assertEquals(user, null);
	}
	@Test
	public void loginInvalidUsername() {
		User user = uo.login("null", "asdf");
		// Assert that all fields are equal.
		assertEquals(user, null);
	}
	
	/*
	 * Update information tests
	 */
	@Test
	public void updateInfoValidId() {
		uo.editInfo(1, "qwer", "qwer", "qwer");
		User user = uo.login("asdf", "qwer");
		User test = new User(1, "asdf", "qwer", "qwer", "qwer", 2);
		assertEquals(
				user.getUser_id() + user.getFirstname() + user.getLastname() + user.getPassword() + user.getUsername()
						+ user.getPosition_id(),
				test.getUser_id() + test.getFirstname() + test.getLastname() + test.getPassword() + test.getUsername()
						+ test.getPosition_id());
		// Set user back.
		uo.editInfo(1, "asdf", "asdf", "asdf");
	}
	@Test
	public void updateInfoInvalidId() {
		uo.editInfo(-1, "qwer", "qwer", "qwer");
		User user = uo.login("asdf", "qwer");
		User test = new User(5000, "asdf", "qwer", "qwer", "qwer", 2);
		assertNotEquals(
				user.getUser_id() + user.getFirstname() + user.getLastname() + user.getPassword() + user.getUsername()
						+ user.getPosition_id(),
				test.getUser_id() + test.getFirstname() + test.getLastname() + test.getPassword() + test.getUsername()
						+ test.getPosition_id());
	}
}
