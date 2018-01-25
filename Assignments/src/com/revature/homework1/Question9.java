package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
 */
public class Question9 
{
	public static boolean isPrime(Integer i)
	{
		if(i == 1)
			return false;
		for(int j =2; j<i; j++)
		{
			if (i%j == 0)
			{
				return false;
			}
		}
		return true;
	}
	public static ArrayList<Integer> printPrimes(ArrayList<Integer> ints)
	{
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(Integer i: ints)
		{
			if(isPrime(i))
			{
				primes.add(i);
			}
		}
		return primes;
	}
	public static void main(String args[])
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 1; i<=100; i++)
		{
			nums.add(new Integer(i));
		}
		System.out.println(nums.toString());
		System.out.println(printPrimes(nums).toString());
	}
}
