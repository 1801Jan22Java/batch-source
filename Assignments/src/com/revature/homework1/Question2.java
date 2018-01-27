package com.revature.homework1;
//James Whitten

public class Question2 {

	void fibonacci(int num)
	{
		//If the input number is less than 1 it is not a possible number in the fibonacci sequence 
		if (num < 1)
			return;
		
		int num1 = 0;
		
		//The 0th number of the fibonacci sequence
		System.out.print(num1 + " ");
		
		//The 1st number of the fibonacci sequence
		int num2 = 1;
		
		System.out.print(num2 + " ");
		
		//Prints out second number of the fibonacci sequence and onward
		for (int i = 2; i < num+1; i++)
		{
			//Our current fibonacci sequence number (summing up previous 2 sequence numbers)
			int num3 = num1 + num2; 
			//Move our first number up to the next number in the sequence
			num1 = num2;
			//Same thing for the second number in the sequence
			num2 = num3;
			//Printing out current fibonacci number
			System.out.print(num3 + " ");
		}
		
		//Nice if you want to print out multiple fibonacci sequences
		System.out.println();
		
	}
	
	//Our main
	public static void main(String[] args) {
		//Creating our Question2 class
		Question2 q2 = new Question2();
		//Finding the 25th fibonacci sequence number
		q2.fibonacci(25);
	}
	
}

