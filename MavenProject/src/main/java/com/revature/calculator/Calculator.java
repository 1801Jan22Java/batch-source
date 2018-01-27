package com.revature.calculator;

public class Calculator {
	public static int add(String numbers) {
		int sum = 0;
		String[] numbersArray= numbers.split(",");
		if (numbersArray.length > 2) {
			throw new RuntimeException("too many numbers");
		}
		return sum;
	}
}
