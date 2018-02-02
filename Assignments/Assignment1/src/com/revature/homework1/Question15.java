package com.revature.homework1;

import com.revature.homework1util.Question11Util;

public class Question15 {

	public static void main(String[] args) {
		// Write a program that defines an interface having the following methods: addition,
		//subtraction, multiplication, and division. Create a class that implements this interface and
		//provides appropriate functionality to carry out the required operations. Hard code two
		//operands in a test class having a main method that calls the implementing class.

		//Create an instance of operations class
		OperationsClass opc = new OperationsClass();
		
		//Print out a couple of the operations
		System.out.println("Addition: ");
		System.out.println("327 + 146 = " + opc.addition(347, 146));
		
		System.out.println("\nDivision: ");
		System.out.println("327 / 146 = " + opc.division(347, 146));
	}
	
}

	interface OperationsInterface{
		
		double addition(double num1, double num2);
		double subtraction(double num1, double num2);
		double multiplication(double num1, double num2);
		double division(double num1, double num2);
		
	}
	
	class OperationsClass implements OperationsInterface{
		
		@Override
		public double addition(double num1, double num2) {
			return num1 + num2;
		}

		@Override
		public double subtraction(double num1, double num2) {
			return num1 - num2;
		}

		@Override
		public double multiplication(double num1, double num2) {
			return num1 * num2;
		}

		@Override
		public double division(double num1, double num2) {
			return num1/num2;
		}

	}
