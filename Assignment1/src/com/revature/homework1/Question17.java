package com.revature.homework1;

import java.util.Scanner;

public class Question17
{
	public static void printPrincipal()
	{
		Scanner sc = new Scanner(System.in);
		double principal = 0.0;
		double rate = 0.0;
		double time = 0.0;
		
		String input = "";
		
		boolean pass = false;
		do
		{
			System.out.println("What is your principal?");
			input = sc.nextLine();
			if(input.matches("^\\d+(\\.\\d{1,2})?$"))
			{
				principal = Double.parseDouble(input);
				System.out.println("Principal"+principal);
				pass = true;
			}
		}while(!pass);
		
		pass = false;
		do
		{
			System.out.println("What is your rate?");
			input = sc.nextLine();
			if(input.matches("^\\d+(\\.\\d{1,2})?$"))
			{
				rate = Double.parseDouble(input);
				System.out.println("rate"+rate);
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
				System.out.println("time"+time);
				pass = true;
			}
			
		}while(!pass);
		
		System.out.println(calcInterest(principal, rate, time));
	}
	
	public static double calcInterest(double principal, double rate, double time)
	{
		return (principal*(1+(rate*time)));
	}
}
