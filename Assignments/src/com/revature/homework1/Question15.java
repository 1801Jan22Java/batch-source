package com.revature.homework1;

/**
 * @author Calvin Milliron
 * Assignment: Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division.  
 * 		Create a class that implements this interface and provides appropriate functionality to carry out the required operations. 
 * 		Hard code two operands in a test class having a main method that calls the implementing class.
 * Status: Done
 */
public class Question15{

	public static void main(String[] args) {
		// Hard code two operands
		double v1 = 1.1;
		double v2 = 2.2;
		Calc cal = new Calc();
		System.out.println("The result of " + v1 + " + " + v2 + " = " + cal.addition(v1, v2));
		System.out.println("The result of " + v1 + " - " + v2 + " = " + cal.subtraction(v1, v2));
		System.out.println("The result of " + v1 + " * " + v2 + " = " + cal.multiplication(v1, v2));
		System.out.println("The result of " + v1 + " / " + v2 + " = " + cal.division(v1, v2));
	}
}

class Calc implements Question15Interface {
	@Override
	public double addition(double v1, double v2) {
		return v1 + v2;
	}
	@Override
	public double subtraction(double v1, double v2) {
		return v1 - v2;
	}
	@Override
	public double multiplication(double v1, double v2) {
		return v1 * v2;
	}
	@Override
	public double division(double v1, double v2) {
		return v2 / v2;
	}
}
