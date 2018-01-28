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
	/*
	 * addEvens() takes in an ArrayList<Integer> list and returns an int 
	 * uses an enhanced for-loop to iterate through list and if i % 2 == 0, i
	 * is added to the result.  Returns int result at the end of the for loop.
	 * @param ArrayList<Integer> list
	 * @return int result
	 * */
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

	/*
	 * addOdds() takes in an ArrayList<Integer> list and returns an int 
	 * uses an enhanced for-loop to iterate through list and if i % 2 != 0, i
	 * is added to the result.  Returns int result at the end of the for loop.
	 * @param ArrayList<Integer> list
	 * @return int result
	 * */
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
	/*checkPrime takes in an integer num and returns a boolean isPrime
	 * Checks if any number is less than greater than four
	 * and if a number is divisible by 2 or 3.    Any number between 4 and 10 or evenly divisible
	 * by 2 or 3 sets isPrime to false.
	 * Otherwise, sets isPrime to true
	 * @param int num
	 * @return boolean isPrime
	 * */
	public  boolean checkPrime(int num)
	{

		boolean isPrime =true;
		if(num>4 &&(num % 2==0||num%3==0))
		{
			isPrime=false;
		}

		return isPrime;
	}
	/*
	 * removePrimes takes in an ArrayList of Integers
	 * Iterates through the list and removes any item between 0 and 4, as those items are all prime numbers
	 * Iterates through the rest of the list and calls checkPrime on each item in the list.
	 * Removes that item if checkPrime returns true.
	 * @param ArrayList<Integer> list
	 * @return ArrayList<Integer> list
	 * */
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

