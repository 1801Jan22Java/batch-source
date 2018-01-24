package com.revature.homework1;

/**
 * Homework 1. Question 10. Ternary minimum.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question10 {
	
	/**
	 * Returns the minimum of two numbers.
	 * 
	 * @param a The first number
	 * @param b The second number
	 * @return The minimum of a and b. If a = b, returns a
	 */
	private static int findMin(int a, int b) {
		return a < b ? a : b;
	}

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c = -1;
		int d = 1;
		
		String template1 = "Between the two numbers ";
		String template2 = " and ";
		String template3 = ", the smaller number, if one exists, is: ";
		
		System.out.println(template1 + a + template2 + b + template3 + findMin(a, b));
		System.out.println(template1 + a + template2 + c + template3 + findMin(a, c));
		System.out.println(template1 + a + template2 + d + template3 + findMin(a, d));
	}

}
