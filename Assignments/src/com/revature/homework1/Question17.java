package com.revature.homework1;

/**
 * Created by: Jeffrey Rubi Date: 26 January 2018 
 * Write a program that calculates the simple interest on the principal, rate of interest and number of years
 * provided by the user. Enter principal, rate and time through the console using the Scanner class. 
 * Accrued amount = Principal*(1+ Rate* Time)
 */

import java.util.Scanner;

public class Question17 {

	public static void main(String[] args) {

		double principal;
		double interestRate;
		int numberOYears;
		double accruedAmt;
		double rate;
		
		// instantiate Scanner
		Scanner input = new Scanner(System.in);
		
		//  prompt user for 'principal' 
		System.out.println("Enter your principal amount: ");
		principal = input.nextDouble();
		
		// ASSUMING user will input in %, prompt user for 'interest rate'
		System.out.println("Enter your % interest rate ex.) 7.25: ");
		interestRate = input.nextDouble();
		
		// prompt user for 'years'
		System.out.println("Enter number of years: ");
		numberOYears = input.nextInt();
		
		input.close();
		
		// OBEYING to given equation, calculate 'accrued amount'
		rate = interestRate/100; // from % to decimal
		accruedAmt = principal * (1 + rate * numberOYears);
		// display result
		System.out.println("Your accrued amount is: " + accruedAmt);
		
	} // end main()

} // end class
