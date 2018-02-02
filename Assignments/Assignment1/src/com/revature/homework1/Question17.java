package com.revature.homework1;

import java.util.Scanner;

public class Question17 {

	public static void main(String[] args) {
		// Write a program that calculates the simple interest on the principal, rate of interest and
		//number of years provided by the user. Enter principal, rate and time through the console using
		//the Scanner class.
		//Accrued amount = Principal*(1+ Rate* Time)

		System.out.println("***Interest Calculator***");
		//Get all the inputs needed for calculation
		float principle = getNumberInput("Enter principle: ");
		float rate = getNumberInput("Enter interest rate: ");
		float time = getNumberInput("Enter time (years): ");
		
		//Summarize the input and then calculate the accrued amount
		System.out.println("Principle: $" + principle);
		System.out.println("Interest Rate: " + rate + "%");
		System.out.println("Months: " + time + " years");
		System.out.println("---------");
		System.out.println("Accrued Amount: $" + principle * (1 + rate*time));
	}

	//Method which handles getting input from the user ad ensuring it is valid
		public static float getNumberInput(String prompt) {
			
			//Scanner to get input from user
			Scanner inputScan = new Scanner(System.in);
			
			boolean validInput = false;
			float num = 0.F;
			String input;
			
			while(!validInput) {
				//Prompt user for input
				System.out.println(prompt);
				validInput = true;
				input = inputScan.nextLine();
				
				//Make sure input is a float
				try{
					num = Float.parseFloat(input);
				} catch(NumberFormatException e){
					validInput = false;
				}
			}
			
			return num;
		}
}
