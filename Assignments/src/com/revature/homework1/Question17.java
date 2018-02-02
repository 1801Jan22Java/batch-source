package com.revature.homework1;

import java.util.Scanner;

public class Question17 {
	static double principle, time, rate;

	/*
	 * gets input from scanner 
	 */
	private static String getNumber()
	{
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		for(int i = 0; i<temp.length(); i++)					//cycle through the array
		{
			if(Character.isDigit(temp.charAt(i)) || temp.charAt(i) == '.')	 			//check each character for digit
			{
				continue;										//if its integer go to next iteration
			}
			else 
			{
				return "";										//if its anything else return empty string
			}
		}
		return temp;											//return the string when finished
	}
	
	public static void main(String[] args) {
		
		System.out.println("Input principle amount");
		String p, r, t;
		p = getNumber();									//get user input for principle amount and check it
		if (p.equals(""))
		{
			System.out.println("invalid number");			
			return;
		}
		principle = Double.parseDouble(p);					//if nothing was wrong with it convert it to double
		
		System.out.println("Input interest rate");
		r = getNumber();									//get user input for interest rate and check it
		if (r.equals(""))
		{
			System.out.println("invalid number");
			return;
		}
		rate = Double.parseDouble(r);						//if nothing was wrong with it convert it to double
		
		System.out.println("Input number of years");
		t = getNumber();									//get user input for time and check it
		if (t.equals(""))
		{
			System.out.println("invalid number");
			return;
		}
		time = Double.parseDouble(t);						//if nothing was wrong with it convert it to double
		
		double interest  = principle*(1+rate*time);			//compute the interest
		
		System.out.println("The amount of interest = " + interest);

	}

}
