//Done!

package com.revature.homework1;

public class Question4 {
	public static int factorial(int n)
	{
		int product = 1;
		//Multiply product by the current index i in the for-loop
		for(int i = 1; i <= n; i++) {
			product *= i;
		}
		return product;
	}
	
	public static void main(String[] args) {
		//CHANGE VALUE OF n HERE
		int n = 5;
		System.out.println(n + "! = " + Question4.factorial(n));
	}
}
