package com.revature.homework1;

import java.util.*;

public class Question9 {

	//Q9. Create an ArrayList which stores numbers from 1 to 100 
	//and prints out all the prime
	//numbers to the console.
	public static void main(String[] args)
	{
		int theAdder = 0;
		
		ArrayList<Integer> thePrimes = new ArrayList<Integer>();
	
		//store the numbers 1 - 100 into an arraylist 
		for(int j=0; j<100; j++)
		{
			thePrimes.add(theAdder);
		
			theAdder++;
		}
		
		//check through each element in the array list using checkPrime
		for(int j = 0; j < 100; j++)
		{
			checkPrime(thePrimes.get(j));
		}
	}
	
	//checks if the number passed into checkPrime is 0 or 1, then it is not prime
	//then checks if the number doesnt have a remainder if divided by two
	static void checkPrime(int n){  
		  int i,m = 0,flag = 0;      
		  m = n/2;      
		  if(n == 0 || n == 1)
		  {  
		   System.out.println(n+" is not prime number");      
		  }
		  else
		  {  
		   for(i = 2; i <= m; i++)
		   {      
		    if(n % i == 0)
		    {      
		     System.out.println(n+" is not prime number");      
		     flag = 1;      
		     break;      
		    }      
		   }      
		   if(flag == 0)
		   { System.out.println(n+" is prime number"); }  
		  }
		} 
}
