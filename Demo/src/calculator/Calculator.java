package calculator;

import java.util.Arrays;
import java.util.Scanner;


public class Calculator {

	// Calculation engine
	private static double calculate(Double a, Double b, String operand) {
		switch(operand) {
			case "+":
				return a+b;
			case "-":
				return a-b;
			case "/":
				try {
					if(b!=0) {return a/b;}
					else {
						throw new ArithmeticException("Divide by 0");
					}
				}
				catch (Exception e) {
					System.out.println("Cannot divide by 0" + e.toString());
				}

			case "*":
				return a*b;
			default:
				return 0;
		}
		
	}
	
	public static Double input() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		
		String [] numbers = new String[10];
		String operand = "";

		String operation = input.replace("\\s", "");
		
		if(operation.indexOf("*")!=-1) {
			numbers = operation.split("\\*");
			operand = "*";
		}
		else if(operation.indexOf("+")!=-1) {
			numbers = operation.split("\\+");
			operand = "+";
		}
		else if(operation.indexOf("-")!=-1) {
			numbers = operation.split("\\-");
			operand = "-";
		}
		else if(operation.indexOf("/")!=-1) {
			numbers = operation.split("\\/");
			operand = "/";
		} else {
			System.out.println("Operation not supported");
			return 0.0;
		}
		
		// Convert to double
		Double f = Double.parseDouble(numbers[0]);
		Double s = Double.parseDouble(numbers[1]);
		
		return calculate(f, s, operand);
	}
	
}
