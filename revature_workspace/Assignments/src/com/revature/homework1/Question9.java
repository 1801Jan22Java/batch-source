package com.revature.homework1;

import java.util.ArrayList;

/*
 * Q9. Create an ArrayList which stores numbers from 1 to 100 
 * and prints out all the prime numbers to the console.
 * */
public class Question9 {

	/*
	 * Fills the ArrayList with doubles from 1 to 100
	 * @param none
	 * @return ArrayList<Double> list
	 * */
	private ArrayList<Double> fillArrayList()
	{
		ArrayList<Double>list= new ArrayList<Double>();
		for(double i = 1; i<=100;i++)
		{
			list.add(i);
		}
		return list;
	}
	
	/*
	 * Checks if Double num is a prime number.
	 * if num % 2 returns 0, if num <= 3 or if num is divisible by any number other than itself,
	 * isPrimeNumber returns false.  Otherwise returns true
	 * @param Double num
	 * @return boolean isPrime
	 * */
	private boolean isPrimeNumber(Double num)
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
	
	/*Displays prime numbers from ArrayList<Double> list
	 * Calls isPrimeNumber() on items in list
	 * Calls fillArrayList()
	 * if isPrimeNumber() returns true, item is printed out.
	 * @param none
	 * @return none
	 * */
	public void printPrime()
	{
		ArrayList<Double>list=fillArrayList();
		for(int i =0;i<list.size();i++)
		{
			if(isPrimeNumber(list.get(i)))
			{
				System.out.print(list.get(i) + " ");
			}
		}
	}


}
