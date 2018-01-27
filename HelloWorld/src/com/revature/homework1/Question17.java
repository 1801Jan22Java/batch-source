package com.revature.homework1;

import java.util.Scanner;

public class Question17 {

	/*
	 * Q17. Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. 
	 * Enter principal, rate and time through the console using the Scanner class.
		Accrued amount = Principal*(1+ Rate* Time)
	 */
	public static void main(String[] args) {
		calculator();
	}
	
	public static void calculator() {
		
		Scanner sc = new Scanner(System.in);
		double principal = 0;
		double rate = 0; 
		double time = 0;
		double result = 0;

		System.out.println("Please enter a principle.");
		principal = sc.nextDouble();
		sc.nextLine();

		System.out.println("Please enter a rate by percentage. ");
		rate = sc.nextDouble() / 100;
		sc.nextLine();

		System.out.println("Please enter number of years passed.");
		time = sc.nextDouble();
		sc.nextLine();

		result = principal * (1 + rate * time);
		result = Math.floor(result);
		System.out.println("Accrued amount :" + result);
	}
	
}
