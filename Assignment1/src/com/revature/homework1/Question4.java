package com.revature.homework1;

public class Question4 
{
	public static int nFactorial(int factorial)
	{
		if(factorial == 1)
			return factorial;
		else
			return factorial*nFactorial(factorial-1);
	}
}
