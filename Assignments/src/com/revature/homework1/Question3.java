package com.revature.homework1;

public class Question3 {

	public static void main(String[] args) {

		//Reverse a string without using a temporary variable. Do NOT use reverse() in the
		//StringBuffer or the StringBuilder APIs.

		String testString = "No set a maple here help a mate son";
		
		System.out.println(testString + "\nString reversed! \n" + reverseString(testString));
	}

	//Reverse the string
	public static String reverseString(String string){
		
		char[] chars = string.toCharArray();
		char[] chars2 = new char[string.length()];
		
		for(int i = 0; i < string.length(); i++) {
			
			chars2[i] = chars[string.length() - 1 - i];
		}
		
		string = new String(chars2);
		
		return string;
	}
}
