package com.revature.homework1;

public class Question15 
{
	public static void printOperands()
	{
		Implementer i = new Implementer();
		System.out.println("Testing addition: 5 + 8: "+i.addition(5, 8));
		System.out.println("Testing addition: 5 - 8: "+i.subtraction(5, 8));
	}
}
interface Maths
{
	int addition(int x, int y);
	
	int subtraction(int x, int y);
	
	int multiplication (int x, int y);
	
	int division(int x, int y);
}

class Implementer implements Maths
{
	public int addition(int x, int y)
	{
		return x+y;
	}
	
	public int subtraction(int x, int y)
	{
		return x-y;
	}
	
	public int multiplication(int x, int y)
	{
		return x*y;
	}
	
	public int division(int x, int y)
	{
		if(y != 0)
			return x/y;
		else
			throw new IllegalArgumentException("Argument 'divisor' is 0");
	}
}