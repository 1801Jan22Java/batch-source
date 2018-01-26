package com.revature.homework1;
//Write a program that defines an interface having the
//following methods: addition, subtraction, multiplication, 
//and division.  Create a class that implements this 
//interface and provides appropriate functionality to carry 
//out the required operations. Hard code two operands in a test 
//class having a main method that calls the implementing class.

// Test class
public class Question15 {
	public static void main(String[] args) {
		BasicCalculator calculator = new BasicCalculator();
		
		// Testing the hard coded 2 numbers through all the methods
		System.out.println(calculator.add(9, 5));
		System.out.println(calculator.divide(9, 5));
		System.out.println(calculator.subtract(9, 5));
		System.out.println(calculator.multiply(9, 5));
	}
}
