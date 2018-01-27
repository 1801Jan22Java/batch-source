package com.revature.homework1;

public class Question1 
{
	public static int[] bubbleSort(int[] nums)
	{
		if(nums.length == 1 || nums.length == 0)
			return nums;
		else
		{
			int temp;
			for(int i = 0; i < nums.length-1; i++)
			{
				for(int j = 0; j < nums.length-1; j++)
				{
					if(nums[j] > nums[j+1])
					{
						temp = nums[j+1];
						nums[j+1] = nums[j];
						nums[j] = temp;
					}
				}
			}
			return nums;
		}
	}
}
