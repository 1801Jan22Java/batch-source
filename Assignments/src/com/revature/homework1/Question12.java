package com.revature.homework1;

public class Question12 {
	
	
	public static void main(String[] args)
	{
		int[] list = new int[100];				//initialize array
		for(int i=0; i<100;i++)					//fill array with numbers 1-100
		{
			 list[i]= i+1;
		}
		for (int num: list)						//cycle through array
		{
			if(num%2 ==0)						//if current number is even
			{
				System.out.println(num);		//print the number if not do nothing
			}
		}
	}

}
