package com.revature.homework1;

import java.util.Scanner;

public class Question17
{
	public static void printPrincipal()
	{
		//sc is of type Scanner and will be used to read in user input
		Scanner sc = new Scanner(System.in);
		double principal = 0.0;
		double rate = 0.0;
		double time = 0.0;
		
		String input = "";
		
		//flag
		boolean pass = false;
		
		//continue to prompt the user for a value for principal until
		do
		{
			System.out.println("What is your principal?");
			input = sc.nextLine();
			//they provide a value that is a int or double.
			if(input.matches("^\\d+(\\.\\d{1,2})?$"))
			{
				//set the value of principal to their input
				//once they do.
				principal = Double.parseDouble(input);
				System.out.println("Principal = "+principal);
				pass = true;
			}
		}while(!pass);
		
		//reset the flag.
		pass = false;
		do
		{
			System.out.println("What is your rate?");
			input = sc.nextLine();
			if(input.matches("^\\d+(\\.\\d{1,2})?$"))
			{
				rate = Double.parseDouble(input);
				System.out.println("Rate = "+rate);
				pass = true;
			}
			
		}while(!pass);
		
		pass = false;
		do
		{
			System.out.println("What is your time?");
			input = sc.nextLine();
			if(input.matches("^\\d+(\\.\\d{1,2})?$"))
			{
				time = Double.parseDouble(input);
				System.out.println("Time = "+time);
				pass = true;
			}
			
		}while(!pass);
		
		//print the interest
		System.out.println("Interest = "+calcInterest(principal, rate, time));
		//close the scanner to prevent resource leakage.
		sc.close();
	}
	
	public static double calcInterest(double principal, double rate, double time)
	{
		return (principal*(1+(rate*time)));
	}
}
