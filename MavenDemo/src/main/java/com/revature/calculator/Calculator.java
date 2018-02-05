package com.revature.calculator;

public class Calculator
{
	/**
	 * Requirements
	 * 1. create a String calculator with a method: int add(String numbers).
	 * 		The method can take 0,1,2 numbers, delimited by a coma
	 */
	public static int add(String numbers)
	{
		int sum = 0;
		String[] numsArray = numbers.split(",");
		if(numsArray.length > 2)
			throw new RuntimeException("too many numbers");
		//could also throw a custom checked exception
		return sum;
	}
}
