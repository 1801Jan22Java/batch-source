package com.revature.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.revature.beans.Account;
import com.revature.util.ConnectionUtil;

public class TransactionDaoTest {

	TransactionDao dao;
	
	@Before
	public void init() {
		try {
			ConnectionUtil.connectToDatabase("Connection.Properties");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dao = new TransactionDaoImpl();
	}

	@Test
	public void testTran() {
		//Won't return anything (id == 0) but test to make sure query is valid and doesn't throw anything crazy
		dao.getAccountTransactions(new Account(0, "test account", 0.f));
	}
	
}
