package com.revature.homework1;

public class Question4 
{
	public static int nFactorial(int factorial)
	{
		//base case
		if(factorial == 1)
			return factorial;
		else
			//multiply n*n-1 in a recursive fashion
			//until reaching a base case
			return factorial*nFactorial(factorial-1);
	}
}
