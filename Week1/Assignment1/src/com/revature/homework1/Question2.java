package com.revature.homework1;

public class Question2 
{
	public static int fibonacci(int x)
	{
		//base case
		if(x > -1 && (x == 1 || x == 0))
			return x;
		else
			//calculate the fibonacci number, which is (x-1)+(x-2)
			//recursion will continue until the base case is hit
			return fibonacci(x-1) + fibonacci(x-2);
	}

}
