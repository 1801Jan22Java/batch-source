package com.revature.homework1;

/*
 * Reverse a string without using a temporary variable. Do NOT use reverse() in the
StringBuffer or the StringBuilder APIs.
 */

public class Question3 {
	private String original;
	
	public Question3(String original) {
		this.original = original;
	}
	
	public String getReversed() {
		char[] str = new char[original.length()];
		int len = original.length()-1;
		for(int i = 0; i < original.length(); i++) {
			str[len-i] = original.charAt(i);
		}
		return new String(str);
	}

	public void setOriginal(String original) {
		this.original = original;
	}
}
