package com.revature.homework1;



public class Question10 {
	
	public static double minimumNum(double n, double m) {
		// uses ternary operators to shorten what would of been an if-statement with a few more lines of code
		return (n<m) ? n : m;
	}
	
	public static void main(String[] args) {
		//prints the lower number using ternary operator
		System.out.println( minimumNum(30,500));
		System.out.println( minimumNum(32,5));
		System.out.println( minimumNum(90.3,90.5));
		
		
	}

}
