package com.revature.homework1;

public class Question3 
{

	public static String reverse(String string)
	{
		String result = "";
		//starting from the last character of the string argument
		
		for(int i = string.length()-1; i >= 0; i--)
		{
			//append each character to result until the first 
			//character in the argument has been appended.
			result += string.charAt(i);
		}
		//Then, return the result
		return result;
	}
}
