package com.revature.homework1;

//Write a program to compute N factorial.


public class Question4 {
	
	
	public static void main(String[] args) {
		
		int num = 10;
		
	    System.out.print(num + "! = ");
		System.out.println(factorial(num));
		
	}
	
	public static int factorial(int num) {
		
		if (num == 1 || num <= 0)
		{
			return 1;
		}
		
		return num * factorial(num -1);
		
	}
}
