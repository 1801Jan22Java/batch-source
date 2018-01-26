package com.revature.homework1;

import java.util.Scanner;

public class Question17 {
	
	public static void interestAmt() {
		Scanner sc = new Scanner(System.in);
		System.out.println("How much was borrowed?");
		Double principal = sc.nextDouble();
		System.out.println("What is the rate of interest?");
		Double rate = sc.nextDouble();
		System.out.println("How many years has passed?");
		int year = sc.nextInt();
		
		sc.close();
		double interest = principal*(1 + rate/100 * year);
		System.out.println(interest);
		
	}
}
