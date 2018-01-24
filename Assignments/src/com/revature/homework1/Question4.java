package com.revature.homework1;

//Write a program to compute N factorial.


public class Question4 {
	
	
	public static void main(String[] args) {
		
		int num = 10;
		
	    System.out.print(num + "! = ");
		System.out.println(factorial(num));
		
		num = 15;
		
	    System.out.print(num + "! = ");
		System.out.println(factorial(num));
		
		num = 0;
		
	    System.out.print(num + "! = ");
		System.out.println(factorial(num));
		
	}
	
	//Computes the factorial of the given number
	public static int factorial(int num) {
		
		//Base Case of the recursion
		if (num == 1 || num <= 0)
		{
			return 1;
		}
		
		//Recursive call
		return num * factorial(num -1);
		
	}
}
