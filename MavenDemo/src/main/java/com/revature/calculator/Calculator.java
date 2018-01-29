package com.revature.calculator;

public class Calculator {
	
	/*
	 * Requirement1: create a String calculator with a mrthod int add
	 * The method can tae 0, 1, or 2 number, delimited by a comma
	 */
	
	public static int add(String numbers) {
		int sum = 0;
		String[] numbersArray = numbers.split(",");
		if (numbersArray.length > 2) {
			throw new RuntimeException("Too many numbers!");
			// could also throw a custom checked exception
		}
		
		return sum;
	}

}
