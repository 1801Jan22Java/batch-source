package com.revature.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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

	private final String welcome = "Welcome to the JDBC Banking App\nPlease either 'Login' or 'Register' new account\n";
	private final String login = "Please enter user name\nPlease enter password\n";
	private final String mainSelect = "Please select an option\n" + "1. View accounts and balances.\n"
			+ "2. Create an account.\n" + "3. Delete an account\n" + "4. Deposit amount into account\n"
			+ "5. Withdraw amount from account\n" + "6. Logout\n" + "7. Quit\n\n";
	private final String register = "";
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

		assertTrue(output != null);
		
		verify(dtoMock).signIn("test", "user");

	}
	
	@Test
	public void testWelcomeFailedSignInQuit() throws WrongUsernameOrPasswordException {
		String input = "lOgIn\ntest\nuser\nright\nuser\n7\n";
		StringReader rdr = new StringReader(input);
		StringWriter wtr = new StringWriter();
		String output = "";

		when(dtoMock.signIn("right", "user")).thenReturn(new User());

		Bank bank = new Bank(rdr, wtr, dtoMock);

		bank.startBank();

		output = wtr.toString().trim();

		assertTrue(output != null);
		
		verify(dtoMock).signIn("test", "user");
		verify(dtoMock).signIn("right", "user");

	}
}
