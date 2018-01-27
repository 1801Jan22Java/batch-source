package com.revature.homework1;

import java.util.ArrayList;

public class Question9 
{
	public static ArrayList<Integer> primes1To100()
	{
		ArrayList<Integer> result = new ArrayList<Integer>();

		//check each number form 1 to 100 and
		for(int i = 1; i <= 100; i++)
		{
			// add them to the above list if a number is prime
			if(isPrime(i))
				result.add(i);
		}
		return result;
	}

	public static boolean isPrime(int x)
	{
		//flag
		boolean isPrime = true;
		int counter = 0;
		
		int temp = x;
		while(temp != 0)
		{
			if(x%(temp) == 0)
				counter++;
			temp--;
		}
		//Prime numbers are divisible by 1 and themselves.
		//so every prime number should produce a counter of 2.
		if(counter > 2)
			isPrime = false;
		return isPrime;
	}
}
