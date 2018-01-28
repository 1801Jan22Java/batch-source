package com.revature.homework1;

public class Question2 {
	
	public static void main(String[] args) {
		
		/*
		 * While the Fibonacci sequence is one of the favorite ways to introduce the idea of recursion,
		 * I've personally always found iterative solutions to be much more writable and readable.
		 */
		int first = 0;
		int second = 1;
		for(int i = 0; i < 25; i++) {
			System.out.println(first + "[" + i + "]");
			int next = first + second;
			first = second;
			second = next;
		}
	}
}
