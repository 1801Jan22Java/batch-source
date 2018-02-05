package com.revature.dao;

import org.junit.Test;
import com.revature.beans.User;
import cam.revature.exceptions.*;
import com.revature.dao.UserDaoImpl;

public class UserDaoImplTest {

	@Test(expected = OverdraftException.class)
	public void OverDraftExceptionTest() throws Exception {
		User user = new User("E349", "E349");
		ConnectionUtil.getConnection("bank.properties", user);
		UserDaoImpl dao = new UserDaoImpl();
		dao.login(user);
		dao.withdrawAccount(user, 23, 11);
	}

	@Test(expected = InvalidLoginException.class)
	public void InvalidLoginExceptionTest() throws Exception {
		User user = new User("Sammy", "Davis");
		ConnectionUtil.getConnection("bank.properties", user);
		UserDaoImpl dao = new UserDaoImpl();
		dao.login(user);
	}

	@Test(expected = AccountNotFoundException.class)
	public void AccountNotFoundExceptionTest() throws Exception {
		User user = new User("E349", "E349");
		ConnectionUtil.getConnection("bank.properties", user);
		UserDaoImpl dao = new UserDaoImpl();
		dao.login(user);
		dao.depositAccount(user, 1000, 100);
	}

}