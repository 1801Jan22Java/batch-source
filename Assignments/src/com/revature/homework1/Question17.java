package com.revature.homework1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Calvin Milliron
 * Assignment: Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. 
 * 		Enter principal, rate and time through the console using the Scanner class.
 * 		Accrued amount = Principal*(1+ Rate* Time)
 * Status: Done
 */
public class Question17 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double principal = 0.0;
		double interestRate = 0.0;
		int years = 0;
		double accruedAmount = 0.0;
		// Assume the user entered an invalid value
		boolean validInput = false;
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.print("Please enter a principal amount: $");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextDouble()) {
				principal = input.nextDouble();
				validInput = true;
			} else {
				System.out.println("Sorry, that wasn't a dollar amount.");
				input.next();
			}
		}
		
		// Assume the user entered an invalid value
		validInput = false;
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.print("Please enter an interest rate: %");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextDouble()) {
				interestRate = input.nextDouble() / 100;
				validInput = true;
			} else {
				System.out.println("Sorry, that wasn't a percentage.");
				input.next();
			}
		}
		
		// Assume the user entered an invalid value
		validInput = false;
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.print("Please enter the number of years to calculate: ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				years = input.nextInt();
				validInput = true;
			} else {
				System.out.println("Sorry, that wasn't a valid number of years.");
				input.next();
			}
		}
		System.out.println();
		// Accrued amount = Principal*(1+ Rate* Time)
		// Truncate to 2 decimals to prevent rounding by DecimalFormat by multiplying casted int by 100, then dividing by 100.0
		accruedAmount = (int)((principal * (1+ interestRate * years))  * 100) / 100.0;
		// Format for currency
		DecimalFormat df = new DecimalFormat("#,###.00");
		System.out.println("The accrued amount is $" + df.format(accruedAmount));
	}

}
