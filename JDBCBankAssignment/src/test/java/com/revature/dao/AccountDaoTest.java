package com.revature.dao;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class AccountDaoTest {

AccountDao dao;
Account account;
User testUser;
	@Before
	public void init() {
		try {
			ConnectionUtil.connectToDatabase("Connection.Properties");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dao = new AccountDaoImpl();
		account = new Account(0, "TestAccount", 0.f);
		testUser = new User(1040,"123456789123456789123456789", "12345",false);
	}
	
	@Test
	public void getAccounts() {
		dao.getAccounts(testUser);
	}
	
}
