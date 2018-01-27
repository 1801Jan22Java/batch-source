package com.revature.homework1;

/*
 * Q5. Write a substring method that accepts a string str and an 
 * integer idx and returns the substring contained between 0 and idx-1 inclusive.
 *  Do NOT use any of the existing substring methods in the String, StringBuilder,
 *   or StringBuffer APIs.
 * */

public class Question5 {
	
	
	/*
	 * Takes in a string and an index and returns a substring up to and including index-1.
	 * 
	 * @param String a, int index
	 * @return String result
	 * */
	public String subString(String aString, int index)
	{
		String result="";
		char[] charArr=aString.toCharArray();
		try{
		//Iterates through character array converted from aString, starting with 0, and adds 
		// each character to String result up to the index
		for(int i =0; i<=index-1;i++)
		{
			result+=charArr[i];
		}
		}
		//Makes sure index is not out of bounds
		catch(IndexOutOfBoundsException e)
		{
			result="The index you entered is out of bounds";
			
		}
		
		finally
		{
		return result;
		}
		
	}

}
