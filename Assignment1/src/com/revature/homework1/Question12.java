package com.revature.homework1;

import java.util.ArrayList;

public class Question12
{
	public static void storeAndManipulate1To100()
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		//1 is odd, so start at 2
		for(int i = 2; i <=100; i++)
		{
			if(i%2 == 0)
				nums.add(i);
		}
		
		for(Integer i : nums)
			System.out.print(i+"  ");
	}
}
