package com.revature.wednesday;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter 1st value: ");
		double firstVal = input.nextDouble();
		System.out.println("Enter operand: ");
		String operand = input.next();
		System.out.println("Enter 2nd value: ");
		double secondVal = input.nextDouble();
		
		input.close();
		
		double result;
		
		switch(operand) {
			case "+": result = firstVal + secondVal; break;
			case "-": result = firstVal - secondVal; break;
			case "*": result = firstVal * secondVal; break;
			case "/": result = firstVal / secondVal; break;
			default: result = 0; break;
		}
		
		System.out.println("Answer: " + result);
	}
}
