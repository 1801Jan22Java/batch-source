package com.revature.homework1;

public class Question15 
{
	public interface Math
	{
		addition(int x, int y);
		
		subtraction(int x, int y);
		
		multiplication (int x, int y);
		
		division(int x, int y);
	}

	public class Implementer implements Math
	{
		public static int addition(int x, int y)
		{
			return x+y;
		}
		
		public static int subtraction(int x, int y)
		{
			return x-y;
		}
		
		public static int multiplication(int x, int y)
		{
			return x*y;
		}
		
		public static int division(int x, int y)
		{
			if(y != 0)
				return x/y;
			else
				throw new IllegalArgumentException("Argument 'divisor' is 0");
		}
	}
}
