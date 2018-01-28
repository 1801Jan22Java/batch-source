package com.revature.homework1;

public class Question10 {
	public static void main(String[] args) {
		int a = 2, b = 0;
		
		//The idea of a ternary operator is that of conditional assignment. If a IS less than b, we assign a
		//otherwise b. This means the following to statements should each print out 0
		int minAB = (a < b) ? a : b;
		int minBA = (b < a) ? b : a;
		
		System.out.println("Minimum AB: " + minAB + "\nMinimum BA: " + minBA);
	}
}
