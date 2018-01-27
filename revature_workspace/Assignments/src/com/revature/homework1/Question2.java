package com.revature.homework1;

import java.util.ArrayList;

/*
 * Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.

 * */

public class Question2 {
	
	/*
	 * Recursive (only?) solution for Fibonacci sequence.
	 * Takes n and recursively adds n-1 and n-2 to a result.
	 * @param int n
	 * @return int result
	 * */

	public int fibonacciRecursive(int n)
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
		return result;
		
	}
	/*Displays first 25 fibonacci Numbers
	 * Iterates between 0 up to 25 inclusive
	 * calls fibonacciRecursive() on each integer and displays result.
	 * @param none
	 * @return void
	*/
	public void displayNums()
	{
		for(int i =0;i<=25;i++)
		{
			System.out.print(fibonacciRecursive(i)+ " ");
		}
	}
	

	
}
