package com.revature.homework1;
/*
 * Q6. Write a program to determine if an integer is even 
 * without using the modulus operator (%)
 * */



public class Question6 {
	
	
	public static boolean isEven(int n){
		boolean even = false;
		
		//Iterates through numbers up to n, trying to find a value that results in the given number when
		// multiplied by two.  If none is found, the number is not even.
		for(int i = 0 ; i <= n ; i++)
		{
			if((i*2)==n)
			{
				even = true;
				return even;
			}
		}
		return even;
	
	}

}
