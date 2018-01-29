package com.revature.inclassprojects;

import java.util.Scanner;

public class Calculator 
{
	
	public static void inputOpperation()
	{
		Scanner input = new Scanner(System.in);
		String answer ="";
		do
		{
			System.out.println("What opperation would you like to perform?");
			String opperation = input.next();
			System.out.print("Number 1:");
			double num1 = input.nextDouble();
			System.out.print("Number 2:");
			double num2 = input.nextDouble(); 
			System.out.print("The Answer is: ");
			switch(opperation.toLowerCase())
			{
				case "addition":
				case ("+"):
					System.out.println(addWithGenerics(num1,num2));
					break;
				case "subtraction":
				case "-":
					System.out.println(num1-num2);
					break;
				case "multiplication":
				case "*":
					System.out.println(num1*num2);
					break;
				case "division":
				case "/":
					System.out.println(num1/num2);
					break;
				default:
					System.out.println("(-_-* ) invalid opperation");
			}
			System.out.println("Would you like to continue?");
			answer = input.next();
		}
		while(!answer.toLowerCase().equals("no"));
		input.close(); 
	}
	
	//Without generics
	//Compiles but throws an exception if a non-double number is passes or returned
	public static Number add(Number n1, Number n2)
	{
		return (Double)n1 + (Double)n2;
	}
	//With generics
	//At least requires that both of the parameters are of the same type
	public static <T> Number addWithGenerics(T n1, T n2)
	{
		Number result = null;
		
		if(n1 instanceof Double && n2 instanceof Double)
		{
			result = (Double)n1 + (Double)n2;
		}
		return result;
	}
	
	
	
	
	
	public static void main(String args[])
	{
		inputOpperation();
		//System.out.println(add(new Double(1.0), new Double(2)));
	}
	
}
