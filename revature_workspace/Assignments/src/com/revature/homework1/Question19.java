package com.revature.homework1;

import java.util.ArrayList;

/*
 * Q19. Create an ArrayList and insert integers 1 through 10. 
 * Display the ArrayList. 
 * Add all the even numbers up and display the result. 
 * Add all the odd numbers up and display the result. 
 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
 * */
public class Question19 {

	
	/*
	 * insertInt() returns an ArrayList of type Integer
	 * adds to ArrayList<Integer> with a for loop, that adds ints
	 * 1 through 10;
	 * @param none (void)
	 * @return ArrayList<Integer> intList
	 * */
	public  ArrayList<Integer> insertInt()
	{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for(int i = 1; i<=10 ; i++)
		{
			intList.add(i);
		}
		return intList;
	}

	public  int addEvens(ArrayList<Integer> list)
	{
		int result = 0;
		for(int i : list)
		{
			if(i%2==0)
			{
				result+=i;
			}
		}
		return result;
	}

	public  int addOdds(ArrayList<Integer> list)
	{
		int result = 0;
		for(int i : list)
		{
			if(i%2!=0)
			{
				result+=i;
			}
		}
		return result;
	}
	
	public  boolean checkPrime(int num)
	{

		boolean isPrime =true;
		for(int i=3;i<=num; i+=2)
			{
				if(num % 2==0||num%3==0)
				{
					isPrime=false;
				}
			}
		return isPrime;
	}
	
	public  ArrayList<Integer> removePrimes(ArrayList<Integer> list)
	{
		for(int i = 0;i<list.size();i++){
		//	System.out.println("inside removePrimes");//DEBUGGING
			if(list.get(i)>0 &&list.get(i)<4 )
			{
				list.remove(i);
			}
		}
		for(int i = 0;i<list.size();i++){
			 if(checkPrime(list.get(i)))
			{
				list.remove(i);
			}
		}
		
		return list;
	}



}

