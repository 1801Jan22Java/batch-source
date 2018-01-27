package com.revature.homework1;

public class Question5
{
	public static String substring(String str, int idx)
	{
		String result = "";
		if(idx < -1 || idx > str.length()-1)
			return result;
		else
		{
			for(int i = 0; i < idx-1; i++)
				result += str.charAt(i);
			return result;
		}
	}
}
