package com.revature.homework1;
/*
 * Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
 */
public class Question1 
{
	public static void main(String args[])
	{
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		
		System.out.print("Before: ");
		for(int i = 0; i  < array.length; i++)
		{
			System.out.print(" " + array[i]);
		}
		System.out.println();
		//temp holder for swapping
		int  bucket;
		//outter loop work from 1 to the end of the array
		int n = array.length;
		for(int j =0; j < n; j++)
		{
			//inner loop does the same to compare the first item to the last looking for the largest element
			for(int k = 1; k < (n - j) ;k++)
			{
				//if this element is larger than the one next to it, swap them
				if (array[k-1] > array[k])
				{
					bucket = array[k];
					array[k] = array[k-1];
					array[k-1] = bucket;
				}
				//at the end, the largest numeber should be the last number in the array
			}
		}
		
		System.out.print("After: ");
		for(int i = 0; i  < array.length; i++)
		{
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
