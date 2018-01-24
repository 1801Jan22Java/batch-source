package com.revature.homework1;

public class Question2 {
	//Write a program to display the first 25 Fibonacci numbers beginning at 0.
	public static void main(String[] args) {
		
		int start = 0;//Starting Number
		int limit = 25;//Howmany numbers
		int count = 1;//how many numbers have been printed
		int next = 1;//the next number in the sequence
		
		//prints the first number
		System.out.println(start);
		
		fibonacciSequence(start, next, count, limit);
		
	}
	
	//Recursive method that prints the sequence.
	public static void fibonacciSequence(int last, int current, int count, int limit) {
		System.out.println(current);
		
		//Checks to see if the limit a=has been reached
		if(count >= limit) {
			return;
		}
		
		count++;
		//next recursive call.
		fibonacciSequence(current, last + current, count, limit);
		
	}
	
}
