package com.revature.homework1;

import java.util.Scanner;

/*
 * Author: Calvin Milliron
 * Assignment: Find the minimum of two numbers using ternary operators.
 */
public class Question10 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int intValue = 0;
		double doubleValue = 0.0;
		// Assume the user entered an invalid value
		boolean validInput = false;
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.print("Enter the first number: ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				intValue = input.nextInt();
				validInput = true;
			} else if (input.hasNextDouble()) {
				doubleValue = input.nextDouble();
				validInput = true;
			} else {
				System.out.println("Sorry, that wasn't a whole number.");
				input.next();
			}
		}
	}

}
