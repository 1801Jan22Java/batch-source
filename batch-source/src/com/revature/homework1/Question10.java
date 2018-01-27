package com.revature.homework1;
//James Whitten

public class Question10 {

	// method for finding the minimum of 2 integers
	public static int minVal(int i1, int i2) {
		//Our ternary operator
		int minValue = i1 < i2 ? i1 : i2;
		return minValue;
	}
	
		//Our main
		public static void main(String[] args) {
		
			//test cases
			System.out.println(minVal(7,3));
			System.out.println(minVal(5,5));
			
		}
			
}
