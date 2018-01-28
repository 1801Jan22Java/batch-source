package com.revature.homework1;

public class Question5 {
	public static void main(String[] args) {
		System.out.println(getSubstring("This is an example. You won't see this.", 18));
		getSubstring("tiny string", 400);
		getSubstring("What happens for a negative integer?", -2);
	}

	/*
	 * Returns the substring from 0 to idx - 1 inclusive.
	 * Parameters:
	 *  str; String; the str to have a substring recovered from.
	 *  idx: integer: a non-negative integer representing the index location where the substring will stop.
	 * Return:
	 *  String; the substring from 0 to idx - 1 inclusive.
	 * Throws:
	 *  IndexOutOfBoundsException 
	 */
	public static String getSubstring(String str, int idx) {
		if(idx < 0) {
			System.out.println("Negative integers are not a valid index.");
			return "";
		}
		
		char[] substring = new char[idx];
		for(int i = 0; i < idx; i++) {
			
			try {
				substring[i] = str.charAt(i);
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Index is larger than the given string.");
				return "";
			}
		}
		
		return String.copyValueOf(substring);
	}
}
