package com.revature.homework1;

import java.util.Scanner;

// Write a program to determine if an integer is even without using the modulus operator (%)
//Created by: KP Saini

public class Question6 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		String numberString;
		int number;
		do {
			try {
				System.out.println("Enter an integer to test if it is even: ");
				numberString = input.nextLine();
				number = Integer.parseInt(numberString);
				
				// invoke the isEven method and print the result to the console
				System.out.println(isEven(number));
				return;

			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		} while (true);	
		
	}
	
	public static boolean isEven(int number) {
		double tempNumber = (double) number;
		tempNumber = (int)((tempNumber/2 + 0.5)) - tempNumber/2;
		int testNumber = (int)(tempNumber + 0.5);
		if (testNumber == 0) {
			return true;
		}
		return false;
	}
}
