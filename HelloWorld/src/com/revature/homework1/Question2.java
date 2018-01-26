package com.revature.homework1;

import java.util.Arrays;

public class Question2 {

	public static void main(String[] args) {
		// Write a program to display the first 25 Fibonacci numbers beginning at 0.
		fibonacci(25);
	}
	
	public static void fibonacci (int fSize) {
		
		int[] fibonacci = new int[fSize];
		
		// first two initial numbers
		int init0 = 0;
		int init1 = 1;
		
		for (int i = 0; i < fSize ; i ++) {
			
			if (i == 0 || i == 1) {
				fibonacci[i] = i;
			} 
			else {
				int added = init0 + init1;		// generates the added number using previous 2 numbers		
				fibonacci[i]= added;
				init0 = init1;
				init1 = added;
			}
		}
		
		System.out.println("final result: "+ Arrays.toString(fibonacci) );
	}
}
