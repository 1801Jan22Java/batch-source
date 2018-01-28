package com.revature.homework1;

public class Question3 {
	public static String stringReverser(String string) {
		String s = string;
		int endOfString = s.length();
		// working backwards through the string from last char to first
		for (int i = (endOfString - 1); i >= 0; i--) {
			// takes the character at index and appends to string
			s += s.charAt(i);
		}
		// reassigns string to substring starting at point of reversal
		return s.substring(endOfString);
	}
}
