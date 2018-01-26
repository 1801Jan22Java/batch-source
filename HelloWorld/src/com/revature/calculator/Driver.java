package com.revature.calculator;
/*
 * Calculate int or double
 * +, -, *, / using a switch case
 * 
 * 
 */
import java.util.Scanner;

public class Driver {
	private static int num1, num2, result;
	private static String a, b, operator;
	
	private static String getNumber()
	{
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		for(int i = 0; i<temp.length(); i++)
		{
			if(Character.isDigit(temp.charAt(i)))
			{
				continue;
			}
			else 
			{
				return "";
			}
		}
		return temp;
	}
	
	private static int add()
	{
		return   num1+num2;
	}
	
	private static int subtract()
	{
		return   num1-num2;
	}
	
	private static int multiply()
	{
		return   num1*num2;
	}
	
	private static int divide()
	{
		return   num1/num2;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Input first number");
		a = getNumber();
		if (a.equals(""))
		{
			System.out.println("invalid number");
			return;
		}
		num1 = Integer.parseInt(a);
		System.out.println("Input operand");
		operator = sc.nextLine();
		
		System.out.println("Input second number");
		b = getNumber();
		if (b.equals(""))
		{
			System.out.println("invalid number");
			return;
		}
		num2 = Integer.parseInt(b);
		
		switch (operator) {
		case "+": result = add(); break;
		case "-": result = subtract(); break;
		case "*": result = multiply(); break;
		case "/": result = divide(); break;
			default: System.out.println("invalid operator"); break;
			
			
		}
		System.out.println("Result is: " + result);
		
	}
	/* without generics
	public static Number add(Number n1, Number n2)
	{
		return (Double) n1+ n2;
	}
	*/
	/*
	public static <T> T addWithGenerics(T n1, T n2)
	{
		T result = null;
		if (n1 instanceof Double)
		{
			result = n1+n2
		}
	}
	*/

}
