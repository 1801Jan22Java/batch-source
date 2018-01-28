package com.revature.homework1;

public class Question18 extends Question18Super {
	// checks for upperCase characters in string and returns true or false
	@Override
	public boolean hasUpper() {
		for (int i = 0; i < super.contents.length(); i++) {
			// uses Character.isUpperCase to check for upperCase letters
			if (java.lang.Character.isUpperCase(super.contents.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	// converts all lower case characters to upperCase and returns the result
	@Override
	public String toUpper() {
		// uses String.toUpperCase to convert all letters to upperCase
		return super.contents.toUpperCase();
	}

	// converts input string to an integer, adds 10 and outputs result to console
	@Override
	public void add10() {
		// uses Integer.parseInt to parse integer from string
		int number = Integer.parseInt(super.contents);
		System.out.println(super.contents + " + 10 = " + (number + 10) + "\n");
	}

	// constructor
	public Question18(String contents) {
		super(contents);
	}
}
