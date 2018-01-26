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
		int num = 1;
		
		int[] nums = {2, -1, 1};
		
		for (int i : nums) {
			System.out.print("Between the two numbers " + num + " and " + i);
			System.out.println(", the smaller number, if one exists, is: " + findMin(num, i));
		}
	}

}
