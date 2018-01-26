package com.revature.homework1;

import java.util.Scanner;

/*
 * Write a program that calculates the simple interest on the principal, rate of interest and number of years
 * provided by the user. Enter principal, rate and time through the console using the Scanner class.
 * Accrued amount = Principal*(1+ Rate* Time)
 */
public class Question17 
{
	public static double accruedInterest(double simInt, double rateOfInt,double numOfYears)
	{
		return simInt*(1+rateOfInt*numOfYears);
	}
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("This program will help you figure out how much interest you have accrued on your principal!");
		System.out.print("What is the interest on your principal?");
		double simInt = input.nextDouble();
		System.out.println();
		System.out.print("What is the rate of the interest on your principal?");
		double rateOfInt = input.nextDouble();
		System.out.println();
		System.out.print("How many years have you had your principal?");
		double numOfYears = input.nextDouble();
		System.out.println();
		System.out.println("The accrued interest on your principal is: "+accruedInterest(simInt, rateOfInt, numOfYears));
	}
}
