package com.revature.homework1;
/*
 * Q10. Find the minimum of two numbers using ternary operators.
 * */

public class Question10 {
	
	public static int findMinimum(int a, int b)
	{
		int result = a>b?b:a;
		return result;
	}
	public static void main(String [] args)
	{
		System.out.println(findMinimum(-5,-86));
	}

}
