package thingBuilding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Calculator {
	public static String operator ="";
	public static String[] parseLine(String line)
	{
		String[] arr = new String[3];
		if(line.contains("+"))
		{
			arr=line.split("+");
			operator = "+";
		}
		else if (line.contains("/"))
		{
			arr=line.split("/");
			operator="/";
			
		}
		else if(line.contains("*"))
		{
			arr=line.split("*");
			operator = "*";
		}
		else if(line.contains("-"))
		{
			arr=line.split("-");
			operator = "-";
		}
		return arr;
	}
	
	
	public static double convertStringToNumeric(String num)
	{
		double result = 0;
		Double number = Double.parseDouble(num);
		result = number;
		return result;
	}
	
	public static double calculate(ArrayList<Double> nums)
	{
		
		double result = 0.0;
		switch(operator)
		{
		case "/":  result = nums.get(0)/nums.get(1); break;
		case "*":  result = nums.get(0)*nums.get(1); break;
		case "+": result=nums.get(0)+nums.get(1); break;
		case "-":result=nums.get(0)-nums.get(1); break;
		}
		return result;
	}
	
	
	public static ArrayList<Double> getNum(String [] arr)
	{
		ArrayList<Double> result = new ArrayList<Double>();
		for(int i = 0;i<arr.length;i++)
		{
			try
			
			{
			Double num = Double.parseDouble(arr[i]);
			result.add(num);
			}
			catch(Exception e)
			{
				System.out.println("Cannot convert operator");
			}
	
		}
		return result;
	}
	
	/*public String selectOperator(String operation)
	{
			
	}*/
	
	public double calculateDouble(){
		double result = 0.0;
		
		return result;
		
	}
	
	
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		
		String operator = sc.nextLine();
		String operand = sc.nextLine();
		


		
	//	double a = convertStringToNumeric(num);
		//System.out.println(a);
	}

}
