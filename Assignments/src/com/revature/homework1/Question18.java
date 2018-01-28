package com.revature.homework1;

public class Question18 {

	public static void main(String[] args) {
		// Write a program having a concrete; subclass that inherits three abstract methods from a
		//superclass. Provide the following three implementations in the subclass corresponding to the
		//abstract methods in the superclass:
		//1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any
		//are found.
		//2. Convert all of the lower case characters to uppercase in the input string, and return the
		//result.
		//3. Convert the input string to integer and add 10, output the result to the console.
		//Create an appropriate class having a main method to test the above setup.
		
		String inputString = "this is the string that will be USED to test";
		
		Child child = new Child();
		
		System.out.println(child.checkString(inputString) ? "String contains an uppercase Letter!"
				: "String does not contain an uppercase letter!");
		
		System.out.println("(String) Converted \"" + inputString + "\" to \"" + child.convertStringCase(inputString) + "\"");
		
		System.out.println("(Int) Converted \"" + inputString + "\" to \"" + child.convertStringInt(inputString) + "\"");
	}

}

class Child extends Parent{

	//1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any
			//are found.
	@Override
	boolean checkString(String str) {

		char[] characters = str.toCharArray();
		
		for(char c : characters) {
			//65 is A 90 is Z capitals will have a value 65 to 90
			if((int) c <= 90 && (int)c >= 65)
				return true;
		}
		
		return false;
	}

	//2. Convert all of the lower case characters to uppercase in the input string, and return the
	//result.
	@Override
	String convertStringCase(String str) {

		return str.toUpperCase();
	}
	
	//3. Convert the input string to integer and add 10, output the result to the console.
	@Override
	int convertStringInt(String str) {

		int value = 0;
		char[] characters = str.toCharArray();
		
		for(char c : characters) {
			value += (int)c;
		}
		
		return value + 10;
	}
	
}

abstract class Parent{
	abstract boolean checkString(String str);
	abstract String convertStringCase(String str);
	abstract int convertStringInt(String str);
}