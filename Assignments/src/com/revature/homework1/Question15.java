package com.revature.homework1;

public class Question15 {
	public static void main(String[] args) {
		ICalculations myCalc = new ICalculations();
		int a = 9, b = 3;
		System.out.println("Addition: " + myCalc.add(a, b));
		System.out.println("Subtraction: " + myCalc.subtract(a,  b));
		System.out.println("Multiplication: " + myCalc.multiply(a,  b));
		System.out.println("Division: " + myCalc.divide(a, b));
	}
}

interface Calculation{
	public int add(int a, int b);
	
	public int subtract(int a, int b);
	
	public int multiply(int a, int b);
	
	public int divide(int a, int b);
}

class ICalculations implements Calculation{
	public int add(int a, int b) {
		return a + b;
	}
	
	public int subtract(int a, int b) {
		return a - b;
	}
	
	public int multiply(int a, int b) {
		return a * b;
	}
	
	public int divide(int a, int b) {
		return a / b;
	}
}