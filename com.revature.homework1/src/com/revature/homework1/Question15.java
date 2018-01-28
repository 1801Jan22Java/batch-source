package com.revature.homework1;

import java.util.Scanner;

public class Question15 implements CalculatorInt {

	//method to add two numbers
	public double addition(double x, double y)
	{
		double sum = 0d;
		
		sum = x + y;
		
		return sum;
	}
	
	//method to subtract to numbers
	public double subtraction(double x, double y)
	{
		double difference = 0d;
		
		difference = x - y;
		
		return difference;
	}
	
	//method to multiply two numbers
	public double multiplication(double x, double y)
	{
		double product = 0d;
		
		product = x * y;
		
		return product;
	}
	
	//method to divide two numbers
	public double division(double x, double y)
	{
		double quotient = 0d;
		
		quotient = x / y;
		
		return quotient;
	}
	
	public static void main(String[] args) {
		//Q15. Write a program that defines an interface having the 
		//following methods: addition,subtraction, multiplication, 
		//and division. Create a class that implements this interface and
		//provides appropriate functionality to carry out the required operations.
		//Hard code two operands in a test class having a main method that 
		//calls the implementing class.
		Scanner sc = new Scanner(System.in);
		Question15 testCalc = new Question15();
		double i, j;
		int option;
		
		//Creates menu for user to select an operation
		System.out.println("Enter the number of the operation to perform: ");
		System.out.println("[1]Addition   [2]Subtraction   [3]Multiplication   [4]Division");
		option = sc.nextInt();
		
		//switch case to determine the users desired operation
		switch(option)
		{
		//takes two numbers and calls the addition function using the Calculator interface
		case 1:
		{
			System.out.println("First Number: ");
			i = sc.nextInt();
			System.out.println("Second Number:");
			j = sc.nextInt();
			testCalc.addition(i, j);
			System.out.println("Sum: " + sum);
		}

		//takes two numbers and calls the subtraction function using the Calculator interface
		case 2:
		{
			System.out.println("First Number: ");
			i = sc.nextInt();
			System.out.println("Second Number:");
			j = sc.nextInt();
			testCalc.subtraction(i, j);
		}

		//takes two numbers and calls the multiplication function using the Calculator interface
		case 3:
		{
			System.out.println("First Number: ");
			i = sc.nextInt();
			System.out.println("Second Number:");
			j = sc.nextInt();
			testCalc.multiplication(i, j);
		}

		//takes two numbers and calls the division function using the Calculator interface
		case 4:
		{
			System.out.println("First Number: ");
			i = sc.nextInt();
			System.out.println("Second Number:");
			j = sc.nextInt();
			testCalc.division(i, j);
		}
		default:
			System.out.println("You didn't pick a operation!");
		}
		sc.close();
	}

	@Override
	public double multiplcation(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}


}
