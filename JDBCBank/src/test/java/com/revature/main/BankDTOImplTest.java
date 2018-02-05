package com.revature.main;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;

import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDAO;
import com.revature.dao.UserDAO;
import com.revature.exceptions.NegativeAmountException;
import com.revature.exceptions.OverdraftException;
import com.revature.exceptions.WrongUsernameOrPasswordException;

public class BankDTOImplTest {

	@Mock
	UserDAO udMock;

	@Mock
	AccountDAO adMock;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Test
	public void testGetUser() {
		User user = new User();

		when(udMock.getUserById(1)).thenReturn(user);

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		User newUser = bdto.getUser(1);

		assertEquals(user, newUser);

		verify(udMock).getUserById(1);

	}

	@Test
	public void testGetAccount() {
		Account acct = new Account();

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		when(adMock.getAccountById(1)).thenReturn(acct);

		Account acct2 = bdto.getAccount(1);

		assertEquals(acct, acct2);

		verify(adMock).getAccountById(1);

	}

	@Test
	public void testGetUsers() {
		List<User> users = new ArrayList<>();

		when(udMock.getUsers()).thenReturn(users);

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		List<User> newUsers = bdto.getUsers();

		assertEquals(users, newUsers);

		verify(udMock).getUsers();

	}

	@Test
	public void testUserSignIn() throws WrongUsernameOrPasswordException {
		User user = new User();

		when(udMock.signIn("test", "test")).thenReturn(user);

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		User newUser = bdto.signIn("test", "test");

		assertEquals(user, newUser);

		verify(udMock).signIn("test", "test");

	}

	@Test
	public void testUserSignInException() throws WrongUsernameOrPasswordException {
		String output = "";
		when(udMock.signIn("test", "test")).thenReturn(null);

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		User newUser = null;

		try {
			newUser = bdto.signIn("test", "test");
		} catch (WrongUsernameOrPasswordException e) {
			output = e.getMessage();
		}

		assertNull(newUser);
		assertEquals(output, "Incorrect Username or Password.");

		verify(udMock).signIn("test", "test");

	}

	@Test
	public void testDeleteUser() {
		User user = new User();

		when(udMock.getUserById(1)).thenReturn(user);

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		bdto.deleteUser(1);

		verify(udMock).deleteUser(user);

	}

	@Test
	public void testDeleteAccount() {

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		bdto.deleteAccount(1);

		verify(adMock).deleteAccount(1);

	}

	@Test
	public void testCreateUser() {
		User user = new User();

		when(udMock.createUser(user)).thenReturn(user);

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		User newUser = bdto.createUser(user);

		assertEquals(user, newUser);

		verify(udMock).createUser(user);

	}

	@Test
	public void testWithdrawAmount() throws NegativeAmountException {

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		try {
			bdto.withdrawAmount(1, 100);
			verify(adMock).withdrawAmount(1, 100);
		} catch (OverdraftException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testWithdrawAmountOverdraft() throws OverdraftException {

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);
		String output = "";
		doThrow(new OverdraftException()).when(adMock).withdrawAmount(1, 100);
		
		try {
			bdto.withdrawAmount(1, 100);
			
		} catch (OverdraftException e) {
			output = e.getMessage();
		} catch (NegativeAmountException e) {
			e.printStackTrace();
		}
		
		assertEquals("Not enough money in account to withdraw given amount", output);
		
		try {
			verify(adMock).withdrawAmount(1, 100);
		} catch (OverdraftException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testWithdrawAmountNegativeAmount() {
		String output = "";

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		try {
			bdto.withdrawAmount(1, -100);
		} catch (NegativeAmountException e) {
			output = e.getMessage();
		} catch (OverdraftException e) {
			e.printStackTrace();
		}

		assertEquals("Amount cannot be negtive or zero", output);

	}

	@Test
	public void testWithdrawAmountZeroAmount() {
		String output = "";

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		try {
			bdto.withdrawAmount(1, 0);
		} catch (NegativeAmountException e) {
			output = e.getMessage();
		} catch (OverdraftException e) {
			e.printStackTrace();
		}

		assertEquals("Amount cannot be negtive or zero", output);

	}

	@Test
	public void testDepositmount() throws NegativeAmountException {

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		bdto.depositAmount(1, 100);

		verify(adMock).depositAmount(1, 100);

	}

	@Test
	public void testDepositAmountNegativeAmount() {
		String output = "";

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		try {
			bdto.depositAmount(1, -100);
		} catch (NegativeAmountException e) {
			output = e.getMessage();
		}

		assertEquals("Amount cannot be negtive or zero", output);

	}

	@Test
	public void testDepositAmountZeroAmount() {
		String output = "";

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		try {
			bdto.depositAmount(1, 0);
		} catch (NegativeAmountException e) {

			output = e.getMessage();
		}

		assertEquals("Amount cannot be negtive or zero", output);

	}

	@Test
	public void testUpdateAccount() {
		Account acct = new Account();

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		bdto.updateAccount(acct);

		verify(adMock).updateAccount(acct);

	}

	@Test
	public void testUpdateUser() {
		User user = new User();

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		bdto.updateUser(user);

		verify(udMock).updateUser(user);

	}

	@Test
	public void testCheckUsernameTrue() {
		User user = new User();

		when(udMock.getUserByUsername("user")).thenReturn(user);

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);
		assertFalse(bdto.checkUsername("user"));

	}

	@Test
	public void testCheckUsernameFalse() {

		when(udMock.getUserByUsername("user")).thenReturn(null);

		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock);

		assertTrue(bdto.checkUsername("user"));

	}

}
