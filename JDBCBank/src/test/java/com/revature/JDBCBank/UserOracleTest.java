package com.revature.JDBCBank;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import com.revature.dao.UserOracle;

public class UserOracleTest {
	@Before
	public void createUserOracleObject() {

	}
	
	@Test
	public void loginReturnsZeroOnFailure() {
		UserOracle uOracle = new UserOracle();
		Integer output = uOracle.login("asdf","Asdf");
		assertEquals(new Integer(0), output);
	}
	
	// Create new user
	public void newUser(String username, String password) {
		
	}
}
