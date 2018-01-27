package com.revature.homework1;

public class Question18 
{
	public class SuperClass
	{
		public abstract boolean hasUpperCaseLetters(String s);
		
		public abstract String toUpperCase(String s);
		
		public abstract int toIntPlusTen(String s);
	}

	public class SubClass extends SuperClass
	{
		public boolean hasUpperCaseLetters(String s)
		{
			if("^(?=.*[A-Z])$")
				return true;
			return false;
		}
		
		public String toUpperCase(String s)
		{
			return s.toUpperCase();
		}
		
		public int toIntPlusTen(String s)
		{
			return Integer.parseInt(s) + 10;
		}
	}

}
