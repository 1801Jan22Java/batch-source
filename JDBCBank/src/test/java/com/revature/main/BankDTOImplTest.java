package com.revature.main;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
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
import com.revature.exceptions.WrongUsernameOrPasswordException;

public class BankDTOImplTest {
	
	@Mock
	UserDAO udMock;
	
	@Mock
	AccountDAO adMock;
	
	 @Rule public MockitoRule mockitoRule = MockitoJUnit.rule(); 
	
	@Test
	public void testGetUser() {
		User user = new User();
		Writer wtr = new PrintWriter(System.out);
		
		when(udMock.getUserById(1)).thenReturn(user);
		
		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock, wtr);
		
		User newUser = bdto.getUser(1);
		
		assertEquals(user, newUser);
		
		verify(udMock).getUserById(1);
		
	}
	
	@Test
	public void testGetAccount() {
		Account acct = new Account();
		Writer wtr = new PrintWriter(System.out);
		
		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock, wtr);
		
		when(adMock.getAccountById(1)).thenReturn(acct);
		
		Account acct2 = bdto.getAccount(1);
		
		assertEquals(acct, acct2);
		
		verify(adMock).getAccountById(1);
		
	}
	
	@Test
	public void testGetUsers() {
		List<User> users = new ArrayList<>();
		Writer wtr = new PrintWriter(System.out);
		
		when(udMock.getUsers()).thenReturn(users);
		
		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock, wtr);
		
		List<User> newUsers = bdto.getUsers();
		
		assertEquals(users, newUsers);
		
		verify(udMock).getUsers();
		
	}
	
	@Test
	public void testUserSignIn() throws WrongUsernameOrPasswordException {
		User user = new User();
		Writer wtr = new PrintWriter(System.out);
		
		when(udMock.signIn("test", "test")).thenReturn(user);
		
		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock, wtr);
		
		User newUser = bdto.signIn("test", "test");
		
		assertEquals(user, newUser);
		
		verify(udMock).signIn("test", "test");
		
	}
	
	@Test
	public void testUserSignInException() throws WrongUsernameOrPasswordException {
		User user = new User();
		String output = "";
		Writer wtr = new StringWriter();
		
		when(udMock.signIn("test", "test")).thenThrow(new WrongUsernameOrPasswordException());
		
		BankDTOImpl bdto = new BankDTOImpl(udMock, adMock, wtr);
		
		User newUser = bdto.signIn("test", "test");
		
		output = wtr.toString();
		
		assertNull(newUser);
		
		assertEquals(output, "Incorrect Username or Password.\n");
		
		verify(udMock).signIn("test", "test");
		
	}
	
}
