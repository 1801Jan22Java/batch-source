package com.revature.homework1;
/*
 * Write a program that defines an interface having the following methods: addition, subtraction, 
 * multiplication, and division.  Create a class that implements this interface and provides appropriate 
 * functionality to carry out the required operations. Hard code two operands in a test class having a main 
 * method that calls the implementing class.
 */
public class Question15 implements Question15Interface
{

	@Override
	public double addition(double a, double b) 
	{
		return a+b;
	}

	@Override
	public double subtraction(double a, double b) {
		
		return a-b;
	}

	@Override
	public double multiplication(double a, double b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public double dividion(double a, double b) {
		// TODO Auto-generated method stub
		return a/b;
	}

}
