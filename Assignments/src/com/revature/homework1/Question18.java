package com.revature.homework1;

//Write a program having a concrete subclass that inherits three abstract
//methods from a superclass.  Provide the following three implementations 
//in the subclass corresponding to the abstract methods in the superclass:
//1.     Check for uppercase characters in a string, and return ‘true’ or 
//		‘false’ depending if any are found.
//2.     Convert all of the lower case characters to uppercase in the input 
//		string, and return the result.
//3.     Convert the input string to integer and add 10, output the result
//		to the console.
//		Create an appropriate class having a main method to test the above setup.

public class Question18 {

	public static void main(String[] args) {
		SubClass sub = new SubClass();
		
		// Check case upper string
		System.out.println("True: "+sub.checkUpper("This has an upper case."));
		
		// Check case lower only
		System.out.println("False"+sub.checkUpper("no upper case."));
		
		// Upper case everything
		System.out.println("Upper cased: "+sub.upperCaseAll("Upper CASE THIS"));
		
		// Add 10 to an Integerified String
		System.out.println("print out integer + 10: "+sub.stringToIntAddTen("10"));
		
		// Handles invalid inputs by returning an error message and 0
		System.out.println("print out error message, 0: "+sub.stringToIntAddTen("1afsdfasdf0"));

	}
}
