package com.revature.homework1;

import java.util.Scanner;
import java.time.*;
import java.time.format.*;

/**
 * @author Calvin Milliron
 * Assignment: Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java 
 *		Case 1: Find the square root of a number using the Math class method.
 *		Case 2: Display today’s date.
 *		Case 3: Split the following string and store it in a string array. "I am learning Core Java"
 * Status: Done
 */
public class Question14 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = 0;
		boolean validInput = false;
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.println("What would you like to do?");
			System.out.println("1. Find the square root of a number");
			System.out.println("2. Display today's date");
			System.out.println("3. Split \"I am learning Core Java\"");
			System.out.print("Choice -> ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				number = input.nextInt();
				if (number > 0 && number < 4) {
					validInput = true;
				} else {
					System.out.println("Sorry, that wasn't one of the options.");
				}
			} else {
				System.out.println("Sorry, that wasn't an integer.");
				input.next();
			}
		}
		System.out.println();
		// Switch between possible choices from the menu, calling necessary method
		switch(number) {
		case 1:
			squareRoot();
			break;
		case 2:
			todaysDate();
			break;
		case 3:
			splitString();
			break;
		default:
			System.out.println("No option was selected.");
			break;
		}
	}
	
	static void squareRoot() {
		// Find the square root of a number using the Math class method.
		Scanner input = new Scanner(System.in);
		String numberType = "int";
		int intNumber = 0;
		double doubleNumber = 0.0;
		boolean validInput = false;
		double result = 0.0;
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.print("Please enter a number: ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			// If the user wants to use int, call nextInt(), and store choice
			if (input.hasNextInt()) {
				intNumber = input.nextInt();
				numberType = "int";
				validInput = true;
			// If the user wants to use a double, call nextDouble(), and store choice
			} else if (input.hasNextDouble()) {
				doubleNumber = input.nextDouble();
				numberType = "double";
				validInput = true;
			} else {
				System.out.println("Sorry, that wasn't a number.");
				input.next();
			}
		}
		// If the user entered an int, find square root of intNumber
		if (numberType.equals("int")) {
			result = Math.sqrt(intNumber);
			System.out.print("The square root of " + intNumber + " is ");
		// Otherwise, find the square root of doubleNumber
		} else {
			result = Math.sqrt(doubleNumber);
			System.out.print("The square root of " + doubleNumber + " is ");
		}
		// Convert square root result into a string for parsing
		String resultString = Double.toString(result);
		// If the square root is a whole number the double type will add '.0' afterward, truncate result if present
		if (resultString.charAt(resultString.length() - 1) == '0' && resultString.charAt(resultString.length() - 2) == '.' ) {
			System.out.println((int)result + ".");
		// Display raw result if '.0' is not the end of the string indicating a decimal result
		} else {
			System.out.println(result + ".");
		}
	}
	
	static void todaysDate() {
		// Display today’s date.
		System.out.println("Today's date is " + LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM, dd yyyy")) + ".");
	}
	
	static void splitString() {
		// Split the following string and store it in a string array. "I am learning Core Java"
       	String str = new String("I am learning Core Java");
       	String[] strArray = str.split(" ");
       	for(String x : strArray) {
       		System.out.println(x);
       	}
	}

}
