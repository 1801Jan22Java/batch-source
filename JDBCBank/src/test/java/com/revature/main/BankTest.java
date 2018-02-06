package com.revature.main;


import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.StringReader;
import java.io.StringWriter;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.revature.beans.User;
import com.revature.exceptions.WrongUsernameOrPasswordException;

public class BankTest {

	@Mock
	BankDTO dtoMock;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	private final String welcome = "Welcome to the JDBC Banking App\r\nPlease either 'Login' or 'Register' new account\r\n";
	private final String login = "Please enter user name\r\nPlease enter password\r\n";
	private final String mainSelect = "Please select an option\n" + "1. View accounts and balances.\n"
			+ "2. Create an account.\n" + "3. Delete an account\n" + "4. Deposit amount into account\n"
			+ "5. Withdraw amount from account\n" + "6. Logout\n" + "7. Quit\r\n";
	private String loginFail = 
			"Incorrect Username or Password.\r\n";
	private final String register = 
			"Enter first name\r\nEnter last name\r\nEnter user name\r\nEnter password\r\n";
	private final String goodBye = "Good Bye";

	@Test
	public void testWelcomeSignInQuit() throws WrongUsernameOrPasswordException {
		String input = "lOgIn\ntest\nuser\n7\n";
		StringReader rdr = new StringReader(input);
		StringWriter wtr = new StringWriter();
		String output = "";

		when(dtoMock.signIn("test", "user")).thenReturn(new User());

		Bank bank = new Bank(rdr, wtr, dtoMock);

		bank.startBank();

		output = wtr.toString().trim();

		assertEquals( welcome + login + mainSelect + goodBye, output);
		
		verify(dtoMock).signIn("test", "user");

	}
	
	@Test
	public void testWelcomeFailedSignInQuit() throws WrongUsernameOrPasswordException {
		String input = "lOgIn\ntest\nuser\nright\nuser\n7\n";
		StringReader rdr = new StringReader(input);
		StringWriter wtr = new StringWriter();
		String output = "";

		
		when(dtoMock.signIn("test", "user")).thenThrow(new WrongUsernameOrPasswordException());
		when(dtoMock.signIn("right", "user")).thenReturn(new User());

		Bank bank = new Bank(rdr, wtr, dtoMock);

		bank.startBank();

		output = wtr.toString().trim();

		assertEquals(welcome + login + loginFail + login + mainSelect + goodBye, output);
		
		verify(dtoMock).signIn("test", "user");
		verify(dtoMock).signIn("right", "user");

	}
	
	@Test
	public void testWelcomeRegisterQuit() throws WrongUsernameOrPasswordException {
		String input = "register\ntest\nuser\nusername\npassword\n7\n";
		StringReader rdr = new StringReader(input);
		StringWriter wtr = new StringWriter();
		String output = "";

		User user = new User(1, "test", "user", "username", "password", false, null);
		
		//doReturn(user).when(dtoMock).createUser(User.class);
		when(dtoMock.checkUsername("username")).thenReturn(true);

		Bank bank = new Bank(rdr, wtr, dtoMock);

		bank.startBank();

		output = wtr.toString().trim();

		assertEquals( welcome + register + mainSelect + goodBye, output);
		
		verify(dtoMock).signIn("test", "user");

	}
}
