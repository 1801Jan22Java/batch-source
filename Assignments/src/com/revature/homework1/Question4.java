package com.revature.homework1;

public class Question4 {

	public static int factorial(int n) {
		if(n == 1) {
			return 1;
		}
		else return n*(factorial(n-1));
	}
	
	public static void main(String[] args) {
		
		System.out.println(factorial(5));
	}
}
