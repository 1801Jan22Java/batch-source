package com.revature.homework1;

import java.util.ArrayList;

public class Question9 {

	
	//Method that can check any number of integers from an ArrayList, of any size, of any value, of any order and prints the primes if they exist
	public static void printPrimes(ArrayList<Integer> iList)
	{
		
		
		for (int i = 0; i < iList.size(); i++)
		{
		    //2 is always prime
		    if (iList.get(i) == 2)
		    {
		    	System.out.print("2 ");
		    }
		    //3 is always prime
		    else if (iList.get(i) == 3)
		    {
		    	System.out.print("3 ");
		    }	    
		    //Check if it is prime
		    else if (iList.get(i) > 3)
		    {
		    	//To make sure we only print out prime numbers
		    	boolean isPrime = true;
		    	//Only need to check if it is divisible by numbers up to the square root of the number we are checking
		    	//Due to precision loss we do slightly larger than the square root for accuracy
		    	for (int j = 2; j < Math.sqrt(iList.get(i))+1; j++)	
				{
		    		//Number is not prime
					if (iList.get(i)%j==0)
					{
						isPrime = false;
						break;
					}
				}
		    	//If it is prime we print it
		    	if (isPrime == true)
		    	{
		    	System.out.print(iList.get(i) + " ");
		    	}
		    }
		    //This number cannot be prime so we do nothing
		    else
		    {
		    }
		    
		}
	}
	
	//Our main
	public static void main(String[] args)
	{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		//Adding numbers 1 through 100 to our ArrayList
		for (int i = 1; i < 101; i++)
		{
			intList.add(i);
		}
		
		//We check if the numbers in the list are prime
		printPrimes(intList);
		
	}
	
	
}
