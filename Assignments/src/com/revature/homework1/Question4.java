package com.revature.homework1;

/*
 * Write a program to compute N factorial
 */

public class Question4 {
	private long result;
	private long n;
	
	
	/**
	 * No-args constructor to ensure private members are greater than 0. 
	 */
	public Question4() {
		result = 1;
		n = 1;
	}
	
	public Question4(long n) {
		result = 1;
		this.n = n;
	}
	public void setN(long n) {
		this.n = n;
	}
	
	public long getResult() {
		result = computeFactorial(n);
		return result;
	}
	
	private long computeFactorial(long n) {
		
		if(n == 0) {
			return 1;
		}
		
		if(n > 1) {
			return n *= computeFactorial(n-1);
		}
		
		else 
			return 1;
	}

}
