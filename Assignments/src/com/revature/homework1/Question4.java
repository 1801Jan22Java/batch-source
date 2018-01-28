package com.revature.homework1;

public class Question4 {
	public static int factorializer(int number) {
		int n = number;
		int product = 1;
		// for input number and every lesser integer
		for (int i = n; i > 0; i--) {
			// multiply current product by iterator
			product *= i;
		}
		return product;
	}
}
