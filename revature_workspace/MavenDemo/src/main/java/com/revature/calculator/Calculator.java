package com.revature.calculator;

public class Calculator {

	/*
	 * Requirement 1: create a String calculator with a method int add
	 * String(numbers) The method can take 0,1, or 2 number, delimited by a
	 * comma Requirement 2: the method will return their sum Requirement 3:
	 * empty string returns zero
	 */

	public static int add(String numbers) {
		int sum = 0;
		String[] numbersArray = numbers.split(",");
		if (numbersArray.length > 2) {
			throw new RuntimeException("too many numbers!");
			// could also throw a custom checked exception
		}
		if (numbers.equals("")) {
			return sum;
		} else {
			for (String number : numbersArray) {
				if (!number.equals("")) {
					sum += Integer.parseInt(number);
					// shorthand for sum = sum + ...things..
				} else {
					continue; // allow for consecutive commas
				}
			}
		}

		return sum;
	}
}