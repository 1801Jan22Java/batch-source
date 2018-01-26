package com.revature.homework1;

/*
 * Write a program having a concrete subclass that inherits three abstract methods from a
superclass. Provide the following three implementations in the subclass corresponding to the
abstract methods in the superclass:
1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any
are found.
2. Convert all of the lower case characters to uppercase in the input string, and return the
result.
3. Convert the input string to integer and add 10, output the result to the console.
Create an appropriate class having a main method to test the above setup.
 */
public class Question18 extends Question18a{

	public Question18(String str) {
		super();
		this.str = str;
	}

	private String str;
	
	@Override
	public boolean findUpper() {
		
		for(int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if(c.isUpperCase(c));
				return true;
		}
		
		return false;
	}

	@Override
	public String allCaps() {
		
		return str.toUpperCase();
		
	}

	@Override
	public void stringToInt() {
		// TODO Auto-generated method stub
		
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
