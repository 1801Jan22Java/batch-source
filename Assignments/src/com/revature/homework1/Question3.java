package com.revature.homework1;
//James Whitten

public class Question3 {

	//Reversing our string without reverse() functions or temporary variables
	void reverseString(String ourString)
	{
		//Print our original string
		System.out.println("Our original string is: " + ourString);
		
		//An array to iterate through changing our string one character at a time
		for (int i = 0; i < ourString.length(); i++)
		{
			//We move the first variable to the opposite side of the string and shift every other character
			ourString = ourString.substring(1, ourString.length() - i) + ourString.charAt(0) + ourString.substring(ourString.length() - i);
		}
		
		//Print out the reversed string
		System.out.println("Our reversed string is: " + ourString);
		
	}
	
	
	//Our main
	public static void main(String[] args)
	{
		//Creating the Question3 object
		Question3 q3 = new Question3();
		//Some test cases for the string reversal
		q3.reverseString("blah blah ha cool");		
		q3.reverseString("This is not a reversible statement!");
		
	}
	
}
