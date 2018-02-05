package com.revature.dao;

import org.junit.Test;

import com.revature.beans.Account;
import com.revature.beans.User;

import static org.junit.Assert.*;

import java.time.LocalDate;
public class AccountDaoImplTest {
	@Test
	public final void testAssertions() {
		AccountDaoImpl ad = new AccountDaoImpl();
		User thisUser = new User(100, "admin", "SUPERUSER", "John", "Doe", LocalDate.now());
		thisUser.getUsers().add(new User(200, "customer", "USER", "John", "Doe", LocalDate.now()));
		thisUser.getUsers().get(0).getAccounts().add(new Account(100, "CHECKING", "My Money", 100f, LocalDate.now()));
		
		// Return FALSE when given an invalid user
		assertFalse(ad.addAccount(thisUser.getUsers().get(0), "CHECKING", "Our Money"));
		
		// Return FALSE when given an invalid user
		assertFalse(ad.getAccounts(thisUser.getUsers().get(0)));
		
		// Return FALSE when given an invalid account
		assertFalse(ad.withdrawAmount(100f, 0, thisUser.getUsers().get(0)));
		
		// Return FALSE when given an invalid account
		assertFalse(ad.depositAmount(100f, 0, thisUser.getUsers().get(0)));
		
		// Returns FALSE when given an invalid account
		assertFalse(ad.closeAccount(0, thisUser.getUsers().get(0)));
		
	}
}
