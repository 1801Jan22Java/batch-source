package com.revature.homework1;

/**
 * Homework 1. Question 2. Fibonacci numbers.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question2 {
	
	/**
	 * Displays to the console the series of Fibonacci numbers starting at 0 up to the 
	 * given limit. For example, generateFibonacci(25) generates the first 25 numbers 
	 * in the series. If limit given is less than one, generates nothing.
	 * 
	 * @param limit The amount of Fibonacci numbers to generate
	 * @return No return value
	 */
	private static void generateFibonacci(int limit) {
		// First and second terms in Fib. sequence is 0 and 1
		int first = 0;
		int second = 1;
		
		// Memoized Fibonacci
		for (int i = 0; i < limit; i++) {
			// If limit is at least 1, first is always generated
			System.out.print(first + " ");
			
			// Change the value of first to that of second
			int temp = first;
			first = second;
			
			// Change the value of second to the sum of itself and
			// the previous value of first
			second += temp;
		}
		
		System.out.println();
	}

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		
		int limit = 25;
		
		generateFibonacci(limit);
		
	}

}
