package com.revature.homework1;

// Write a program to calculate N!
public class Question4 {
	public static void main(String[] args) {
		
		// Testing with 0
		System.out.println(factorial(0));
		
		 //Testing with small numbers
		System.out.println(factorial(3));
		System.out.println(factorial(5));
		System.out.println(factorial(7));
		
		// Testing with a negative number
		System.out.println(factorial(-2));
		
		// Testing with char
		System.out.println(factorial('q'));
	}
	
	public static int factorial(int n) {
		try {
			if(n<0) { 
				throw new IllegalArgumentException();
			}
			int answer=1;
			for(int i=1; i<=n; i++) {
				answer*=i;
			}
			
			return answer;
		} catch(IllegalArgumentException e) {
			System.out.println("N! of negative numbers not possible: "+e.toString());
			return 0;
		}
		
	}
}
