package com.revature.homework1;

// Write a program that finds if a number is even 
// without using %
public class Question6 {
	public static void main(String[] args) {
		// Case number is odd
		System.out.println(checkEven(9));
		
		// Number is even
		System.out.println(checkEven(12));
		
		// Number is negative and odd
		System.out.println(checkEven(-12));
		
		// Number is negative and even
		System.out.println(checkEven(-13));
		
		// Case number is 0
		System.out.println(checkEven(0));
	}
	
	public static boolean checkEven(int num) {
		// Case number is positive

		int testNumber = num/2*2;
		if(testNumber == num) {
			return true;
		} else {
			return false;
		}
	}
}
