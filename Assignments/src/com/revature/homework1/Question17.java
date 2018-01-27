package com.revature.homework1;
//James Whitten

import java.util.Scanner;

public class Question17 {

	double accAmount =0.0, principal, rateOfInt;
	int yearint;
	
	//Calculates the interest to the nearest cent (A bit redundant due to the print formatting in main)
	public double calculateInterest(double princ, double roi, int years)
	{
		double totalInt = Math.round((princ*((1+roi)*years))*100);
		totalInt = totalInt/100.0;
		return totalInt;
	}
	
	//Our main
	public static void main(String[] args) {
			
		//Our scanner
		Scanner sc = new Scanner(System.in);
		//Creating the Question17 object
		Question17 q17 = new Question17();
		
		//Prompt user until a negative calculation
		do {
			System.out.println("Input the principal amount, a negative number will exit after the calculation.");
			//Gets the principal
			q17.principal = sc.nextDouble();
			System.out.println("Input the interest rate amount, a negative number will exit after the calculation.");
			//Gets the interest
			q17.rateOfInt = sc.nextDouble();
			System.out.println("Input the number of years the interest has accrued, a negative number will exit");
			//Gets the years accrued 
			q17.yearint = (int) sc.nextDouble();
			//Checks if the program should exit
			q17.accAmount = q17.calculateInterest(q17.principal, q17.rateOfInt, q17.yearint);
			//Shows the interest in dollar format
			System.out.format("The total interest is: $ %.2f%n" , q17.accAmount);
		} while (q17.accAmount >= 0.0);
		
		
	}
	
}
