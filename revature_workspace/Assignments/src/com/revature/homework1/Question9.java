package com.revature.homework1;

import java.util.ArrayList;

/*
 * Q9. Create an ArrayList which stores numbers from 1 to 100 
 * and prints out all the prime numbers to the console.
 * */
public class Question9 {

	public static ArrayList<Double> fillArrayList()
	{
		ArrayList<Double>list= new ArrayList<Double>();
		for(double i = 1; i<=100;i++)
		{
			list.add(i);
		}
		return list;
	}
	
	
	public static boolean isPrimeNumber(Double num)
	{
		boolean isPrime=true;
		if(num==2)
		{
			return true;
		}
		
		if(num%2==0)
		{
			return false;
		}
	
		for(int i=3;i*i<=num; i+=2)
			{
				if(num % i==0)
				{
					return false;
				}
			}
	return isPrime;
	}
	
	public static void printPrime(ArrayList<Double>list)
	{
		for(int i =0;i<list.size();i++)
		{
			if(isPrimeNumber(list.get(i)))
			{
				System.out.println(list.get(i));
			}
		}
	}
	public static void main(String [] args)
	{

		 printPrime(fillArrayList());
		



	}

}
