package com.revature.homework1;
/*
 * Q15. Write a program that defines an interface having the following methods: 
 * addition, subtraction, multiplication, and division.  
 * Create a class that implements this interface and provides appropriate functionality to carry out the required operations. 
 * Hard code two operands in a test class having a main method that calls the implementing class.
 * */

interface Operatable  
{
	double add(double a, double b);
	double subtract(double a, double b);
	double multiply(double a, double b);
	double divide(double a, double b);
	
}

class Operation implements Operatable {

	@Override
	public double add(double a, double b) {
		
		return a+b;
	}

	@Override
	public double subtract(double a, double b) {
		return a-b;
	}

	@Override
	public double multiply(double a, double b) {
		return a*b;
	}

	@Override
	public double divide(double a, double b) {
		return a/b;
	}
}

public class Question15 {
	
	public static void main(String [] args)
	{
		Operation operator = new Operation();
		double addition=operator.add(5,6);
		double subtraction=operator.subtract(6,14);
		double division=operator.divide(8,3.2);
		double multiplication=operator.multiply(9.4,7);
		
		System.out.println(addition);
		System.out.println(subtraction);
		System.out.println(multiplication);
		System.out.println(division);
		
	}

}
