package com.revature.homework1;

public class Question2 {

	public Question2() {
		super();
	}
	
	public static void fibonacci() {
		//Fibonacci sequence takes the sum of the previous two values. 
		//Starting point requires the first two values, 0 and 1.
		int firstNum = 0;
		int secNum = 1;
		System.out.print(firstNum + ", " + secNum + ", ");
		
		//Prints out the values of first 24 numbers in the sequence
		for(int i = 1; i < 24; i++) {
			int sum = firstNum + secNum;
			firstNum = secNum;
			secNum = sum;
			System.out.print(sum + ", ");
		}
		//The 25th number to not have trailing comma.
		System.out.print(firstNum + secNum + "\n");
	}
}
