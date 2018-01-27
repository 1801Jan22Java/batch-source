package com.revature.homework1;
//James Whitten

public class Question13 {

	//A method that takes in an integer array and formats the numbers to output in a triangle using a nested for loop inside of a while loop
	public static void giveBinTriangle(int[] intstream)
	{
		//Printing out the integers provided
		System.out.println("Integers before formatting are: ");
		for (int i = 0; i < intstream.length; i++)
		{
			System.out.print(intstream[i] + " ");
		}
		System.out.println();
		
		System.out.println("Integers after formatting are: ");
		//Used to keep track of how many integers from the integer array have been used
		int allVals = 0;
		//Used to keep track of how many integers to display on each line
		int triangleBump = 1;
		//Spit out integers until all integers in the integer array are used
		while(allVals < intstream.length)
		{
			//Spits out all integers for this line and then increments the number of integers to output next line when finished
			for (int i = 0; i < triangleBump; i++)
			{
				System.out.print(intstream[allVals]);
				allVals = allVals + 1;
			}
			triangleBump = triangleBump + 1;
			System.out.println();
		}
	}
	
	
	//Our main
	public static void main(String[] args) {
	
	//test cases
	int[] intArray = new int[10];
	for (int i = 0; i < intArray.length; i++)
	{
		if (i%2==0)
			intArray[i] = 0;
		else
			intArray[i] = 1;
	}
	
	giveBinTriangle(intArray);
	
	//Just for funsies case
	int[] intSuper = new int[210];
	for (int i = 0; i < intSuper.length; i++)
	{
		if (i%3==0)
			intSuper[i] = 0;
		else if (i%3==1)
			intSuper[i] = 1;
		else
			intSuper[i] = 2;
	}
	
	giveBinTriangle(intSuper);
	
	
	}
}
