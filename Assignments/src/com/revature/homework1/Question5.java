package com.revature.homework1;
//James Whitten

public class Question5 {

	//Creates a substring of str from index 0 to idx - 1
	char[] subStringBuilding(String str, int idx)
	{
		//Creates a character array of the size of the substring we want
		char[] ourSubString = new char[idx];
		//Creates a substring from 0 to the idx-1 location using a character array
		str.getChars(0, idx, ourSubString, 0);
		
		//Returns our substring!
		return ourSubString;
	}
	
	//Our main
	public static void main(String[] args)
	{
		//Creating the Question5 object
		Question5 q5 = new Question5();
		//Test cases
		char[] c1 = q5.subStringBuilding("Hello World", 6);
		char[] c2 = q5.subStringBuilding("Hello World", 1);
		char[] c3 = q5.subStringBuilding("I like to eat pie. That is right.", 20);
		//Printing out our test cases
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);	}
	
}
