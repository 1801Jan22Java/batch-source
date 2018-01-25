package com.revature.homework1;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/*
 * Write a program that demonstrates the switch case. Implement the following functionalities in the 
 * cases:java 
 * Case 1: Find the square root of a number using the Math class method.
 * Case 2: Display today’s date.
 * Case 3: Split the following string and store it in a string array.“I am learning Core Java”
 */
public class Question14 
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number 1-3: ");
		int i = input.nextInt();
		switch(i)
		{
		case 1:
			System.out.println("Enter a number: ");
			double d = input.nextDouble();
			System.out.println("The squareroot of "+d+" is "+ Math.sqrt(d));
			break;
		case 2:
			System.out.println("Todays Date is "+ new Date());
			break;
		case 3:
			String[] phrase = "I am learning Core Java".split(" ");
			System.out.println(Arrays.toString(phrase));
			break;
		default:
			System.out.println("Invalid Entry");
		}
	}
}
