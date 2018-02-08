package com.revature.homework1;

public class Question1 
{
	public static int[] bubbleSort(int[] nums)
	{
		//set up the base case
		if(nums.length == 1 || nums.length == 0)
			return nums;
		else
		{
			int temp;
			
			//for each character in the array
			for(int i = 0; i < nums.length-1; i++)
			{
				//compare the current character with each character in the array
				for(int j = 0; j < nums.length-1; j++)
				{
					//if the current care is greater than the next character
					if(nums[j] > nums[j+1])
					{
						//switch the values of the characters
						temp = nums[j+1];
						nums[j+1] = nums[j];
						nums[j] = temp;
					}
				}
			}
			//return the sorted array
			return nums;
		}
	}
}
