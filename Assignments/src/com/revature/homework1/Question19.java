package com.revature.homework1;

import java.util.*;
/*
 * Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the even numbers up 
 * and display the result. Add all the odd numbers up and display the result. Remove the prime numbers from 
 * the ArrayList and print out the remaining ArrayList.
 */
public class Question19 
{
	public static void main(String args[])
	{
		List<Integer> list = new ArrayList();
		Collections.addAll(list,new Integer(1), new Integer(2), new Integer(3), new Integer(4), new Integer(5),new Integer(6),new Integer(7), new Integer(8), new Integer(9), new Integer(10));
		int evens = 0;
		int odds = 0;
		for(Integer i: list)
		{
			if(i%2 == 0)
			{
				evens+=i;
			}
			else
			{
				odds+=i;
			}
		}
		System.out.println(evens);
		System.out.println(odds);
		Question9 q9 = new Question9();
		Iterator<Integer> it = list.iterator();
		while(it.hasNext())
		{
			if(q9.isPrime(it.next()))
			{
				it.remove();
			}
		}
		System.out.println(list.toString());
	}
}
