package com.revature.calculator;

public class Calculator {

	/*
	 * Requirement 1: create aString calculator with a method int add String
	 * (Number) 
	 * The method can take 0,1, or 2 number, delimided by a comma
	 */
	
	public static int add(String numbers) {
		int sum =0;
		String[] numbersArray = numbers.split(",");
		if(numbersArray.length>2) {
			throw new RuntimeException("too many numbers!");
		}
		return sum;
	}
}
