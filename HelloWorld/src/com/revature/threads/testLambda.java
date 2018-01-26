package com.revature.threads;

public class testLambda {
	public static void main(String[] args) {
		
		testLambda tester = new testLambda();
		
		// Allows function defintion on the fly
		
		MathOperation addition = 		(a, b)->a+b;
		MathOperation subtraction =	 	(int a, int b)->a-b;
		MathOperation division = 		(a, b)->{return a/b;};
		MathOperation multiplication = 	(int a, int b)->a*b;

		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));
	}

	interface MathOperation {
		int operation(int a, int b);
	}
	
	public static int add(int x, int y) {
		return x+y;
	}
	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}
