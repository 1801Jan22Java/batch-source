package com.revature.homework1;

/**
 * Homework 1. Question 12. Printing evens.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question12 {
	
	/**
	 * Given integer array, prints to console all even numbers within array.
	 * 
	 * @param nums The integer array from which to print evens
	 * @throws IllegalArgumentException if nums is null
	 * @return No return value
	 */
	private static void printEven(int[] nums) {
		if (nums == null) {
			throw new IllegalArgumentException();
		}
		
		for (int i : nums) {
			// If element is even, print
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		
		int[] nums = new int[100];
		
		// Fill the array to 100
		for (int i = 1; i <= 100; i++) {
			nums[i - 1] = i;
		}
		
		printEven(nums);
		
	}

}
