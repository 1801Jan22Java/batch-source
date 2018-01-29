package com.revature.homework1;

import java.util.Scanner;

/**
 * @author Calvin Milliron
 * Assignment: Write a program to compute N factorial.
 * Status: Done
 */
public class Question04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = 0;
		int total = 1;
		boolean isNegative = false;
		// Assume the user entered an invalid value
		boolean validInput = false;
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.print("What integer would you like to find the factorial of? ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				number = input.nextInt();
				validInput = true;
			} else {
				System.out.println("Sorry, that wasn't an integer.");
				input.next();
			}
		}
		if (number < 0) { isNegative = true; }
		// Multiply each number in sequence as if the number was positive
		for (int i = 1; i <= Math.abs(number); i++) {
			total *=  i;
		}
		// Print answer
		System.out.print("The answer is: ");
		// If the number was negative add the negative symbol to the answer
		if (isNegative) { System.out.print("-"); }
		System.out.println(total);
	}
}
