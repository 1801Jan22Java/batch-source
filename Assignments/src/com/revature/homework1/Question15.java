package com.revature.homework1;

public class Question15 {

	public static void main(String[] args) {

		int a = 10;
		
		int b = 2;
		
		System.out.println("operand 1: "+a);
		System.out.println("operand 2: "+b);
		
		compute c = new compute();
		
		System.out.println("addition "+c.addition(a, b));
		System.out.println("subtracttion "+c.subtraction(a, b));
		System.out.println("division "+c.division(a, b));
		System.out.println("multiplication "+c.multiplication(a, b));
	}
}

class compute implements calculate {

	public int addition(int a, int b) {
		
		return a+b;
	}

	public int subtraction(int a, int b) {
	
		return a-b;
	}

	public int division(int a, int b) {
		return a/b;
	}

	public int multiplication(int a, int b) {
		return a*b;
	}
}
