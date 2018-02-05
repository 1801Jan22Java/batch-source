package com.revature.dao;

import static org.junit.Assert.*;


import org.junit.Test;

import com.revature.beans.UserAccounts;

public class UserAccountsDaoImplTest {

	
	UserAccountsDao uad = new UserAccountsDaoImpl();
	UserAccounts ua = new UserAccounts(1062, 53);
	
	@Test
	public final void UserAccountTesting() {
	
		uad.createUserAccount(1062, 11);
		uad.removeAccount(1062, 11);
		assertNotNull(uad.maxAccountID(1062));
				
	}
}
