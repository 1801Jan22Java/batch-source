package com.revature.homework1;

/**
 * Homework 1. Question 4. N!.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question4 {
	
	/**
	 * Returns factorial of given integer
	 * 
	 * @param n Integer whose factorial is to be returned
	 * @throws IllegalArgumentException if n is less than 0
	 * @return The factorial of n
	 */
	private static int factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		
		// 0! = 1
		if (n == 0) { return 1;}
		
		// Keep multiplying in descending order until we reach 1
		int result = n;
		while (n != 1) {
			n--;
			result *= n;
		}
		
		return result;
	}

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		int c = 2;
		int d = 7;
		
		String template = "! is ";
		
		System.out.println(a + template + factorial(a));
		System.out.println(b + template + factorial(b));
		System.out.println(c + template + factorial(c));
		System.out.println(d + template + factorial(d));
	}

}
