package com.revature.homework1;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Reverse a string without using a temporary variable. Do NOT use reverse() in the
		//StringBuffer or the StringBuilder APIs.
		
		String revString = "Hello World";
		
		System.out.println(reverseString(revString));

	}
	
	public static String reverseString(String theReverse)
	{
		
		for(int i=0;i<theReverse.length();i++)
		{
			//Take out the first letter of the string and shift it to the end
			//Each iteration will take the first letter and move it in front of the letter
			//that was shifted before it
			theReverse = theReverse.substring(1, theReverse.length() - i)
					+ theReverse.substring(0,1)
					+ theReverse.substring(theReverse.length() - i, theReverse.length());
			System.out.println(theReverse);
		}
		
		return theReverse;
	}

}
