package calculator;

import java.util.Scanner;

public class Calculator {
	
	private static Scanner input = new Scanner(System.in);
	
	public static void performAddition() {
		do {
			try {
				System.out.println("Enter the first number to be added: ");
				String stringA = input.nextLine();
				double a = Double.parseDouble(stringA);
				
				System.out.println("Enter the second number to be added: ");
				String stringB = input.nextLine();
				double b = Double.parseDouble(stringB);
				
				System.out.println("Answer: " + (a + b));
				return;
				
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		} while (true);
	}
	
	public static void performSubtraction() {
		do {
			try {
				System.out.println("Enter the number that will be subtracted from: ");
				String stringA = input.nextLine();
				
				double a = Double.parseDouble(stringA);
				System.out.println("Enter the subtraction value: ");
				
				String stringB = input.nextLine();
				double b = Double.parseDouble(stringB);
				
				System.out.println("Answer: " + (a - b));
				return;
				
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		} while (true);
	}
	
	public static void performMultiplication() {
		do {
			try {
				System.out.println("Enter the first number to be multiplied: ");
				String stringA = input.nextLine();
				
				double a = Double.parseDouble(stringA);
				System.out.println("Enter the second number to be multiplied: ");
				
				String stringB = input.nextLine();
				double b = Double.parseDouble(stringB);
				
				System.out.println("Answer: " + (a * b)); 
				return;
				
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		} while (true);
	}
	
	public static void performDivision() {
		do {
			try {
				System.out.println("Enter the number to be divided: ");
				String stringA = input.nextLine();
				
				double a = Double.parseDouble(stringA);
				System.out.println("Enter the value of the divisor: ");
				
				String stringB = input.nextLine();
				double b = Double.parseDouble(stringB);
				
				if (b == 0) {
					System.out.println("Cannot divide by 0!");
					return;
				}
				
				System.out.println("Answer: " + (a / b));
				return;
				
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		} while (true);
	}
}
