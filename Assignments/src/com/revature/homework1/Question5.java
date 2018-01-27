package com.revature.homework1;
/*Write a substring method that accepts a string str and an 
 * integer idx and returns the substring contained between 
 * 0 and idx-1 inclusive.  Do NOT use any of the existing 
 * substring methods in the String, StringBuilder, or 
 * StringBuffer APIs.
 */
public class Question5 {
	public static void main(String[] args) {
		String test = subString("Testing this String", 9);
		System.out.println(test);
	}
	
	public static String subString(String str, int idx) {
		// If index is the same as the length of the string or more
		// return the string
		if(idx >= str.length()) {
			return str;
		}
		
		String output = new String("");
		
		// Go through the string and stop at idx-1.
		for(int n=0; n<idx; n++) {
			output=output.concat(Character.toString(str.charAt(n)));
		}
		
		return output;
	}
}
