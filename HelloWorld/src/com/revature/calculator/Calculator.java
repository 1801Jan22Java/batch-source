package com.revature.calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
	//Calculate int or double values
	//use a switch case for +, -, *, /
	//Obtain the desired operation and numbers to be used
	//from user input via the scanner - LOOK THIS UP 
	//needs to convert a String input to a number
	
	
	//Calculate using an easier scan that just asks three separate questions.
	
	public static void calculate(double firstNum, String operation, double secNum) {
		double result = 0;
		
		switch(operation) {
			case "+": 
				result = (Double) addWithoutGenerics(firstNum, secNum);
				break;
			case "-": 
				result = firstNum - secNum;
				break;
			case "*": 
				result = firstNum * secNum;
				break;
			case "/": 
				result = firstNum / secNum;
				break;
			default:
				System.out.println("You entered the wrong operator");
				break;
		}
		System.out.println(firstNum + operation + secNum + " = " + result);	
	}
	
	//Calculates using a single string expression
	public static void calculateWithStrings(String firstNum, String secNum, String operation) {
		double result = 0;
		
		double firstValue = Double.parseDouble(firstNum);
		double secondValue = Double.parseDouble(secNum);
		
		switch(operation) {
			case "+": 
				result = firstValue + secondValue;
				break;
			case "-": 
				result = firstValue - secondValue;
				break;
			case "*": 
				result = firstValue * secondValue;
				break;
			case "/": 
				if(secondValue!=0) {
					result = firstValue / secondValue;
				}
				break;
			default:
				System.out.println("You entered the wrong operator");
				break;
		}
		if((operation.equals("/")) && (secondValue == 0.0)) {
			System.out.println("Can not divide by 0");
		} else {
			System.out.println(firstValue + operation + secondValue + " = " + result);	
		}
	}
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		//Asks for three questions, first number, operation, and second number.		
//		System.out.println("Enter the first number: ");
//		double first = sc.nextDouble();
//		System.out.println("Enter the operation symbol: ");
//		String operator = sc.next();
//		System.out.println("Enter second number: ");
//		double second = sc.nextDouble();
//		
//		calculate(first, operator, second);

		
		System.out.println("Enter your equation");
		String equation = sc.next();
		
		//Using regex, split the separate the digits with non-digits
		String[] nums = equation.split("[^\\d.]+");
		String[] operator = equation.split("[\\d.]+");
		//The operator array becomes ["," , "operator"]
		//calculateWithStrings(nums[0], nums[1], operator[1]);
		
		//Using different regex pattern
		String[] testRegex = equation.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
		calculateWithStrings(testRegex[0], testRegex[2], testRegex[1]);
		
		sc.close();
	
		
	}
	
	//without generics
	//compiles, but throws exception if a non-Double Number is passed in or return
	public static Number addWithoutGenerics(Number n1, Number n2) {
		return (Double) n1 + (Double) n2;
	}
	
	//With generics

}
