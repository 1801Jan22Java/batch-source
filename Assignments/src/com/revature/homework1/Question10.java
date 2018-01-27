package com.revature.homework1;

import java.util.Scanner;

/*
 * Author: Calvin Milliron
 * Assignment: Find the minimum of two numbers using ternary operators.
 * Status: Done
 */
public class Question10 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double firstValue = 0.0;
		double secondValue = 0.0;
		// Assume the user entered an invalid value
		boolean validInput = false;
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.print("Enter the first number for comparison: ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextDouble()) {
				firstValue = input.nextDouble();
				validInput = true;
			} else {
				System.out.println("Sorry, that wasn't a number.");
				input.next();
			}
		}
		
		// Assume the user entered an invalid value
		validInput = false;
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.print("Enter the second number for comparison: ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextDouble()) {
				secondValue = input.nextDouble();
				validInput = true;
			} else {
				System.out.println("Sorry, that wasn't a number.");
				input.next();
			}
		}
		// Convert result into a string for parsing
		String firstValueString = Double.toString(firstValue);
		// If the result is a whole number the double type will add '.0' afterward, truncate result if present
		if (firstValueString.charAt(firstValueString.length() - 1) == '0' && firstValueString.charAt(firstValueString.length() - 2) == '.' ) {
			int temp = (int)firstValue;
			firstValueString = Integer.toString(temp);
		}
		// Convert result result into a string for parsing
		String secondValueString = Double.toString(secondValue);
		// If the result is a whole number the double type will add '.0' afterward, truncate result if present
		if (secondValueString.charAt(secondValueString.length() - 1) == '0' && secondValueString.charAt(secondValueString.length() - 2) == '.' ) {
			int temp = (int)secondValue;
			secondValueString = Integer.toString(temp);
		}
		// First ternary operator checks if the numbers are equal, a second ternary operator is present in the else section of the first ternary operator
		// If the first ternary operator reaches its else, the second ternary operator checks if the first value is greater than the second value
		System.out.println((firstValue == secondValue) ? "The numbers are equal to eachother." : ((firstValue > secondValue) ? "The first number (" + firstValueString + ") is greater than the second number (" + secondValueString + ")." : "The second number (" + secondValueString + ") is greater than the first number (" + firstValueString + ")."));
		input.close();
	}

}
