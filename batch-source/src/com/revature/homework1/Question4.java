package com.revature.homework1;
//James Whitten

public class Question4 {

	void getFactorial(int ourNum)
	{
		//Printing out the number we are finding the factorial for
		System.out.print("The factorial of " + ourNum + " is ");
		int ourResult = 1;
		//This cannot be a factorial!
		if (ourNum < 0)
		{
			System.out.println("0");
			return;
		}
		//0! = 1
		if (ourNum == 0)
		{
			System.out.println("1");
			return;
		}
		//Iterative approach to factoring a number (keep multiplying each time)
		for (int i = 1; i <= ourNum; i++)
		{
			ourResult = ourResult * i;
		}
		System.out.println(ourResult);
		
	}
	
	//Our main
	public static void main(String[] args)
	{
		//Creating the Question4 object
		Question4 q4 = new Question4();
		//Test cases for factorials
		q4.getFactorial(10);
		q4.getFactorial(0);
				
	}
	
	
}
