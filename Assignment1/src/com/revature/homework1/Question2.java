package com.revature.homework1;

public class Question2 
{
	public static int fibonacci(int x)
	{
		if(x > -1 && (x == 1 || x == 0))
			return x;
		else
			return fibonacci(x-1) + fibonacci(x-2);
	}

}
