package com.revature.dao;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;
import com.revature.util.UsernameTakenException;

public class UserDaoTest {

	UserDao dao;
	
	@Before
	public void init() {
		try {
			ConnectionUtil.connectToDatabase("Connection.Properties");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dao = new UserDaoImpl();
		
	}
	
	@Test
	public void getUsers() {
		dao.getAllUsers();
	}
	
	@Test(expected= UsernameTakenException.class)
	public void userTakenTest() throws UsernameTakenException {
		//A user normally cant have a username this long which makes it fine to test with
		assertTrue(dao.isUsernameTaken("123456789123456789123456789"));

	}
	
	@Test
	public void deleteUserTest() throws UsernameTakenException {
		dao.deleteUser(new User(1040,"123456789123456789123456789", "12345",false));

	}
}
