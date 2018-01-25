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

	public static ArrayList<Integer> insertInt()
	{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for(int i = 1; i<=17 ; i++)
		{
			intList.add(i);
		}
		return intList;
	}

	public static int addEvens(ArrayList<Integer> list)
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

	public static int addOdds(ArrayList<Integer> list)
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

	public static boolean checkPrime(int n)
	{
		boolean isPrime=true;
		if(n==2)
		{
			isPrime=true;
			return isPrime;
		}
		if(n%2==0)
		{
			isPrime= false;
			return isPrime;
		}
		int  a = 3;
		while((a*a)<=n )
		{
			if(n%a==0)
			{
			//	System.out.println("not prime");//Debugging statement
				isPrime= false;
				return isPrime;
			}
			a+=2;
		}
		return isPrime;
	}
	
	
	public static ArrayList<Integer> removePrimes(ArrayList<Integer> list)
	{
		for(int i = 0;i<list.size();i++){
			if(checkPrime(list.get(i)))
			{
				System.out.println(list.get(i));
				list.remove(i);
			}
		}
		
		return list;
	}


	public static void main(String [] args)
	{
		ArrayList<Integer> list =insertInt();
		for(int i = 0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
		System.out.println(addEvens(list));
		System.out.println(addOdds(list));
		list = removePrimes(list);
		for (int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i) + " ");
		}


	}

}

