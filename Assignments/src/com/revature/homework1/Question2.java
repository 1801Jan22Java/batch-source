package com.revature.homework1;
/*
 * Write a program to display the first 25 Fibonacci numbers beginning at 0.
 */
public class Question2 
{
	//I broke this program into two tasks, finding the nth Fibonacci number 
	//and then printing out the Fibonacci numbers
	
	//This method just finds the nth fib number
	public static int fib(int n)
	{
		//Starting with the base cases
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else
			return fib(n-1) + fib(n-2);
	}
	//this method calls fib to print out the first n Fibonacci numbers 
	public static void printFib(int n)
	{
		for(int i = 0; i < n; i++)
		{
			System.out.println(fib(i));
		}
	}
	public static void main(String args[])
	{
		printFib(25);
	}
}
