package com.revature.homework1;

import java.util.Arrays;

/*
 * Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. 
 * Use the enhanced FOR loop for printing out the numbers.
 */
public class Question12 
{
	//I started by making a method that will allow me to create an array with just the even numbers
	public static int[] onlyEvens(int[] nums)
	{
		int[] evens = new int[nums.length];
		int j=0;
		for(int i : nums)
		{
			if((i % 2) == 0)
			{
				evens[j] = i;
				//System.out.println(i);
				j++;
			}
		}
		//System.out.println(j);
		return evens;
	}
	public static void main(String args[])
	{
		int[] nums =  new int[100];
		int j = 0;
		for(int i = 1; i <= 100; i++)
		{
			nums[j]=i;
			j++;
		}
		System.out.print("Before: ");
		for(int i: nums)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.print("After: ");
		//I used the augmented for loop to move through the array and print all of the number in it
		for(int i: onlyEvens(nums))
		{
			System.out.print(i + " ");
		}
	}
}
