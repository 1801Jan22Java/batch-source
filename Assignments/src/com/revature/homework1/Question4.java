package com.revature.homework1;

public class Question4 {
	
	public static void main(String[] args) {
		System.out.println(computeFactorial(4));
	}
	
	/*
	 * Computes the factorial of the given integer.
	 * Parameters:
	 * 	number; integer; an integer value whose factorial will be computed
	 * Return:
	 * 	integer; the factorial of number
	 */
	public static int computeFactorial(int number) {
		if(number == 1) {
			return 1;
		}else {
			return computeFactorial(number - 1) * number;
		}
	}
}
