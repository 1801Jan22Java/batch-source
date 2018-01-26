package com.revature.homework1;
/*
 * This class prints the first 25 numbers in the Fibonacci sequence 
 */
public class Question2 {
	
	private static void fib(int n)
	{
		int num1 = 1, num2 = 0, temp;
		System.out.print(num2 + " ");		//print out 0
		while (n > 0)						//
		{
			temp = num1;					//save the first number
			num1 += num2;					//add the to numbers and save the result
			num2 = temp;					//put the first number back 
			
			n--;							
			System.out.print(num2 + " "); 	//prints out the next number in the sequence
		}//end of while loop
		
	}
	
	public static void main(String args[])
	{
		fib(25);
	}
	

}
