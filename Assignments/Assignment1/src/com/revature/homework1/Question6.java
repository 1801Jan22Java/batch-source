package com.revature.homework1;

public class Question6 {

	public static void main(String[] args) {
		// Write a program to determine if an integer is even without using the modulus operator (%)

		int i = 9;
		
		System.out.println("Int is " + (isIntEven(i) ? "Even!" : "Odd!"));
	}

	//Check if an integer is even without using the modulus operator
	public static boolean isIntEven(int i) {
		
		//If dividing the int by 2 is equal to the next number divided by 2 then the number will be even!
		return (i/2 == (i+1)/2);
		
	}
}
