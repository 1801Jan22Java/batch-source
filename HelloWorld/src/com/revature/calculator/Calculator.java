package com.revature.calculator;
import java.util.Scanner;

/*
 * Build a calculator!
 * Use int or double values
 * +, -, *, / based on a SWITCH CASE
 * Obtain the desired operation and numbers to be used
 * from user input via the Scanner
 */
public class Calculator {
	
	//Add
	public static double add(double first, double second) {
		return first + second;
	}
	
	
	//Subtract
	public static double subtract(double first, double second) {
		return first - second;
	}
	
	
	//Multiply
	public static double multiply(double first, double second) {
		return first * second;
	}
	
	
	//Divide
	public static double divide(double first, double second) {
		return first / second;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	//Create the Scanner object
		String operator;						//Create a String object to hold the operator symbol
		
		System.out.println("Enter the first operand: ");
		double first = sc.nextDouble();
		sc.nextLine();							//Newline character will be scanned in next if we don't clear the buffer.
		
		//Make sure the symbol entered here is valid
		do {
			System.out.println("Enter the desired operator: ");
			operator = sc.nextLine();
		} while(!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/"));
		
		System.out.println("Enter the second operand: ");
		double second = sc.nextDouble();
		
		
		double result = 0;
		
		switch(operator) {
		case "+": result = add(first,second); System.out.println(first + " + " + second + " = " + result); break;
		case "-": result = subtract(first,second); System.out.println(first + " - " + second + " = " + result); break;
		case "*": result = multiply(first,second); System.out.println(first + " * " + second + " = " + result); break;
		case "/": result = divide(first,second); System.out.println(first + " / " + second + " = " + result); break;
		}
		
		sc.close();
	}
}
