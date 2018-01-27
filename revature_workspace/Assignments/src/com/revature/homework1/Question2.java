package com.revature.homework1;
/*
 * Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.

 * */

public class Question2 {
	
	/*
	 * Recursive (only?) solution for Fibonacci sequence.
	 * Takes n and recursively adds n-1 and n-2 to a result.
	 * */
	public static int fibonacciRecursive(int n)
	{
		
		int result =1;
		if(n==0)
		{
			return 1;
		}
		if (n==1)
		{
			return 1;
		}
		result = fibonacciRecursive(n-2)+fibonacciRecursive(n-1);
	//	System.out.print(n + " ");
		return result;
		
	}
	
	
	public static void main(String [] args)
	{
		int a=fibonacciRecursive(5);
		System.out.println(a);
	}
	
}
