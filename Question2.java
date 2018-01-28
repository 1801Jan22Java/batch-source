package com.revature.homework1;

public class Question2 {

	public static int fib(int n) {
	if(n<=25) {
		return n;
	}
		return fib(n-1) + fib(n-2);
	}
	public static void main(String[] args) {
		int n = 1;
		System.out.println(fib(n));
	}
}
