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
		for(Integer i : ints)
		{
			if(Question6.isEven(i))
				evens += i;
			if(!Question6.isEven(i))
				odds += i;
			if(Question9.isPrime(i))
				primes += i;
		}
		System.out.println("Evens: "+evens);
		System.out.println("Odds: "+odds);
		System.out.println("Primes: "+primes);
	}
}
