package com.revature.homework1;

// Write a program to calculate N!
public class Question4 {
	public static void main(String[] args) {
		
		// Testing with a small number
		System.out.println(factorial(0));
		
	}
	
	public static int factorial(int n) {
		int answer=1;
		for(int i=1; i<=n; i++) {
			answer*=i;
		}
		
		return answer;
	}
}
