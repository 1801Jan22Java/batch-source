package com.revature.wednesday;

import java.util.Scanner;

/**
 * Assignment
 * Build a Calculator
 * Requirements:
 * 1. should use ints or doubles
 * 2. should be able to add, subtract, multiply, divide based on a switch case
 * 		-- you obtain the desired operation and numbers to be used from user input via a Scanner.
 * @author Eric
 *
 */
public class Calculator 
{
	public static int addInts(int x, int y)
	{
		return x + y;
	}

	public static double addDbls(double x, double y)
	{
		return x + y;
	}

	public static int subInts(int x, int y)
	{
		return x - y;
	}

	public static double subDbls(double x, double y)
	{
		return x - y;
	}

	public static int multiplyInts(int x, int y)
	{
		return x*y;
	}

	public static double multiplyDbls(double x, double y)
	{
		return x*y;
	}

	public static int divideInts(int x, int y) 
	{
		int result = 0;
		if(y == 0)
			throw new ArithmeticException();
		else if ( y < 0)
		{
			y = y*-1;
			result = x/y;
			result *= -1;
		}
		else
			result = x/y;
		return result;
	}

	public static double divideDbls(double x, double y)
	{
		double result = 0;
		try
		{
			if(y != 0)
				result = x/y;
			else if ( y < 0)
			{
				y = y*-1;
				result = x/y;
				result *= -1;
			}
		}
		catch(ArithmeticException e)
		{
			System.out.println("Cannot divide by zero");
		}
		return result;
	}

	public static void readInputs()
	{
		do
		{
			System.out.println("Enter your first number");
			input = sc.nextLine();
			if(input.matches("^\\d*\\.?\\d*$"))
			{
				validInput = true;
				x = input;
			}
		}while(!validInput);

		validInput = false;
		do
		{
			System.out.println("Enter your second number");
			input = sc.nextLine();
			if(input.matches("^-?\\d*\\.?\\d*$"))
			{
				validInput = true;
				y = input;
			}

		}while(!validInput);
	}

	public static  Scanner sc = new Scanner(System.in);
	public static String input = "";
	public static String x = "";
	public static String y = "";
	public static boolean validInput = false;

	public static void main(String args[])
	{
		boolean exit = false;
		while(!exit)
		{
			System.out.println("________________________________________________________________________________________________\n");
			System.out.println("Please enter a number, 1 through 4, corresponding to the desired arithmetic opertion below:\n");
			System.out.println("Enter \'+' for addition");
			System.out.println("Enter \'-' for subtraction");
			System.out.println("Enter \'*' for multiplication");
			System.out.println("Enter \'/' for division");
			System.out.println("Enter \'Exit' when you no longer want to use the calculator");
			System.out.println("\nEnter: ");

			input = sc.nextLine();
			if(input.equalsIgnoreCase("exit"))
				exit = true;
			else
			{
				switch(input)
				{
				case "+": 
					readInputs();
					if(!x.contains(".") && !y.contains("."))
						System.out.println(x + " + " + y + " = " + addInts(Integer.parseInt(x), Integer.parseInt(y)));
					else
						System.out.println(x + " + " + y + " = " + addDbls(Double.parseDouble(x), Double.parseDouble(y)));
					break;
				case "-":
					readInputs();
					if(!x.contains(".") && !y.contains("."))
						System.out.println(x + " - " + y + " = " + subInts(Integer.parseInt(x), Integer.parseInt(y)));
					else
						System.out.println(x + " - " + y + " = " + subDbls(Double.parseDouble(x), Double.parseDouble(y)));
					break;
				case "*":
					readInputs();
					if(!x.contains(".") && !y.contains("."))
						System.out.println(x + " * " + y + " = " + multiplyInts(Integer.parseInt(x), Integer.parseInt(y)));
					else
						System.out.println(x + " * " + y + " = " + multiplyDbls(Double.parseDouble(x), Double.parseDouble(y)));
					break;
				case "/":
					readInputs();
					if(!x.contains(".") && !y.contains("."))
						System.out.println(x + " / " + y + " = " + divideInts(Integer.parseInt(x), Integer.parseInt(y)));
					else
						System.out.println(x + " / " + y + " = " + divideDbls(Double.parseDouble(x), Double.parseDouble(y)));
					break;
				default: System.out.println("The value " + input + " is an invalid value. Please enter one of the options previously listed.");
				break;
				}
			}
		}
		sc.close();
		System.out.println("Turning off calculator...");
	}
}
