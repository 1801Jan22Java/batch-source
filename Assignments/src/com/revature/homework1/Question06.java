package com.revature.homework1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Calvin Milliron
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
			System.out.print("Tell me a number and I'll tell you if it is even: ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				value = input.nextInt();
				validInput = true;
			} else {
				if (input.hasNextDouble()) {
					System.out.println("Sorry, that number was too big, try something smaller.\n");
				} else {
					System.out.println("Sorry, that wasn't a whole number.\n");
				}
				input.next();
			}
		}
		// Divide the number by 2, if the original number was odd, then the result will be truncated when multiplied by 2
		// If that quotient is less than the original number, then the then the number is odd
		DecimalFormat df = new DecimalFormat("#,###");
		if (value / 2 * 2 < value) {
			System.out.println("The number " + df.format(value) + " is odd.");
		// If the quotient was not truncated, then that quotient will equal the original value, proving that the number was even
		} else {
			System.out.println("The number " + df.format(value) + " is even.");
		}
	}
}
