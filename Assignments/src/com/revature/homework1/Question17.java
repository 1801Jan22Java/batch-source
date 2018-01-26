package com.revature.homework1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Homework 1. Question 17. Calculating interest.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question17 {

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			// Get the principal, rate, and time
			System.out.println("Please enter principal.");
			double principal = sc.nextDouble();
			System.out.println("Please enter rate");
			double rate = sc.nextDouble();
			System.out.println("Please enter time");
			double time = sc.nextDouble();
			
			if (principal < 0 || rate < 0 || time < 0) {
				System.out.println("Cannot calculate. One of your values is negative!");
				sc.close();
				return;
			}
			
			// Now that we have all of our info, calculate interest
			double interest = principal*(1+(rate*time));
			System.out.println("Your accrued amount is " + interest);
		} catch (InputMismatchException e) {
			System.out.println("Not a number.");
			sc.close();
		}
		
		sc.close();
		
	}

}
