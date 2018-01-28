package com.revature.homework1;

import java.util.Scanner;

// Q10. Find the minimum of two numbers using ternary operators.
// Created by: KP Saini

public class Question10 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String numberString, numberString2;
		double number1, number2;
		do {
			try {
				System.out.println("Determine the minimum of two numbers");
				System.out.println("Enter the first number: ");
				numberString = input.nextLine();
				number1 = Double.parseDouble(numberString);
				System.out.println("Enter the second number: ");
				numberString2 = input.nextLine();
				number2 = Double.parseDouble(numberString2);
				
				// Call computeFactorial and print the returned result
				System.out.println(minimumValue(number1, number2));
				return;

			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		} while (true);	
		
	}
	
	public static double minimumValue(double number1, double number2) {
		System.out.println("The minimum is: ");
		return (number1 < number2) ? number1 : number2;
	}
}
