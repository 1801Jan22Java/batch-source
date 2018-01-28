package com.revature.homework1;

/*
 * Write a substring method that accepts a string str and an integer idx and returns the
substring contained between 0 and idx-1 inclusive. Do NOT use any of the existing substring
methods in the String, StringBuilder, or StringBuffer APIs.
 */
public class Question5 {
	private String myStr;
	private String original;
	private int idx;
	
	public Question5(String str, int idx) {
		this.original = str;
		myStr = "";
		this.idx = idx;
	}
	
	public String doThing() {
		myStr = "";
		char[] chars = new char[idx];
		for(int i = 0; i < idx; i++) {
			chars[i] = original.charAt(i);
		}
		return new String(chars);
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

}
