package com.revature.homework1;

import java.util.ArrayList;

/*
 * Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.

 * */

public class Question2 {
	
	/*
	 * Recursive (only?) solution for Fibonacci sequence.
	 * Takes n and recursively adds n-1 and n-2 to a result.
	 * */
	
	ArrayList<Integer> fibList = new ArrayList<Integer>();
	
	public int fibonacciRecursive(int n)
	{
		
		int result =1;
		if(n==0)
		{
			//fibList.add(1);
			return 1;
		}
		if (n==1)
		{
			//fibList.add(1);
			return 1;
		}
		result = fibonacciRecursive(n-2)+fibonacciRecursive(n-1);
		fibList.add(n-2);
		return result;
		
	}
	public void displayNums()
	{
		for(int i =0;i<fibList.size();i++)
		{
			System.out.print(fibList.get(i)+ " ");
		}
	}
	

	
}
