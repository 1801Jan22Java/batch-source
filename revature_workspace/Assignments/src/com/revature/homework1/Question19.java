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
	public static ArrayList<Integer> insertInt()
	{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for(int i = 1; i<=10 ; i++)
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
	
	public static boolean checkPrime(int num)
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
/*
	public static boolean checkPrime(Integer num)
	{
		boolean isPrime=false;
		if(num==2)
		{
			//System.out.println(num);
			isPrime=true;	
		}	
		if(num%2==0)
		{
		//	System.out.println(num%2);
			isPrime=false;
		}
		for(int i=3;i*i<=num; i+=2)
			{
				if(num % i==0)
				{
					isPrime= false;
					
				}
				else
				{
					System.out.println(num);
					 isPrime= true;
					//System.out.println(isPrime);
					
				}
			}
	return isPrime;
	}
	
	*/
	
	public static ArrayList<Integer> removePrimes(ArrayList<Integer> list)
	{
		for(int i = 2;i<list.size();i++){
			System.out.println("inside removePrimes");
			if(checkPrime(list.get(i)))
			{
			//	System.out.println(list.get(i));
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
		//	System.out.println(list.get(i));
		}
		//System.out.println(addEvens(list));
	//	System.out.println(addOdds(list));
		list = removePrimes(list);
		for (int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i) + " ");
		}


	}

}

