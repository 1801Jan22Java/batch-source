package com.revature.homework1;

public class Question2 {
	//Write a program to display the first 25 Fibonacci numbers beginning at 0.
	public static void main(String[] args) {
		
		int limit = 25;//How many numbers
		
		System.out.println("First " + limit + " numbers.");
		
		fibonacciSequence(limit);
		
		limit = 35;//next sequence
		
		System.out.println("First " + limit + " numbers.");
		
		fibonacciSequence(limit);
		
	}
	
	//Sets up the recursive method so it can execute
	public static void fibonacciSequence(int limit) {
		int start = 0;//Starting Number
		int next = 1;//the next number in the sequence
		
		//prints the first number
		System.out.println(start);
		
		fibonacciSequenceRecursiveHelper(start, next, limit);
	}
	
	//Recursive method that prints the sequence.
	public static void fibonacciSequenceRecursiveHelper(int last, int current, int limit) {
		System.out.println(current);
		
		//Subtracts one for each number printed
		limit--;
		
		//Checks to see if the limit has been reached
		if(0 >= limit) {
			return;
		}
		
		//next recursive call.
		fibonacciSequenceRecursiveHelper(current, last + current, limit);
		
	}
	
}
