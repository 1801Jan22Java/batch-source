package com.revature.wednesday;

import java.util.Scanner;

public class Calculator {
	
	private static double calculate(double a, double b, int op) {
		switch (op) {
			case 1: return a + b;
			case 2: return a - b;
			case 3: return a * b;
			case 4: return a / b;
			default: return 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please type your query in the form:\nx (op) y \nWhere x and y "
				+ "can be any number, and (op) can only be one of (+ - * /)");
		System.out.println("Please mind the spacing between the operator and the numbers");
		double a = sc.nextDouble();
		String opChoice = sc.next();
		int op;
		switch (opChoice) {
			case "+":
				op = 1;
				break;
			case "-":
				op = 2;
				break;
			case "*":
				op = 3;
				break;
			case "/":
				op = 4;
				break;
			default:
				System.out.println("Invalid operation");
				sc.close();
				return;
		}
		double b = sc.nextDouble();
		System.out.println();
		Double result = (Double) calculate(a, b, op);
		if (result.isInfinite() || result.isNaN()) {
			System.out.println("Math error!");
		} else {
			System.out.println("Your result is " + result);
		}
		sc.close();
	}

}
