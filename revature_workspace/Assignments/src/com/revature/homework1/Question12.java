package com.revature.homework1;
/*
 * Q12. Write a program to store numbers from 1 to 100 in an array. 
 * Print out all the even numbers from the array. 
 * Use the enhanced FOR loop for printing out the numbers.
 * */
public class Question12 {
	
	public static void showEvenNumbers()
	{
		int [] arr = new int[101];
		for(int i=1;i<arr.length;i++)
		{
			arr[i]=i;
		}
		for(int i:arr)
		{
			if(arr[i]%2==0)
			{
				System.out.println(arr[i]);
			}
		}
	}
	public static void main(String [] args)
	{
		showEvenNumbers();
	}

}
