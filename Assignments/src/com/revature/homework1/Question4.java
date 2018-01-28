package com.revature.homework1;

import java.util.Scanner;

//Q4. Write a program to compute N factorial.
//Created by: KP Saini

public class Question4 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String numberString;
		int number;
		do {
			try {
				System.out.println("Enter an integer to take the factorial of: ");
				numberString = input.nextLine();
				number = Integer.parseInt(numberString);
				
				// Call computeFactorial and print the returned result
				System.out.println(computeFactorial(number));
				return;

			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		} while (true);	
		
	}
	
	private static int computeFactorial(int number) {
		// If number was passed into be negative then change number to be equal to the absolute value
		if (number < 0) {
			System.out.println("The entered integer should not be negative!");
			return number;
		}
		
		// If 0 or 1 are passed in then return 0 or 1
		if (number == 0 || number == 1) {
			return number;						// return 0 or 1 and exit the method
		}
		
		int[] myArray = new int[number];		// Create an array of size number
		for (int i = 1; i <= number; i++) {		// Initialize the array with values from 
			myArray[i-1] = i; 					// 1 through number, incremeneted by 1
		}
		
		int factorial = 1;						// Create factorial variable and initialize it to 1
		for (int i = 0; i < myArray.length; i++) {
			factorial *= myArray[i]; 			// Update factorial while looping through the array
		}
		System.out.println("The answer is: ");
		return factorial;						// return factorial
	}
}
