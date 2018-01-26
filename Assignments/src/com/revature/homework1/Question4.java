package com.revature.homework1;
/*
 * Computes the factorial of the specified number
 */
public class Question4 {
	
	/**
	 * computes the factorial
	 * @param n the number used to compute the factorial
	 * @return the result
	 */
	private static int factorial(int n)
	{
		int result = 1;
		if (n==0)
		{
			return 1;
		}
		
		while (n!=0)
		{
			result *= n;
			n--;
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println("3! = "+ factorial(3));
		System.out.println("12! = " + factorial(12));
	}
	

}
