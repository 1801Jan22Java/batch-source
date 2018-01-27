package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;


public class Question19
{
	public static void question19()
	{
		Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9,10};
		ArrayList<Integer> ints = new ArrayList<Integer>(Arrays.asList(arr));
		int evens = 0;
		int odds = 0;
		int primes = 0;
		//for each int in the array, use the methods created earlier in the assignment
		//to add them to the ints.
		for(Integer i : ints)
		{
			if(Question6.isEven(i))
				evens += i;
			if(!Question6.isEven(i))
				odds += i;
			if(Question9.isPrime(i))
				primes += i;
		}
		//print out the sums of the evens, odds, and primes
		System.out.println("Evens sum: "+evens);
		System.out.println("Odds sum: "+odds);
		System.out.println("Primes sum: "+primes);
	}
}
