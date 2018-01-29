package com.revature.homework1;

import java.util.Scanner;

/*
 * Write a program to compute N factorial.
 */
public class Question4 
{
	public static int factorial(int n)
	{
		int i;
		int t = 1;
		for( i = 1; i <= n; i++)
		{
			t *= i;
			//Debugging test to step through what is happening 
			//System.out.println(i);
		}
		return t;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an int: ");
		int i = sc.nextInt();
		System.out.println("Factorial of "+i+": " + factorial(i));

	}
}
