package com.revature.homework1;

/*
 * Reverse a string without using a temporary variable. Do NOT use reverse() in the
StringBuffer or the StringBuilder APIs.
 */

public class Question3 {
	private String original;
	private String reversed;
	
	public Question3() {
		original = "";
		reversed = "";
	}
	
	public Question3(String original) {
		this.original = original;
	}
	
	private void reverseStr() {
		reversed = "";
		for(int i = original.length()-1; i >= 0; i--) {
			reversed.concat(((Character)(original.charAt(i))).toString()); 
		}
		// Concatenate the string version of the boxed char at that location
	}

	public String getReversed() {
		reverseStr();
		return reversed;
	}

	public void setOriginal(String original) {
		this.original = original;
	}
}
