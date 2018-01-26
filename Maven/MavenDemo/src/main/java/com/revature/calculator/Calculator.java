package com.revature.calculator;

public class Calculator {

	/*
	 * Requirement 1: create a String calculator with a method int add
	 * the method can take 0, 1, or 2 numbers delimited by a comma 
	 */
	
	public static int add(String numbers) {
		Integer sum = 0;
		String[] numbersArray = numbers.split(",");
		if(numbersArray.length > 2)
			throw new RuntimeException("too many numbers!");
		return sum;
	}
	
}
