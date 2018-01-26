package com.revature.homework1;

public class Question2 {

	public static void fibonacci(int n) {
		int[] fibonacci =  new int[25];
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		System.out.print("1, 1");
		for(int i=2; i<fibonacci.length; i++) {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
			System.out.print(", "+fibonacci[i]);
		}
	}
	
	public static void main(String[] args) {
		fibonacci(25);
	}
}
