package com.revature.homework1;

/**
 * Homework 1. Question 18. Inherit master.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question18 {
	
	/**
	 * Test method for testing exampleSubClass class
	 * 
	 * @return No return value
	 */
	private static void testClassBehaviour() {
		ExampleSubClass e = new ExampleSubClass();
		
		System.out.println("Testing...");
		
		// Testing checkUppercase
		assert e.checkUppercase("") == false;
		assert e.checkUppercase("a") == false;
		assert e.checkUppercase("A") == true;
		assert e.checkUppercase("abcdefg hijklmnop qrstuv wxyz") == false;
		assert e.checkUppercase("abcdefG hijklmnop qrstuv wxyz") == true;
		
		// Testing convertUppercase
		assert e.convertUppercase("").equals("");
		assert e.convertUppercase("a").equals("A");
		assert e.convertUppercase("ihAzAcarrOt").equals("IHAZACARROT");
		
		// Testing toInteger
		// No support for strings that are not actual numbers in string form
		assert e.toInteger("0") == 0;
		assert e.toInteger("23492342") == 23492342;
		
		System.out.println("All tests successful!");
	}

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		
		// Need to enable assertions for this
		testClassBehaviour();
		
	}

}

/**
 * Example abstract superclass
 * 
 * @author Ahmed Awwad
 *
 */
abstract class ExampleSuperClass {
	
	/**
	 * Returns true if s contains an uppercase character.
	 * 
	 * @param s The string to check
	 * @return true if s contains an uppercase character. false otherwise.
	 */
	public abstract boolean checkUppercase(String s);
	
	/**
	 * Returns a string in which all the letters of the given string are uppercase
	 * 
	 * @param s The string to convert to uppercase
	 * @return A string in which all the letters of the given string are uppercase
	 */
	public abstract String convertUppercase(String s);
	
	/**
	 * Converts the given string to an integer
	 * 
	 * @param s The string to convert to an integer
	 * @return The integer form of the given string
	 */
	public abstract int toInteger(String s);
	
}

/**
 * Example concrete subclass
 * 
 * @author Ahmed Awwad
 *
 */
class ExampleSubClass extends ExampleSuperClass {
	
	/**
	 * Returns true if s contains an uppercase character.
	 * 
	 * @param s The string to check
	 * @throws IllegalArgumentException if s is null
	 * @return true if s contains an uppercase character. false otherwise.
	 */
	public boolean checkUppercase(String s) {
		checkException(s);
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				// We found an upper case character
				return true;
			}
		}
		// We went through the string without finding any upper class character
		return false;
	}
	
	/**
	 * Returns a string in which all the letters of the given string are uppercase
	 * 
	 * @param s The string to convert to uppercase
	 * @throws IllegalArgumentException if s is null
	 * @return A string in which all the letters of the given string are uppercase
	 */
	public String convertUppercase(String s) {
		checkException(s);
		
		return s.toUpperCase();
	}
	
	/**
	 * Converts the given string to an integer. String given must only be decimal
	 * digits.
	 * 
	 * @param s The string to convert to an integer
	 * @throws IllegalArgumentException if s is null
	 * @return The integer form of the given string
	 */
	public int toInteger(String s) {
		checkException(s);
		
		return Integer.parseInt(s);
	}
	
	/**
	 * Checks for exceptions in various methods based on whether their parameters are
	 * null
	 * 
	 * @param s The string to check
	 * @throws IllegalArgumentException if s is null
	 * @return No return value
	 */
	private void checkException(String s) {
		if (s == null) throw new IllegalArgumentException();
	}
	
}
