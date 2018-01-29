package com.revature.homework1;

/**
 * @author Calvin Milliron
 * Assignment: Write a program having a concrete ;subclass that inherits three abstract methods from a superclass.  
 * 		Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass:
 * 		1. 	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
 * 		2. 	Convert all of the lower case characters to uppercase in the input string, and return the result.
 * 		3. 	Convert the input string to integer and add 10, output the result to the console.
 * 		Create an appropriate class having a main method to test the above setup.
 * Status: Done
 */
public abstract class Question18Super {
	abstract public boolean containsUpper(String str);
	abstract public String toUpper(String str);
}
