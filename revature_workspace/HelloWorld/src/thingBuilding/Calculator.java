package thingBuilding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Calculator {
	public static String operator ="";
	public static double operate(int i, double a, double b){
		double result =0.0;
		switch(i)
		{
		case 1: result = a+b;break;
		case 2: result = a-b;break;
		case 3: result = a*b; break;
		case 4: result = a/b; break;
		}
		return result;
	}

	public static String showOperation(int a)
	{
		String result ="";
		switch(a){
		case 1: result="Addition"; break;
		case 2: result ="Subtraction"; break;
		case 3: result ="Multiplication"; break;
		case 4: result="Division"; break;
		default: result ="Invalid operation";
		}
		return result;
	}
	
	public static double convertStringToNumeric(String num)
	{
		double result = 0;
		Double number = Double.parseDouble(num);
		result = number;
		return result;
	}
	public static int convertStringToInt(String operator)
	{
		int result = 0;
		try
		{
			result = Integer.parseInt(operator);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Please enter a number value between 1 and 4");
		}
		finally
		{
			return result;
		}
	}
	
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please choose your operation: 1 for addition, 2 for subtraction,"
				+ "3 for multiplication, and 4 for division");
		String operator = sc.nextLine();
		int i =convertStringToInt(operator);
		while (i<0 || i>4)
		{
			System.out.println("You chose: " +showOperation(i));
			System.out.println("You must choose a valid option between 1 and 4");
			operator=sc.nextLine();
			i = convertStringToInt(operator);
		}
		System.out.println("You chose: " +showOperation(i));
		System.out.println("Please choose your first operand");
		String operand1 = sc.nextLine();
		double a = convertStringToNumeric(operand1);
		System.out.println("");
		System.out.println("Please choose your next operand");
		String operand2 = sc.nextLine();
		double b=  convertStringToNumeric(operand2);
		double result = operate(i,a,b);
		System.out.println(result);
		


		
	//	double a = convertStringToNumeric(num);
		//System.out.println(a);
	}

}
