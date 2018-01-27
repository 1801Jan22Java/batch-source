package com.revature.homework1;
/*
 * Q10. Find the minimum of two numbers using ternary operators.
 * */

public class Question10 {
	
	/*
	 * Uses a ternary operator to find the minimum between int a and int b
	 * @param int a and int b
	 * @return int result
	 * */
	public int findMinimum(int a, int b)
	{
		int result = a>b?b:a;
		return result;
	}

}
