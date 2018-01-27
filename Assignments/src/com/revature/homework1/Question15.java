package com.revature.homework1;


public class Question15 {

	public static void test1(ImplementMathOperations imo) {
		
		System.out.println(imo.addition(12.0, 9.0));

	}

	public static void test2(ImplementMathOperations imo) {
		
		System.out.println(imo.division(123.6, 1.24563));

	}

	public static void main(String[] args) {
		ImplementMathOperations imo = new ImplementMathOperations();
		test1(imo);
		test2(imo);
	}

}
