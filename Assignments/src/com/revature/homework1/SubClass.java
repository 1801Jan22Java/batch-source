package com.revature.homework1;

public class SubClass extends SuperClass{

	//Checks to see if the string has upper case charcters
	@Override
	public boolean hasUppercase(String str) {
		char c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				return true;
			}
		}
		return false;
	}

	//Capitalizes all characters in the string
	@Override
	public String toUpperCase(String str) {
		return str.toUpperCase();
	}

	//Converts the string to an int then prints it out.
	@Override
	public void printAsInt(String str) {
		int result = 0;
		
		try {
			result = Integer.parseInt(str);
			result += 10;
			
			System.out.println("The integer value + 10 of \"" + str + "\" is " + result);
		}catch (NumberFormatException e) {
			System.out.println("\"" + str + "\" does not contain a parseable number");
		}
		
		
	}

	
	
}
