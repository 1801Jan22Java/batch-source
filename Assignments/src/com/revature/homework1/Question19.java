package com.revature.homework1;
//James Whitten


import java.util.ArrayList;
import java.util.Iterator;


public class Question19 {

	//Adds up all the even numbered elements in an ArrayList
	public static int addUpEvens(ArrayList<Integer> aL)
	{
		int evenSum = 0;
		for (int i = 0; i < aL.size(); i++)
		{
			//Checks if the element is even and then adds it to the running sum if it is even
			if (aL.get(i)%2==0)
				evenSum = evenSum + aL.get(i);
		}
		return evenSum;
	}
	
	//Adds up all the odd numbered elements in an ArrayList
	public static int addUpOdds(ArrayList<Integer> aL)
	{
		int oddSum = 0;
		for (int i = 0; i < aL.size(); i++)
		{
			//Checks if the element is odd and then adds it to the running sum if it is odd
			if (aL.get(i)%2==1)
				oddSum = oddSum + aL.get(i);
		}
		return oddSum;
	}
	
	//Removes all prime number in an ArrayList
	public static void removePrimes(ArrayList<Integer> aL)
	{
		Iterator<Integer> aLIterator = aL.iterator();
		
		while (aLIterator.hasNext())
		{
			boolean isPrime = true;
			//Storing the iterator value so we can use it without iterating further
			int aLVal = aLIterator.next();
			
			//1 is not prime but 2 and 3 are
			if (aLVal == 2 || aLVal == 3)
		    {
		    	aLIterator.remove();
		    }
			else
			{
				//If the int is not 2 or 3 and less than 3 it will be assumed to be non-prime
				if (aLVal > 3)
				{
					//Checking if the number is prime, will check slightly higher than the sqrt of the number due to precision loss
					for (int i = 2; i < Math.sqrt(aLVal) + 1; i++)
					{
						if (aLVal%i==0)
							isPrime = false;
					}
					if (isPrime == true)
					{
						aLIterator.remove();
					}
					
				}
				
			}

			
		}
		
	}
	
	
	//Our main
	public static void main(String[] args) {
		
		//Creating our ArrayList
		ArrayList<Integer> ourArrayList = new ArrayList<Integer>();
		System.out.print("Our ArrayList: ");
		for (int i = 1; i < 11; i++)
		{
			ourArrayList.add(i);
			System.out.print(ourArrayList.get(i-1) + " ");
		}
		
		//Doing all our ArrayList functions and then printing out the results
		System.out.println();
		System.out.println("The sum of all even numbers for our ArrayList is: " + addUpEvens(ourArrayList));
		System.out.println("The sum of all odd numbers for our ArrayList is: " + addUpOdds(ourArrayList));
		removePrimes(ourArrayList);
		System.out.print("Our ArrayList without primes is: ");
		for (int i = 0; i < ourArrayList.size(); i++)
		{
			System.out.print(ourArrayList.get(i) + " ");
		}
		
	}
	
	
}
