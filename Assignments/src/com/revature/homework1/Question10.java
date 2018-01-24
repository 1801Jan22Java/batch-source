package com.revature.homework1;
/*
 *  Find the minimum of two numbers using ternary operators.
 */
public class Question10 {
	public static void main(String[] args) {
		int x = 3;
		int y = 4;
		
		System.out.println("The min of " + x + " and " + y + " is " + min(x, y));
		
		x = 10;
		y = 9;
		System.out.println("The min of " + x + " and " + y + " is " + min(x, y));
		
		x = 9;
		y = 9;
		System.out.println("The min of " + x + " and " + y + " is " + min(x, y));
		
		x = -5;
		y = -2;
		System.out.println("The min of " + x + " and " + y + " is " + min(x, y));
		
		x = -88;
		y = -118;
		System.out.println("The min of " + x + " and " + y + " is " + min(x, y));
	}
	
	//Finds the min of the two numbers given. Just returns one of them if they are equal.
	public static int min(int x, int y) {
		return x < y ? x : y;
	}
}
