package com.revature.homework1;

public class Question4 {

	public static void main(String[] args) {
		
		//Calculate N factorial

		int N = 6;
		
		calculateFactorial(N);
		
	}

	//Calculate factorial of N
	public static void calculateFactorial(int N) {
		
		int value = N;
		
		for(int i = N - 1; i > 0; i--) {
			value *= i;
		}
		
		System.out.println(N + " factorial is: " + value);
		
	}
	
}
