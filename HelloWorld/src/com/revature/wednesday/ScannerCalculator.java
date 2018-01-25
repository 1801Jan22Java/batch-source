package com.revature.wednesday;

import java.util.Scanner;

public class ScannerCalculator {

	public static void main(String[] args) {
		userInput();
	}

	public static void userInput() {
		Scanner sc = new Scanner(System.in);

		System.out.println("What operation would you like to perform?");
		String operation = sc.nextLine();
		operation = operation.toLowerCase();

		System.out.println("Enter first number: ");
		String n1Input = sc.nextLine();

		System.out.println("Enter second number: ");
		String n2Input = sc.nextLine();

		try{
		Double n1 = Double.parseDouble(n1Input);
		Double n2 = Double.parseDouble(n2Input);
		Double result;
		switch (operation) {
		case "addition":
			result = (Double) addWithGenerics(n1,2);
			break;
		case "subtraction":
			result = n1-n2;
			break;
		case "multiplication":
			result = n1*n2;
			break;
		case "division":
			result = n1/n2;
			break;
		default:
			result = 0.0;
		}
		System.out.println("result = "+result);
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("invalid input, try again");
		}
		sc.close();
	}
	
	//without generics
	//compiles, but throws exception if a non-Double Number is passed in or returned
	public static Number addWithoutGenerics(Number n1, Number n2){
		return (Double) n1 + (Double) n2;
	}
	
	//with generics
	public static <T> Number addWithGenerics(T n1, T n2){
		Number result = null;
		
		if (n1 instanceof Double && n2 instanceof Double){
			result = ((Double) n1).doubleValue() + ((Double) n2).doubleValue();
		}
		return result;
	}

	
}