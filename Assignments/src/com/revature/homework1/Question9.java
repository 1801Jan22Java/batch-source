package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
 */
public class Question9 
{
	//I started by creating a method to check if a number is prime by using the mod opperatopr and dividing by
	//all numb ers less than that number
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
		//with my new method, I just filtered out the prime numbers into a new list
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
