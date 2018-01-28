package com.revature.homework1;

import java.util.*;

public class Question19 {

	public static void main(String[] args) {

		ArrayList<Integer> theInts = new ArrayList<Integer>();
		
		//add numbers 1 - 10 to an array list
		for(int i = 0; i < 10; i++)
		{
			theInts.add(i+1);
			System.out.print(theInts.get(i) + ", ");
		}
		
		//calls functions to add the even numbers
		evenAdder(theInts);
		//calls function to add the odd numbers
		oddAdder(theInts);
		//calls function to remove the prime numbers
		primeRemover(theInts);
	}

	//checks if number is even by checking if the current number has a 
	//remainder if being divided by 2
	public static void evenAdder(ArrayList<Integer> theArg)
	{
		int sum = 0;
		for(int i = 0; i < theArg.size(); i++)
		{	//if the number is even, then add it to the sum
			if(theArg.get(i) % 2 == 0)
				sum += theArg.get(i);
		}
		
		System.out.println("The sum of these even numbers is: " + sum);
	}
	
	//does same function as evenAdder but if the current number does have
	//a remainder, then it adds it to sum
	public static void oddAdder(ArrayList<Integer> theArg)
	{
		int sum = 0;
		for(int i = 0; i < theArg.size(); i++)
		{	//if the number is even, gets added to sum
			if(theArg.get(i) % 2 != 0)
				sum += theArg.get(i);
		}
		
		System.out.println("The sum of these odd numbers is: " + sum);
		
	}
	
	//checks if the number is prime
	public static void primeRemover(ArrayList<Integer> theArg)
	{
		//first for loop iterates through entire arraylist
		for(int j = 0; j < theArg.size(); j++)
		{
			//for loop which checks if a number is prime and ouputs it
			//to the console if it is true, if not it will remove it from
			//the array list
			for(int x = 2; 2 * x < theArg.get(j); x++) 
			{
				if(theArg.get(j) % x == 0)
					System.out.println(theArg.get(x));
				else
					theArg.remove(j);
			}
			
		}
	}
	
}
