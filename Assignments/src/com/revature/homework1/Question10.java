package com.revature.homework1;

import java.util.Scanner;

/*
 * Find the minimum of two numbers using ternary operators.
 */
public class Question10 
{
	//ternary operators: an operator that takes three arguments result = testStatement ? value1 : value2;
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);  
		System.out.println("What numbers are you comparing?");
		System.out.print("Number 1: ");
		double int1 = input.nextDouble();
		System.out.print("Number 2: ");
		double int2 = input.nextDouble();
		//if the statement is true, it returns the fist case, otherwise it returns the second case
		System.out.println("The smallest  number is "+ (int1<int2 ? int1:int2)+"!");
		input.close();
	}
}
