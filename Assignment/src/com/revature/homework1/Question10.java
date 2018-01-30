package com.revature.homework1;

public class Question10 {

	//Q10. Find the minimum of two numbers using ternary operators.
	
	public static void main(String[] args) {
		
		int a = 88;
		int b = 8;
		
		int minNum = a > b ? b : a;
		System.out.println("minimum = " + minNum);
	}
}
