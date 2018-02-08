package com.revature.homework1;

import java.util.ArrayList;

public class Question12
{
	public static void storeAndPrintEvens()
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		//iterate through 2 to 100.
		//1 is odd, so start at 2
		for(int i = 2; i <=100; i++)
		{
			//if the number is even (check using modulo)
			if(i%2 == 0)
				//add it to the nums array
				nums.add(i);
		}
		
		//use a for-each loop/enhanced for loop to print the values
		for(Integer i : nums)
			System.out.print(i+"  ");
	}
}
