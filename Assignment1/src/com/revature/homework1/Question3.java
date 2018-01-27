package com.revature.homework1;

public class Question3 
{

	public static String reverse(String string)
	{
		String result = "";
		for(int i = string.length()-1; i >= 0; i--)
		{
			result += string.charAt(i);
		}
		return result;
	}
}
