package com.revature.homework1;

import java.util.Scanner;

public class Question17 {
	
	
	public static double simpleCalculation(double principle, double interest, double years) {
		double accruedAmount = principle*(1+(interest*years));
		
		return accruedAmount;
		
	}
	
	
	public static void main(String[] args) {
		// obtains user input and assigns it to three different variables
		// uses parseDouble to turn the string into a double object that is abloe to pass through the simple calculator function
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter principle amount without commas: ");
		String principleString = sc.nextLine();
		double principleAmount = Double.parseDouble(principleString);


		System.out.println("Enter rate of interest: ");
		String interestString = sc.nextLine();
		double interestAmount = Double.parseDouble(interestString);

		System.out.println("Enter number of years: ");
		String yearString = sc.nextLine();
		double yearAmount = Double.parseDouble(yearString);
		
		double finalCalculation = simpleCalculation(principleAmount, interestAmount, yearAmount);
		
		
		System.out.println(finalCalculation);
		
		
		
		

	}

}
