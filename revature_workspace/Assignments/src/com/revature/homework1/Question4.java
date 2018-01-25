package com.revature.homework1;

/*
 * 
Q4. Write a program to compute N factorial.

 * */

public class Question4 {

	/*
	 * Iterative factorial function for finding n!
	 * 
	 * Takes in n and iterates from n to 1, multiplying the 
	 * result repeatedly by n--
	 * 
	 * @param int n
	 * @return int result
	 * */
	public static int factorialIterative(int n)
	{
		int result = 1;
		for(int i=0;n>i;n--)
		{
			result*=n;
		//	System.out.println(result);
		}
		return result;
	}
	/*
	 * recursive method for finding n!
	 * Provides the same result as factorialIterative
	 * 
	 * Multiplies result by n while repeatedly calling 
	 * factorialRecursive(n-1)
	 * 
	 * @param int n
	 * @return int result
	 * */
	public static int factorialRecursive(int n)
	{
		int result =1;
		if(n==1)
		{
			return result;
		}
		
		result=n*factorialRecursive(n-1);  //For some reason n-- doesn't work but 
		//n-1 does.  Why does n-- result in a StackOverflowError 
		//but n-1 continuously decrements?
		return result;
	}
	public static void main(String args[])
	{
		int result = factorialIterative(4);
		int result2= factorialRecursive(4);
		System.out.println(result);
		System.out.println(result2);
	}
}
