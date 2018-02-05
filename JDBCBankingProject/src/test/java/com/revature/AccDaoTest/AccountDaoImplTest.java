package com.revature.AccDaoTest;

import java.util.List;

import org.junit.Test;
import org.junit.Assert;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.util.IllegalAmountException;
import com.revature.util.IllegalDeleteException;
import com.revature.util.IllegalPasswordException;
import com.revature.util.IllegalUsernameException;
import com.revature.util.IllegalWithdrawException;

public class AccountDaoImplTest {

	AccountDao adi = new AccountDaoImpl();
	UserDao udi = new UserDaoImpl();
	
	@Test
	public final void testCreateAccount() {
		User user = new User("usr", "aaaaaaaa", "Test", "Case");
		try {
			user = udi.createUser(user);
		} catch (IllegalUsernameException | IllegalPasswordException e) {
			e.printStackTrace();
		}
		Account acc = new Account(user.getuserId(), 0.0, "Example");
		adi.createAccount(acc);
		
		List<Account> accs = udi.getAccountsById(user.getuserId());
		
		boolean success = false;
		
		for (Account a : accs) {
			if (a.getUserId() == acc.getUserId() && a.getBalance() == acc.getBalance()
					&& a.getAccName().equals(acc.getAccName())) {
				success = true;
			}
			try {
				adi.delete(a.getAccId());
			} catch (IllegalDeleteException e) {
				e.printStackTrace();
			}
		}
		
		udi.superDeleteUser(user);
		
		Assert.assertTrue(success);
	}
	
	@Test
	public final void testGetUserAccounts() {
		User user = new User("usr", "aaaaaaaa", "Test", "Case");
		try {
			user = udi.createUser(user);
		} catch (IllegalUsernameException | IllegalPasswordException e) {
			e.printStackTrace();
		}
		Account acc = new Account(user.getuserId(), 0.0, "Example");
		Account acc2 = new Account(user.getuserId(), 0.0, "Example2");
		Account acc3 = new Account(user.getuserId(), 0.0, "Example3");
		adi.createAccount(acc);
		adi.createAccount(acc2);
		adi.createAccount(acc3);
		
		System.out.println(acc.getAccId());
		List<Account> accs = adi.getUserAccounts(user.getuserId());
		int size = accs.size();
		
		try {
			for (Account account : accs) {
				adi.delete(account.getAccId());
			}
		} catch (IllegalDeleteException e) {
			e.printStackTrace();
		}
		
		udi.superDeleteUser(user);
		
		Assert.assertEquals(3, size);
	}
	
	@Test
	public final void testGetAccountById() {
		User user = new User("usr", "aaaaaaaa", "Test", "Case");
		try {
			user = udi.createUser(user);
		} catch (IllegalUsernameException | IllegalPasswordException e) {
			e.printStackTrace();
		}
		Account acc = null;
		Account acc1 = new Account(user.getuserId(), 0.0, "Example");
		Account acc2 = new Account(user.getuserId(), 0.0, "Example2");
		Account acc3 = new Account(user.getuserId(), 0.0, "Example3");
		adi.createAccount(acc1);
		adi.createAccount(acc2);
		adi.createAccount(acc3);
		
		List<Account> accs = udi.getAccountsById(user.getuserId());
		
		for (Account a : accs) {
			acc = adi.getAccountById(a.getAccId());
			Assert.assertEquals(acc.getAccName(), a.getAccName());
			Assert.assertEquals(acc.getUserId(), a.getUserId());
			Assert.assertEquals(acc.getAccId(), a.getAccId());
			try {
				adi.delete(a.getAccId());
			} catch (IllegalDeleteException e) {
				e.printStackTrace();
			}
		}
		
		udi.superDeleteUser(user);
	}
	
	@Test
	public final void testDelete() {
		User user = new User("usr", "aaaaaaaa", "Test", "Case");
		try {
			user = udi.createUser(user);
		} catch (IllegalUsernameException | IllegalPasswordException e) {
			e.printStackTrace();
		}
		Account acc = new Account(user.getuserId(), 0.0, "Example");
		Account acc2 = new Account(user.getuserId(), 0.0, "Example2");
		Account acc3 = new Account(user.getuserId(), 0.0, "Example3");
		adi.createAccount(acc);
		adi.createAccount(acc2);
		adi.createAccount(acc3);
		
		System.out.println(acc.getAccId());
		List<Account> accs = adi.getUserAccounts(user.getuserId());
		int size = accs.size();
		
		try {
			for (Account account : accs) {
				adi.delete(account.getAccId());
			}
		} catch (IllegalDeleteException e) {
			e.printStackTrace();
		}
		
		int size2 = adi.getUserAccounts(user.getuserId()).size();
		
		udi.superDeleteUser(user);
		
		Assert.assertEquals(3, size);
		Assert.assertEquals(0, size2);
	}
	
	@Test
	public final void testDepositWithdraw() {
		User user = new User("usr", "aaaaaaaa", "Test", "Case");
		try {
			user = udi.createUser(user);
		} catch (IllegalUsernameException | IllegalPasswordException e) {
			e.printStackTrace();
		}
		Account acc = new Account(user.getuserId(), 0.0, "Example");
		adi.createAccount(acc);
		for (Account a : adi.getUserAccounts(user.getuserId())) {
			acc = a;
		}
		
		try {
			adi.deposit(acc.getAccId(), 2.5);
		} catch (IllegalAmountException e) {
			e.printStackTrace();
		}
		
		for (Account a : adi.getUserAccounts(user.getuserId())) {
			acc = a;
		}
		
		Assert.assertEquals((int) (2.5 - acc.getBalance()), 0);
		boolean causedException = true;
		
		try {
			adi.deposit(acc.getAccId(), -2.5);
			causedException = false;
		} catch (IllegalAmountException e) {
		}
		
		try {
			adi.withdraw(acc.getAccId(), -2.5);
			causedException = false;
		} catch (IllegalWithdrawException | IllegalAmountException e2) {
		}
		
		try {
			adi.withdraw(acc.getAccId(), 3.5);
			causedException = false;
		} catch (IllegalWithdrawException | IllegalAmountException e2) {
		}
		
		try {
			adi.withdraw(acc.getAccId(), 1.5);
		} catch (IllegalWithdrawException | IllegalAmountException e1) {
			e1.printStackTrace();
		}
		
		for (Account a : adi.getUserAccounts(user.getuserId())) {
			acc = a;
		}
		
		Assert.assertEquals((int) (1.5 - acc.getBalance()), 0);
		
		try {
			adi.withdraw(acc.getAccId(), 1.0);
		} catch (IllegalWithdrawException | IllegalAmountException e1) {
			e1.printStackTrace();
		}
		
		Assert.assertTrue(causedException);
		
		for (Account account : adi.getUserAccounts(user.getuserId())) {
			try {
				adi.delete(account.getAccId());
			} catch (IllegalDeleteException e) {
				e.printStackTrace();
			}
		}
		
		udi.superDeleteUser(user);
	}
}
