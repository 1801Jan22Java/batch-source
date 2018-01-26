package com.revature.wednesday;
import java.util.Scanner;

/*
 * Building a calculator
 * calcualte int or double values
 * add, subtract, multiply, divide, in switch case
 * obtain desired operation and numbers from user input via scanner
 */


public class Calculator {
	int int1;
	int int2;
	int intRes;
	double double1;
	double double2;
	double doubleRes;
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		Scanner scanner = new Scanner(System.in);
		int precision;
		int operation = 1;
		System.out.println("Welcome to Leonard's calculator");
		
		do {
			System.out.print("Please select precision - Integer (1) or Double (2):  ");
			precision = scanner.nextInt();
		} while((precision != 1) && (precision != 2));
		
		do {
			System.out.println("Please enter the operation to perform");
			System.out.println("0 - Addition");
			System.out.println("1 - Subtraction");
			System.out.println("2 - Multiplication");
			System.out.println("3 - Division");
			System.out.print("Enter operation: ");
			operation = scanner.nextInt();
		} while((operation < 0) || (operation > 3));
		
		
		System.out.print("Enter operand 1: ");
		if(precision == 1) {
			calc.int1 = scanner.nextInt();
		}
		else {
			calc.double1 = scanner.nextDouble();
		}
		
		System.out.print("Enter operand 2: ");
		if(precision == 1) {
			calc.int2 = scanner.nextInt();
		}
		else {
			calc.double2 = scanner.nextDouble();
		}
		
		if(precision == 1) {
			switch (operation) {
			case 0:
				calc.intRes = calc.intAdd(calc.int1, calc.int2);
				System.out.println("Result is " + calc.intRes);
				break;
			case 1:
				calc.intRes = calc.intSubtract(calc.int1, calc.int2);
				System.out.println("Result is " + calc.intRes);
				break;
			case 2:
				calc.intRes = calc.intMultiply(calc.int1, calc.int2);
				System.out.println("Result is " + calc.intRes);
				break;
				
			case 3:
				if(calc.int2 == 0) {
					System.out.println("NO. You don't get to divide by zero.");
					break;
				}
				calc.intRes = calc.intDivide(calc.int1, calc.int2);
				System.out.println("Result is " + calc.intRes);
				break;
				
			default:
				System.out.println("Error in switch statement");
				break;
				
			}
		}
		else {
			switch (operation) {
			case 0:
				calc.doubleRes = calc.doubleAdd(calc.double1, calc.double2);
				System.out.println("Result is " + calc.doubleRes);
				break;
			case 1:
				calc.doubleRes = calc.doubleSubtract(calc.double1, calc.double2);
				System.out.println("Result is " + calc.doubleRes);
				break;
			case 2:
				calc.doubleRes = calc.doubleMultiply(calc.double1, calc.double2);
				System.out.println("Result is " + calc.doubleRes);
				break;
				
			case 3:
				if(calc.double2 == 0) {
					System.out.println("NO. You don't get to divide by zero.");
					break;
				}
				calc.doubleRes = calc.doubleDivide(calc.double1, calc.double2);
				System.out.println("Result is " + calc.doubleRes);
				break;
				
			default:
				System.out.println("Error in switch statement");
				break;
				
			}
		}
		scanner.close();
	}

	public static <T> Number addwithGenerics(T n1, T n2) {
		
		
		if(n1 instanceof Double && n2 instanceof Double) {
			Double result = ((Double) n1).doubleValue() + ((Double) n2).doubleValue();
			return result;
		}
		
		else if(n1 instanceof Integer && n2 instanceof Integer) {
			Integer result = (int) (((Integer) n1).intValue() + ((Integer) n2).intValue());
			return result;
		}
		
		else {
			return null;
		}
			
		
	}
	
	public int intAdd(int num1, int num2) {
		return num1 + num2;
	}
	
	public double doubleAdd(double num1, double num2) {
		return num1 + num2;
	}
	
	public int intSubtract(int num1, int num2) {
		return num1 - num2;
	}
	
	public double doubleSubtract(double num1, double num2) {
		return num1 - num2;
	}
	
	public int intMultiply(int num1, int num2) {
		return num1 * num2;
	}
	
	public double doubleMultiply(double num1, double num2) {
		return num1 * num2;
	}
	
	public int intDivide(int num1, int num2) {
		return num1 / num2;
	}
	
	public double doubleDivide(double num1, double num2) {
		return num1 / num2;
	}
}

