package com.revature.homework1;

public class Question5
{
	public static String substring(String str, int idx)
	{
		String result = "";
		//if the idx argument is not within the range
		//of the length of the string, return an empty string
		if(idx < -1 || idx > str.length()-1)
			return result;
		else
		{
			//append to result the starting character to
			//the character right before the specified index.
			for(int i = 0; i < idx-1; i++)
				result += str.charAt(i);
			//return result
			return result;
		}
	}
}
