package com.revature.homework1;

import java.util.Date;
import java.util.Scanner;

// Q14. Write a program that demonstrates the switch case. Implement the following
// functionalities in the cases:java
// Case 1: Find the square root of a number using the Math class method.
// Case 2: Display today’s date.
// Case 3: Split the following string and store it in a string array.
// “I am learning Core Java”
//Created by: KP Saini

public class Question14 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String doSwitchString;
		int doSwitch;
		do {
			try {
		
				System.out.println("\nEnter the number corresponding to the desired option: "
						+ "\n1 - Take the square root of a number "
						+ "\n2 - Display today's date"
						+ "\n3 - Display a message"
						+ "\n0 - Exit program");
				
				doSwitchString = input.nextLine();
				doSwitch = Integer.parseInt(doSwitchString);
				
				switch (doSwitch) {
				case 0:				// exit the program
					return;
	
				case 1:
					squareRoot();	// invoke the squareRoot() method
					break;
					
				case 2:	// display today's date to the console
					Date date = new Date();
					System.out.println("Today's date is: " + date);
					break;
					
				case 3:	// spit the String "I am learning Core Java" into a String array and print it to the console
					String coreJava = "I am learning Core Java";
					String[] coreJavaArray = coreJava.split(" ");
					for (String s : coreJavaArray) {
						System.out.println(s);
					}
					break;

				default:	// default case
					System.out.println("Invalid input!");
					break;
				}

			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");	// display message for incorrect input
			}
		} while (true);	
		
	}
	
	// function to compute the square root of a double number entered from the keyboard
	public static void squareRoot() {
		String numberString;
		double number;
		do {
			try {
				System.out.println("Enter a value to take the square root of: ");
				numberString = input.nextLine();
				number = Double.parseDouble(numberString);
				
				// display the result to the console by calling Math.sqrt()
				System.out.println("The square root of " + number + " is: " + Math.sqrt(number));
				return;

			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		} while (true);	
		
	}
}
