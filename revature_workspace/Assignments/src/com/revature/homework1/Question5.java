package com.revature.homework1;

/*
 * Q5. Write a substring method that accepts a string str and an 
 * integer idx and returns the substring contained between 0 and idx-1 inclusive.
 *  Do NOT use any of the existing substring methods in the String, StringBuilder,
 *   or StringBuffer APIs.
 * */

public class Question5 {
	
	public static String subStrang(String a, int index)
	{
		String result="";
		char[] charArr=a.toCharArray();
		try{
		for(int i =0; i<=index-1;i++)
		{
			result+=charArr[i];
		}
		}
		catch(IndexOutOfBoundsException e)
		{
			result="The index you entered is out of bounds";
			
		}
		finally
		{
		return result;
		}
		
	}
	public static void main(String [] args)
	{
		String subbed = subStrang("hello",6);
		String subbed2 = subStrang("hello world",5);
		System.out.println(subbed2);
	}

}
