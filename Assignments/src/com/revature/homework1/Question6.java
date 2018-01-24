package com.revature.homework1;

/**
 * Homework 1. Question 6. Is even.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question6 {
	
	/**
	 * Returns true if the given integer is even. False otherwise.
	 * 
	 * @param n The number to determine if even or odd
	 * @return True if n is even. False otherwise.
	 */
	private static boolean isEven(int n) {
		// If last bit is 0, n is even. If last bit is 1, n is odd.
		return (n & 1) == 0;
	}

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		int c = 2;
		int d = 3;
		// 2,147,483,647
		int e = Integer.MAX_VALUE;
		// -2,147,483,648
		int f = Integer.MIN_VALUE;
		
		String template1 = "It is ";
		String template2 = " that ";
		String template3 = " is even.";
		
		System.out.println(template1 + isEven(a) + template2 + a + template3);
		System.out.println(template1 + isEven(b) + template2 + b + template3);
		System.out.println(template1 + isEven(c) + template2 + c + template3);
		System.out.println(template1 + isEven(d) + template2 + d + template3);
		System.out.println(template1 + isEven(e) + template2 + e + template3);
		System.out.println(template1 + isEven(f) + template2 + f + template3);
	}

}
