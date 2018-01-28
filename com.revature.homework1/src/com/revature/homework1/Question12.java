package com.revature.homework1;

public class Question12 {

	public static void main(String[] args) {

		int counter = 1;
		int theArray[];
		theArray = new int[100];
		
		//for loop stores 1 - 100 into array
		for(int i = 0; i < 100; i++)
		{
			theArray[i] = counter;
			counter++;
		}
		
		//for loop to check if each element in array is even
		//and outputs the number if it is true
		for(int i = 0; i < 100; i++)
		{
			if(theArray[i] % 2 == 0)
			{
				System.out.println(theArray[i]);
			}
			
		}
				
		
	}

}
