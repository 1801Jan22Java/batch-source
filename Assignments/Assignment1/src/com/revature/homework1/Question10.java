package com.revature.homework1;

public class Question10 {

	public static void main(String[] args) {
		// ​ Find the minimum of two numbers using ternary operators.

		int num1 = 47;
		int num2 = 25;
		
		System.out.println("Min of " + num1 + " and " + num2 + " is " + getMin(num1, num2));

	}
	
	//Get min of two numbers
	public static int getMin(int n1, int n2) {
		
		//If first number is less than the second, return it otherwise return the other one
		return n1 < n2 ? n1 : n2;
	}

}
