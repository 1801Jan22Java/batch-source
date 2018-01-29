package com.revature.homework1;

/**
 * @author Calvin Milliron
 * Assignment: Write a program to store numbers from 1 to 100 in an array. 
 * 		Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
 * Status: Done
 */
public class Question12 {

	public static void main(String[] args) {
		// Build array of numbers from 1 to 100
		int[] numbers = new int[100];
		for(int i = 0; i < 100; i++) { numbers[i] = i + 1; }
		int count = 0;
		System.out.println("Even numbers between 1 and 100:");
		// Step through all number in the array
		for(int x : numbers) {
			// If even, display number in console
			if (x % 2 == 0) {
				// Only show 10 in a row
				if (count % 10 == 0 && count > 0) { System.out.println(", "); }
				else if (count > 0) { System.out.print(",\t"); }
				System.out.print(x);
				count++;
			}
		}
	}

}
