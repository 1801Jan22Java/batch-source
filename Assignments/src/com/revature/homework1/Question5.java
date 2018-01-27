package com.revature.homework1;

public class Question5 {

	//Write a substring method that accepts a string str and an integer idx and returns the
	//substring contained between 0 and idx-1 inclusive. Do NOT use any of the existing substring
	//methods in the String, StringBuilder, or StringBuffer APIs.

	
	public static void main(String[] args) {
		
		String str = "No set a maple here help a mate son";
		
		int idx = 15;
		
		System.out.println(substring(str, idx));
		
	}

	//Get a substring of a string
	public static String substring(String str, int idx) {
		
		idx -=1;
		
		//Character arrays to handle the character modifications of the strings
		char[] chars = str.toCharArray();
		char[] chars2 = new char[idx];
		
		
		for(int i = 0; i < idx; i++) {
			chars2[i] = chars[i];
		}
		
		return new String(chars2);
	}
}
