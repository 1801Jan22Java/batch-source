package com.revature.homework1;

import java.util.Scanner;

public class Question17 {
	public static void calculateSimpleInterest() {
		// values to be parsed by scanner
		double principal;
		double rate;
		double time;
		// initialize scanner
		Scanner scanner = new Scanner(System.in);
		// output prompts and read in each value as a double
		System.out.print("Please input pricipal: ");
		principal = scanner.nextDouble();
		System.out.print("Please input the rate: ");
		rate = scanner.nextDouble();
		System.out.print("Please input the time: ");
		time = scanner.nextDouble();
		// close scanner
		scanner.close();
		// calculate interest and output in truncated format
		java.text.DecimalFormat dec = new java.text.DecimalFormat("#0.00");
		System.out.println("Accumulated amount  =  " + dec.format(principal * (1 + (rate * time))) + "\n");
	}
}
