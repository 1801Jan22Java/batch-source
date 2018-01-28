package com.revature.homework1;

public class Question2 {
	// fibonacciGen function to be called by driver class
	public static int[] fibonacciGen(int iterations) {
		// initializes return type and first two numbers in sequence
		int[] results = new int[iterations];
		results[0] = 0;
		results[1] = 1;
		// iterates the sequence generating new number based on two preceding
		for (int i = 2; i < iterations; i++) {
			results[i] = (results[i - 1] + results[i - 2]);
		}
		return results;
	}
}
