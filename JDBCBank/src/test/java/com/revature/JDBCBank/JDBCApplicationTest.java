package com.revature.JDBCBank;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JDBCApplicationTest {
	
	//Test valid input for integer and double
	@Test
	public void validAccountAccess() {
		boolean test = false;
		try {
			String input = "1";
			String testvar = "not a number text";
			
			switch (input) {

			case "1":
				System.out.println("Choose account number to withdraw from: ");
				Integer wAccount = Integer.parseInt(testvar);
				break;

			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
			test=true;
		}
		assertTrue(test);
	}

	// Testing for ability to catch NumberFormatException for 
	// parseInt and parseDouble within the try catch.
	@Test
	public void invalidNonIntegerInputAccountAccess() {
		boolean test = true;
		try {
			String input = "1";
			String testvar = "5";
			
			switch (input) {

			case "1":
				System.out.println("Choose account number to withdraw from: ");
				Integer wAccount = Integer.parseInt(testvar);
				Double iAccount = Double.parseDouble(testvar);
				break;

			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
			test=false;
		}
		assertTrue(test);
	}
	
	// Test invalid double input
	@Test
	public void invalidNonDoubleInputAccountAccess() {
		boolean test = false;
		try {
			String input = "1";
			String testvar = "not a number text";
			
			switch (input) {

			case "1":
				System.out.println("Choose account number to withdraw from: ");
				Double wAccount = Double.parseDouble(testvar);
				break;

			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
			test=true;
		}
		assertTrue(test);
	}
	
	
}
