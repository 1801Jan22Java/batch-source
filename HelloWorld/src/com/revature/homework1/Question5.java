package com.revature.homework1;

public class Question5 {

	public static void main(String[] args) {
		
		// Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  
		// Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
		System.out.println(subString("waterMelon",10));
	}
	
	public static String subString(String word, int idx) {
		
		if ( idx >= word.length()) {					// if the index number is bigger than length of the word, return the whole word
			return word;
		} else {
			String[] splitedStr = word.split("");		// split the given word
			StringBuffer sb = new StringBuffer();
			
			for (int i = 0 ; i < (idx); i++) {			
				sb.append(splitedStr[i]);
			}
			return sb.toString();
		}
		
	}
}
