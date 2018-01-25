package com.revature.homework1;
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
		for(int i = 0; i <= 10; i++) 
		{
			System.out.println("Factorial of "+i+": " + factorial(i));
		}
	}
}
