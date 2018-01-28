package com.revature.homework1;

import java.util.Scanner;

// Q17. Write a program that calculates the simple interest on the principal, rate of interest and
// number of years provided by the user. Enter principal, rate and time through the console using
// the Scanner class.
// Accrued amount = Principal*(1+ Rate* Time)
// Created by: KP Saini

public class Question17 {
	
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		computeSimpleInterest();	// invoke computeSimpleInterest
	}
	
	// take the input arguments from the keyboard and display the simple interest
	// along with the accrued amount
	public static void computeSimpleInterest() {
		String principalString;
		double principal;
		String rateOfInterestString;
		double rateOfInterest;
		String numberOfYearsString;
		int numberOfYears;
		
		do {
			try {
				System.out.println("Enter the principal amount: ");
				principalString = input.nextLine();
				principal = Math.abs(Double.parseDouble(principalString));
				
				System.out.println("Enter the annual rate of interest in percent: ");
				rateOfInterestString = input.nextLine();
				rateOfInterest = Math.abs(Double.parseDouble(rateOfInterestString)/100);
				
				System.out.println("Enter the number of years: ");
				numberOfYearsString = input.nextLine();
				numberOfYears = Math.abs(Integer.parseInt(numberOfYearsString));
				
				double accruedAmount = principal * (1 + rateOfInterest * numberOfYears);
				System.out.println("The accrued amount is: $" + accruedAmount);
				
				double simpleInterest = accruedAmount - principal;
				System.out.println("The simple interest is: $" + simpleInterest);
				
				return;

			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		} while (true);	
		
	}
}
