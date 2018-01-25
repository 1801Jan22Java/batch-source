package com.revature.homework1;

import java.util.Scanner;

/*
Write a program that calculates the simple interest on the principal, 
rate of interest and number of years provided by the user. Enter 
principal, rate and time through the console using the Scanner class.
Accrued amount = Principal*(1+ Rate* Time)
*/

public class Question17 {
	public static void main(String[] args) {
		System.out.format("$%.2f",getInterest());
	}
	
	private static Double calcInterest(Double Principal, Double Rate, Double Time) {
		Double amount = Principal*(1+Rate*Time);
		
		return amount;
	}
	
	public static Double getInterest() {
		// Prompt user
		System.out.println("Enter the Principle, Rate, and Years separated by spaces");
		
		// Get the user input, close input stream
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		Double prin = 0.0;
		Double rate = 0.0;
		Double time = 0.0;
		
		try {
			// Split the string based on a space.
			// \\s is used instead of " ".
			String[] separated = input.split("\\s");
			if(separated.length!=3) {
				throw new IllegalArgumentException("Number of values is incorrect.");
			}
			
			prin = Double.parseDouble(separated[0]);
			rate = Double.parseDouble(separated[1]);
			time = Double.parseDouble(separated[2]);
		} catch(NumberFormatException e) {
			System.out.println("Please use proper numbers.");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} 
		
		// Do the calculation and return the answer
		return calcInterest(prin, rate, time);
	}
}
