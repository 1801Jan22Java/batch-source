package com.revature.homework1;
/*
 * Write a program to determine if an integer is even without using the modulus operator (%)
 */
import java.util.Scanner;
public class Question6 
{
	public static String isEven(int n)
	{
		if(Math.ceil((double)n/2) > Math.floor((double)n/2)) 
		{
			return "Odd";
		}
		else
		{
			return "Even";
		}
	}
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);  
		System.out.print("Enter an Integer: ");
		int n = input.nextInt(); 
		System.out.println(n + " is "+isEven(n));
		input.close();
	}
}
