package com.revature.homework1;
//James Whitten

public class Question15 implements Calculator {

	//Our main
	public static void main(String[] args) {
		
		//Creating the Question15 object
		Question15 q15 = new Question15();
		//test cases
		System.out.println("3.2 + 7.1 = " +  q15.addition(3.2, 7.1));
		System.out.println("11.9 - 2.22 = " +  q15.subtraction(11.9, 2.22));
		System.out.println("1337 * 7331 = " + q15.multiplication(1337.0, 7331.0));
		System.out.println("54321 / 12345 = " + q15.division(54321.0, 12345.0));
	}

	//Addition method
	@Override
	public double addition(double num1, double num2) {
		
		return num1 + num2;
	}

	//Subtraction method
	@Override
	public double subtraction(double num1, double num2) {
		
		return num1 - num2;
	}

	//Multiplication method
	@Override
	public double multiplication(double num1, double num2) {
		
		return num1 * num2;
	}

	//Division method
	@Override
	public double division(double num1, double num2) {
		
		return num1 / num2;
	}
	
}
