package com.revature.homework1;
/*
 * Write a substring method that accepts a string str and an integer idx and returns the substring 
 * contained between 0 and idx-1 inclusive.  
 * Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
 */
public class Question5 {
	public static void main(String[] args) {
		
		String str = "This is a string";
		int index = 9;
		
		System.out.println("mySubString(" + str + ", " + index +");" );
		System.out.println(mySubString(str, index));
		
	}
	
	public static String mySubString(String orig, int index) {
		
		//Makes sure we dont get any bad input
		if (orig == null) {
			throw new NullPointerException();
		}
		if (index >= orig.length() || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		//String to be returned
		String str = "";
		
		//Builds the sub string up to the specified index.
		for (int i = 0; i <= index ; i++) {
			str += "" + orig.charAt(i);
		}
		
		return str;
	}
}
