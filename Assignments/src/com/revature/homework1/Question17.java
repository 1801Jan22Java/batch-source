package com.revature.homework1;

import java.util.Scanner;

public class Question17 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Welcome to Simple Interest Calculator. \nPlease enter your principal:");
		double principal = scnr.nextDouble();
		System.out.println("What is your rate of interest?");
		double rateOfInterest = scnr.nextDouble();
		System.out.println("Finally, over how many years is this loan?");
		int years = scnr.nextInt();
		double accruedAmount = principal * (1+rateOfInterest*years);
			
		System.out.printf("Your accrued amount will be around %.2f", accruedAmount);
		scnr.close();
		System.exit(0);
	}
}
