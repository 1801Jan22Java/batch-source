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
		
		int[] numbers = {0, 1, 2, 3, Integer.MAX_VALUE, Integer.MIN_VALUE};
		
		for (int i : numbers) {
			System.out.println("It is " + isEven(i) + " that " + i + " is even.");
		}
	}

}
