package com.revature.calc;

/*
 * Author: Calvin Milliron
 * Assignment: Calculate Ints or Double values
 * 		Use a switch case for addition, subtraction, multiplication, and division
 * 		Obtain numbers and operation to be calculated via Scanner
 */
import java.util.Scanner;
public class Driver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String first = new String();
		String operator = new String();
		String second = new String();
			while (true) {
				System.out.print("Please enter the first number: ");
				first = input.next();
				if (first.contains("[a-zA-Z]+")) {
					System.out.println("I'm Sorry, please only enter a number.");
					continue;
				} else { break; }
			}
			while (true) {
				System.out.print("Please enter an operator (+, -, *, /): ");
				operator = input.next();
				if (!operator.contains("+") && !operator.contains("-") && !operator.contains("*") && !operator.contains("/")) {
					System.out.println("I'm Sorry, that is not a valid operator.");
					continue;
				} else { break; }
			}
			while (true) {
				System.out.print("Please enter the second number: ");
				second = input.next();
				if (second.contains("[a-zA-Z]+")) {
					System.out.println("I'm Sorry, please only enter a number.");
					continue;
				} else { break; }
			}
			
			double firstDouble;
			double secondDouble;
			double resultDouble = 0.0;
			int firstInt;
			int secondInt;
			int resultInt = 0;
			
			if (first.contains(".") || second.contains(".")) {
				firstDouble = Double.parseDouble(first);
				secondDouble = Double.parseDouble(second);
				switch(operator) {
				case "+":
					resultDouble = Calc.add(firstDouble, secondDouble);
					break;
				case "-":
					resultDouble = Calc.subtract(firstDouble, secondDouble);
					break;
				case "*":
					resultDouble = Calc.multiply(firstDouble, secondDouble);
					break;
				case "/":
					resultDouble = Calc.divide(firstDouble, secondDouble);
					break;
				}
				System.out.println("The answer is: " + resultDouble);
			} else {
				firstInt = Integer.parseInt(first);
				secondInt = Integer.parseInt(second);
				switch(operator) {
				case "+":
					resultInt = Calc.add(firstInt, secondInt);
					break;
				case "-":
					resultInt = Calc.subtract(firstInt, secondInt);
					break;
				case "*":
					resultInt = Calc.multiply(firstInt, secondInt);
					break;
				case "/":
					resultInt = Calc.divide(firstInt, secondInt);
					break;
				}
				System.out.println("The answer is: " + resultInt);
			}
			
		
			
	}
}
