package com.revature.calculator;

public class Calculator {

	/*
	 * Requirement 1: create a String calculator with a method int add
	 * The method can take 0, 1, or 2 number, delimited by a comma
	 */
	
	public static int add(String numbers) {
		int sum = 0;
		String[] numbersArray = numbers.split(",");
		if(numbersArray.length > 2) {
			throw new RuntimeException("too many numbers!");	// in reality we would make custom checked exceptions
																// of things we were expecting to go wrong
		}
		return sum;
	}
}
