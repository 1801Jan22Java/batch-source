package com.revature.homework1;
//James Whitten

public class Question18 extends StringManipulation{
	
	//Method for checking if a String has any uppercase letters
	@Override
	public boolean isUpper(String ourString) {
		
		return ourString.contains("A-Z+");
	}

	//Method for converting a String to all uppercase letters
	@Override
	public String lowerToUpper(String ourString) {
		String newString = ourString.toUpperCase();
		return newString;
	}

	//Method for converting a String to an integer and then adding 10
	@Override
	public int stringToInt(String ourString) {
		int ourInt;
		try{ourInt = Integer.valueOf(ourString) + 10;}
		catch (NumberFormatException e)
		{
			System.out.println("This string cannot be converted to an Integer.  The value is ");
			ourInt = -1;
		}
		return ourInt;
	}

	
	//Our main
	public static void main(String[] args) {
	
		//test cases
		//Creating the Question18 object
		Question18 q18 = new Question18();
		System.out.println(q18.isUpper("no uppercase here"));
		System.out.println(q18.isUpper("there is an Uppercase here"));
		System.out.println(q18.lowerToUpper("converting all letters to uppercase"));
		System.out.println(q18.lowerToUpper("coNveRtiNg SOME LetTers"));
		System.out.println("Converting '25' to integer and adding 10 to it: " + q18.stringToInt("25"));
		System.out.println("Converting '90' to integer and adding 10 to it: " + q18.stringToInt("90"));
		System.out.println("Converting a non-integer will fail:" + q18.stringToInt("cool"));
	}
}
