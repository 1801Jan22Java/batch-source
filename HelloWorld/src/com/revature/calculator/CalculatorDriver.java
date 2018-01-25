package com.revature.calculator;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CalculatorDriver {

	/*
	 * build a calculator
	 * calculate int or double values
	 * +, -, *, / (use switch case)
	 * obtain the desiered operation + numbers to be used from
	 * user input via the scanner
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		double left;
		String sym;
		double right;
		
		StringTokenizer st;
		
		String input;
		Scanner scan2;
		
		do {
			input = scan.nextLine();
			
			if (input.toLowerCase().equals("quit") || input.toLowerCase().equals("q")) {
				break;
			}
			
			
			if (input.contains("+")) {
				st = new StringTokenizer(input, "+-*/ \t\n\r\f");
				sym = "+";
			}else if (input.contains("-")) {
				st = new StringTokenizer(input, "+-*/ \t\n\r\f");
				sym = "-";
			}else if (input.contains("/")) {
				st = new StringTokenizer(input, "+-*/ \t\n\r\f");
				sym = "/";
			}else if (input.contains("*")) {
				st = new StringTokenizer(input, "+-*/ \t\n\r\f");
				sym = "*";
			}else {
				System.out.println("invalid input");
				continue;
			}
			
			if (!st.hasMoreTokens()) {
				System.out.println("invalid input");
				continue;
			}
			
			scan2 = new Scanner(st.nextToken());
			left = scan2.nextDouble();
			
			if (!st.hasMoreTokens()) {
				System.out.println("invalid input");
				continue;
			}
			
			scan2 = new Scanner(st.nextToken());
			right = scan2.nextDouble();
		
			doOperation(left, sym, right);
		}while(true);
	}
	
	public static void doOperation(double left, String symbol, double right) {
		switch (symbol) {
		case "+":
			System.out.println("= " + addWithGenerics(new Double(left), new Double(right)));
			break;
		case "-":
			System.out.println(left - right);
			break;
		case "*":
			System.out.println(left * right);
			break;
		case "/":
			if (right == 0) {
				System.out.println("Cannot divide by zero");
			} else {
				System.out.println(left / right);
			}
			break;
		default:
			System.out.println("Not Defined");
			break;
		}
	}
	//Without gennerics
	//compiles but thorws exception if a non-double is passed in or returned
	public static Number addWithoutGenerics(Number n1, Number n2) {
		return (Double)n1 + (Double)n2;
	}
	
	//with generics
	public static <T> Number addWithGenerics(T n1, T n2) {
		Number result = null;
		if (n1 instanceof Double && n2 instanceof Double) {
			result = ((Double) n1).doubleValue() + ((Double) n2).doubleValue();
		}
		
		return result;
	}

}
