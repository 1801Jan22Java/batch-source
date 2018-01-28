package com.revature.homework1;

import java.util.Scanner;

public class Question17 {

	public static void main(String[] args) {
		// create scanner to get input from user
		Scanner sc = new Scanner(System.in);
		
		//gets principal as input
		System.out.println("Enter the principal: ");
		float principal = sc.nextFloat();
		
		//gets rate as input
		System.out.println("Enter the rate of interest: ");
		float rate = sc.nextFloat();
		
		//gets years as input
		System.out.println("Enter the number of years: ");
		int years = sc.nextInt();
		
		//calculates accrued interest keeping in mind the order of operations
		double accrued = (principal * ((1 + rate) * years));
		
		//output the amount to the console
		System.out.println("Accrued amount: " + accrued);
		
		sc.close();
	}

}
