package com.revature.homework1;

import java.util.Scanner;

/*
 * Author: Calvin Milliron
 * Assignment: Write a program to determine if an integer is even without using the modulus operator (%)
 * Status: Done
 */
public class Question06 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int value = 0;
		// Assume the user entered an invalid value
		boolean validInput = false;
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.print("Enter a whole number: ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				value = input.nextInt();
				validInput = true;
			} else {
				System.out.println("Sorry, that wasn't a whole number.");
				input.next();
			}
		}
		// Divide the number by 2, if the original number was odd, then the result will be truncated when multiplied by 2
		// If that quotient is less than the original number, then the then the number is odd
		if (value / 2 * 2 < value) {
			System.out.println("The number is odd.");
		// If the quotient was not truncated, then that quotient will equal the original value, proving that the number was even
		} else {
			System.out.println("The number is even.");
		}
	}
}
