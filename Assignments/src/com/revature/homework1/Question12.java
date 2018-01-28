package com.revature.homework1;

public class Question12 {
	public static int[] primesUpTo(int size) {
		int arrSize = size;
		int[] evens = new int[arrSize / 2];
		// creates an array of size number fills with numbers 1 to size
		int[] numbers = new int[100];
		for (int i = 0; i < 100; i++) {
			numbers[i] = i + 1;
		}
		// for every number in the numbers array
		for (int j : numbers) {
			// if that number is even
			if (j % 2 == 0) {
				// add it to the evens array at index equal to half its value
				// (done because only half of numbers is even)
				evens[(j / 2) - 1] = j;
			}
		}
		return evens;
	}
}
