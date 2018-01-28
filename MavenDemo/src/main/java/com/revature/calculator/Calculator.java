package com.revature.calculator;

public class Calculator {

	/*
	 * Requirement 1: create a String calculator with a method in add String(numbers)
	 * The method can take 0,1 or 2 numbers, delimited by a comma
	 */
	
	public static int add(String numbers) {
		int sum = 0;
		String[] numbersArray = numbers.split(",");
		if(numbersArray.length>2) {
			throw new RuntimeException("too many numbers!");
			//could also throw a custom checked exception
		}
		return sum;
	}
}
