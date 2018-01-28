package com.revature.homework1;

/**
 * Created by: Jeffrey Rubi Date: 26 January 2018 
 * Write a program having a concrete subclass that inherits three abstract methods from a superclass. 
 * Provide the following three implementations in the subclass corresponding to the abstract methods in the 
 * superclass: 
 * 1. Check for uppercase characters in a string, and return 'true' or 'false' depending if any are found. 
 * 2. Convert all of the lower case characters to uppercase in the input string, and return the result. 
 * 3. Convert the input string to integer and add 10, output the result to the console. 
 * Create an appropriate class having a main method to test the above setup.
 */

public class Question18 {

	public static void main(String[] args) {
		
		// instantiate subclass
		Question18SubClass q18SubClass = new Question18SubClass();
		// display testing requirements 
		System.out.println("Checking for uppercase..." + q18SubClass.checkUppercase("Hello World"));
		System.out.println("Checking for uppercase..." + q18SubClass.checkUppercase("helloworld"));
		System.out.println("Coverting to uppercase..." + q18SubClass.capitalize("converted"));
		System.out.println("Coverting to uppercase..." + q18SubClass.capitalize("cOnvErteD"));
		q18SubClass.convertToIntPlusTen(10.1234);
		
		// polymorph
		Question18SuperClass poly = new Question18SubClass();
		// display testing requirements 
		System.out.println("Checking for uppercase..." + poly.checkUppercase("Hello World"));
		System.out.println("Checking for uppercase..." + poly.checkUppercase("helloworld"));
		System.out.println("Coverting to uppercase..." + poly.capitalize("converted"));
		System.out.println("Coverting to uppercase..." + poly.capitalize("cOnvErteD"));
		poly.convertToIntPlusTen(10.1234);
		
	}

}
