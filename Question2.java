package com.revature.homework1;

class Question2{
	
	public static void main(String[] args) {
		int step = 25;
		int fiboValue;
		for (int index = 1; index <= step; index++ ) {
			fiboValue = fibonacciSequence(index);
			System.out.println(fiboValue);
		}
	}
	
	static int fibonacciSequence(int depth) {
		if (depth == 1)
			return 0;
		if (depth == 2)
			return 1;
		else
			return fibonacciSequence(depth - 1) + fibonacciSequence(depth - 2);
	}
}