package com.revature.homework1;

/*
 * Write a program to display the first 25 Fibonacci numbers beginning at 1.
 */

public class Question2 {
	private long m;
	private long n;
	private long x;
	
	public Question2() {
		m = 1; // F(n-1)
		n = 1; // F(n-2)
		x = 0; // F(n) , starting off at 0 for the for loop to function properly
		
	}
	
	public long getNext() {
		
		x = m + n;
		n = m;
		m = x;
		return x;
	}
}
