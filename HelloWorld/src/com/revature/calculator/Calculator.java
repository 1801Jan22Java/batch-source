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
	
/*
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
*/
	
	//Add without generics. Compiles but throws exception if non-Double number is passed in or returned
	public static Number add(Number n1, Number n2) {
		return (double)n1 + (double)n2;
	}

	//Subtract without generics
	public static Number subtract(Number n1, Number n2) {
		return (double)n1 + (double)n2;
	}

	//Multiply without generics
	public static Number multiply(Number n1, Number n2) {
		return (double)n1 + (double)n2;
	}

	//Divide without generics
	public static Number divide(Number n1, Number n2) {
		return (double)n1 + (double)n2;
	}
	
	
	//With generics
	
	public static <T extends Number> T addWithGenerics(T n1, T n2) {
		Double result = null;
		if(n1 instanceof Double && n2 instanceof Double) {
			//T doesn't work with addition
			result = n1.doubleValue() + n2.doubleValue();
		}
		return (T)result;
	}
	public static <T extends Number> T subtractWithGenerics(T n1, T n2) {
		Double result = null;
		if(n1 instanceof Double && n2 instanceof Double) {
			//T doesn't work with addition
			result = n1.doubleValue() - n2.doubleValue();
		}
		return (T)result;
	}
	public static <T extends Number> T multiplyWithGenerics(T n1, T n2) {
		Double result = null;
		if(n1 instanceof Double && n2 instanceof Double) {
			//T doesn't work with addition
			result = n1.doubleValue() * n2.doubleValue();
		}
		return (T)result;
	}
	public static <T extends Number> T divideWithGenerics(T n1, T n2) {
		Double result = null;
		if(n1 instanceof Double && n2 instanceof Double) {
			//T doesn't work with addition
			result = n1.doubleValue() / n2.doubleValue();
		}
		return (T)result;
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
		case "+": result = (double) addWithGenerics(first,second); System.out.println(first + " + " + second + " = " + result); break;
		case "-": result = (double) subtractWithGenerics(first,second); System.out.println(first + " - " + second + " = " + result); break;
		case "*": result = (double) multiplyWithGenerics(first,second); System.out.println(first + " * " + second + " = " + result); break;
		case "/": result = (double) divideWithGenerics(first,second); System.out.println(first + " / " + second + " = " + result); break;
		}
		
		sc.close();
	}
}
