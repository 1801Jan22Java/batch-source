package com.revature.homework1;

import java.util.ArrayList;
import java.util.Scanner;

public class Question15Test 
{
	public static void main(String args[])
	{
		Scanner input=  new Scanner(System.in);
		String user = "";
		int i = 0;
		System.out.println("What numbers would you like to add?");
		double num1 = input.nextDouble();
		double num2 = input.nextDouble();
		Question15 q15 = new Question15();
		System.out.println(q15.addition(num1,num2));
		System.out.println("What numbers would you like to subtract?");
		double num3 = input.nextDouble();
		double num4 = input.nextDouble();
		System.out.println(q15.subtraction(num3,num4));
	}
}
