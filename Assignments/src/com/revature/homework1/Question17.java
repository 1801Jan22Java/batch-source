package com.revature.homework1;

import java.util.Scanner;

/*
 * Write a program that calculates the simple interest on the principal, 
 * rate of interest and number of years provided by the user. 
 * Enter principal, rate and time through the console using the Scanner class.
 * Accrued amount = Principal*(1+ Rate* Time)
 */

public class Question17 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		double principal, rate, time, result;

		System.out.println("Please enter a Principle amount.");
		principal = scan.nextDouble();
		scan.nextLine();

		System.out.println("Please enter a Rate.");
		rate = scan.nextDouble();
		scan.nextLine();

		System.out.println("Please enter number of days passed.");
		time = scan.nextDouble();
		scan.nextLine();

		result = principal * (1 + rate * time);

		System.out.println("Accrued amount = $" + result);

	}

}
