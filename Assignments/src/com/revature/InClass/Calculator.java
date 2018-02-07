package com.revature.InClass;

import java.util.Scanner;

public class Calculator<T> {
	
	private static boolean flag = true;
	private static double operation;
	private static double num1;
	private static double num2;
	private static Scanner sc = new Scanner(System.in);
	
	private static void getInput() {
		//Scanner sc = ;
		
		System.out.println("Choose Desired Operation: \n (1): Addition \n (2): Subtraction \n (3): Multiplication \n (4): Division \n (5): Exit");
		System.out.print("\nDesired Operation: ");
		
		// need to make sure they enter an int
		operation = sc.nextDouble();
		
		if (operation < 1 || operation > 5) {
			System.out.println("Invalid operation choice. Try Again :)");
			return;
		}

		
		System.out.print("\nEnter first number: ");
		
		num1 = sc.nextDouble();
		
		System.out.print("\nEnter second number: ");
		
		num2 = sc.nextDouble();
		
	}
	
	private static void getAnswer() {
		
		String output = "";
		
		switch ((int)operation) {
		case 1:
			output = num1 + " + " + num2  + " = " + (add(num1,num2));
			break;
		case 2:
			output = num1 + " - " + num2  + " = " + (num1-num2);
			break;
		case 3:
			output = num1 + " * " + num2  + " = " + (num1*num2);
			break;
		case 4:
			output = num1 + " / " + num2  + " = " + (num1/num2);
			break;
		case 5:
			flag = false;
			break;
		default:
			return;
		}
		
		System.out.println(output);
		
		System.out.println("Press Any Key to Continue");
		
		String l = sc.next();
		
	}
	
	// without generics
	// compiles, but throws exception if a non-Double number is passed in or returned
	public static Number add(Number n1, Number n2) {
		return (Double)n1 + (Double) n2;
	}
	
	
	public static void main(String[]args) {
		
		while(flag) {
			getInput();
			getAnswer();
		}
		sc.close();

	}
	

}
